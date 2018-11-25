import java.util.Random;

public class Philosopher implements Runnable {
	
	private int id;
	
	private final ChopStick leftChopStick;
	private final ChopStick rightChopStick;
	
	private Random randomGenerator = new Random();
	
	private int numberOfEatingTurns = 0;
	private int numberOfThinkingTurns = 0;
	private int numberOfHungryTurns = 0;

	private double thinkingTime;
	private double eatingTime;

	private double totalHungryTime;
	private double totalThinkingTime;
	private double totalEatingTime;

	private PhilosopherState state;

	private boolean isDebugging = false;
	private long timerStart;
	private long timerEnd;

	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick, int seed) {
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
		
		/*
		 * set the seed for this philosopher. To differentiate the seed from the other philosophers, we add the philosopher id to the seed.
		 * the seed makes sure that the random numbers are the same every time the application is executed
		 * the random number is not the same between multiple calls within the same program execution 
		 
		 * NOTE
		 * In order to get the same average values use the seed 100, and set the id of the philosopher starting from 0 to 4 (0,1,2,3,4). 
		 * Each philosopher sets the seed to the random number generator as seed+id. 
		 * The seed for each philosopher is as follows:
		 * 	 	P0.seed = 100 + P0.id = 100 + 0 = 100
		 * 		P1.seed = 100 + P1.id = 100 + 1 = 101
		 * 		P2.seed = 100 + P2.id = 100 + 2 = 102
		 * 		P3.seed = 100 + P3.id = 100 + 3 = 103
		 * 		P4.seed = 100 + P4.id = 100 + 4 = 104
		 * Therefore, if the ids of the philosophers are not 0,1,2,3,4 then different random numbers will be generated.
		 */

		randomGenerator.setSeed(id+seed);

		setEatingTime();
		setThinkingTime();

		state = PhilosopherState.THINKING;
	}

	public void setIsDebugging(boolean b) {
	    isDebugging = b;
    }

	public int getId() {
		return id;
	}

	/**
	 * When calculating the average values, each time an activity (eating or thinking)
	 * had finished the thinking or eating time is added to the total thinking or eating time.
	 * That value is then divided by the number of thinking or eating turns which results in the
	 * average value for each activity.
	 */

	public double getAverageThinkingTime() {
		/* TODO
		 * Return the average thinking time
		 * Add comprehensive comments to explain your implementation
		 */
		return Math.floor(getTotalThinkingTime() / numberOfThinkingTurns);
	}

	public double getAverageEatingTime() {
		/* TODO
		 * Return the average eating time
		 * Add comprehensive comments to explain your implementation
		 */
		return Math.floor(getTotalEatingTime() / numberOfEatingTurns);
	}

	public double getAverageHungryTime() {
		/* TODO
		 * Return the average hungry time
		 * Add comprehensive comments to explain your implementation
		 */
        return Math.floor(getTotalHungryTime() / numberOfHungryTurns);
	}
	
	public int getNumberOfThinkingTurns() {
		return numberOfThinkingTurns;
	}
	
	public int getNumberOfEatingTurns() {
		return numberOfEatingTurns;
	}
	
	public int getNumberOfHungryTurns() {
		return numberOfHungryTurns;
	}

	public double getTotalThinkingTime() {
		return totalThinkingTime;
	}

	public double getTotalEatingTime() {
		return totalEatingTime;
	}

	public double getTotalHungryTime() {
		return totalHungryTime;
	}


	private void setEatingTime() {
        eatingTime = randomGenerator.nextInt(1000);
    }

    private void setThinkingTime() {
        thinkingTime = randomGenerator.nextInt(1000);
    }

    /**
     * First the activity is simulated in doState, then after the philosopher is finished
     * with the current activity he changes state to the next one
     */
	@Override
	public void run() {
		/* TODO
		 * Think,
		 * Hungry,
		 * Eat,
		 * Repeat until thread is interrupted
		 * Increment the thinking/eating turns after thinking/eating process has finished.
		 * Add comprehensive comments to explain your implementation, including deadlock prevention/detection
		 */

		try {
            log("Philosopher " + id + " is " + state);
		    while (true) {
                doState();
                changeState();
            }
		} catch (InterruptedException e) {
			System.out.printf("Thread %d interrupted\n", Thread.currentThread().getId());
		}
	}

    /**
     * Simulates the philosopher activities by sleeping the thread for a time
     * depending on the value produced by the randomGenerator
     * @throws InterruptedException
     */
	private void doState() throws InterruptedException {
	    switch (state) {
            case THINKING:
                Thread.sleep((long)thinkingTime);
                break;
            case EATING:
                Thread.sleep((long)eatingTime);
                break;
            case HUNGRY:
                break;
            default:
                break;
        }

        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
    }

    /**
     * The state to change to is determined by which state the philosopher is currently in
     * @throws InterruptedException
     */
    private void changeState() throws InterruptedException {
	    switch (state) {
            case THINKING:
                changeToHungry(); break;
            case HUNGRY:
                changeToEating(); break;
            case EATING:
                changeToThinking(); break;
            default:
                break;
        }

        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
    }

    private void changeToHungry() {
        state = PhilosopherState.HUNGRY;
        numberOfThinkingTurns++;

        calculateThinkingTime();
        setThinkingTime();

        log("Philosopher " + id + " is " + state);
        timerStart = System.currentTimeMillis();
    }

    /**
     * To avoid deadlock, a special order in how to pick up the chopsticks was implemented.
     * The chopstick with the lowest ID is always picked up first, and the second chopstick
     * cannot be picked up if the philosopher doesn't hold the first one.
     */
    private void changeToEating() throws InterruptedException {
        ChopStick first = rightChopStick;
        ChopStick second = leftChopStick;

        if (second.getId() < first.getId()) {
            first = leftChopStick;
            second = rightChopStick;
        }

        while (!holds(first)) {
            pickUpChopStick(first);

            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
        }

        while (holds(first) && !holds(second)) {
            pickUpChopStick(second);

            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
        }

        if (holds(first) && holds(second)) {
            state = PhilosopherState.EATING;
            log("Philosopher " + id + " is " + state);
            numberOfHungryTurns++;
            timerEnd = System.currentTimeMillis();

            calculateHungryTime();
        }
    }


    private void changeToThinking() {
        putDownChopStick(rightChopStick);
        putDownChopStick(leftChopStick);

        state = PhilosopherState.THINKING;
        numberOfEatingTurns++;

        calculateEatingTime();
        setEatingTime();

        log("Philosopher " + id + " is " + state);
    }

    private void pickUpChopStick(ChopStick chopStick) {
        if (chopStick.tryPickUp(this)) {
            log("Philosopher " + id + " picked up ChopStick " + chopStick.getId());
        }
    }

    private void putDownChopStick(ChopStick chopStick) {
        if (chopStick.tryPutDown(this)) {
            log("Philosopher " + id + " put down ChopStick " + chopStick.getId());
        }
    }

    private boolean holds(ChopStick chopStick) {
	    return chopStick.isHeldBy(this);
    }

    /**
     * For calculating the hungry time, timerStart and timerEnd was used.
     * timerStart was set to the current time in milliseconds at the beginning of the hungry state.
     * When the state had finally changed to EATING, the timerEnd stored the current time in millis again.
     * Subtracting these two numbers results in the amount of time that has passed in the hungry state.
     */
    private void calculateHungryTime() {
	    totalHungryTime += (timerEnd - timerStart);
    }

    private void calculateEatingTime() {
	    totalEatingTime += eatingTime;
    }

    private void calculateThinkingTime() {
	    totalThinkingTime += thinkingTime;
    }

    private void log(String msg) {
        if (isDebugging) {
            System.out.println(msg);
        }
    }
}

