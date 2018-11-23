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
	private double hungryTime = 0;

	private PhilosopherState state;
	private int timeInState = 0;

	private boolean isDebugging = false;

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
        eatingTime = randomGenerator.nextInt(1000);
        thinkingTime = randomGenerator.nextInt(1000);
		state = PhilosopherState.THINKING;
	}

	public void setIsDebugging(boolean b) {
	    isDebugging = b;
    }

	public int getId() {
		return id;
	}

	public double getAverageThinkingTime() {
		/* TODO
		 * Return the average thinking time
		 * Add comprehensive comments to explain your implementation
		 */
		return 0;
	}

	public double getAverageEatingTime() {
		/* TODO
		 * Return the average eating time
		 * Add comprehensive comments to explain your implementation
		 */
		return 0;
	}

	public double getAverageHungryTime() {
		/* TODO
		 * Return the average hungry time
		 * Add comprehensive comments to explain your implementation
		 */
		return 0;
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
		return thinkingTime;
	}

	public double getTotalEatingTime() {
		return eatingTime;
	}

	public double getTotalHungryTime() {
		return hungryTime;
	}

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
                if (checkState()) {
                    changeState();
                }
            }
		} catch (InterruptedException e) {
			System.out.printf("Thread %d interrupted\n", Thread.currentThread().getId());
		}
	}

	private boolean checkState() throws InterruptedException {
        switch (state) {
            case THINKING:
                timeInState++; break;
            case EATING:
                timeInState++; break;
            case HUNGRY:
                hungryTime++; break;
            default:
                break;
        }

        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }

        if (state == PhilosopherState.THINKING) {
            return timeInState > thinkingTime;
        } else if (state == PhilosopherState.EATING) {
            return timeInState > eatingTime;
        }
        return true;
    }

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
        log("Philosopher " + id + " is " + state);
        numberOfThinkingTurns++;
    }

    private void changeToEating() {
		if (!holdingChopStick(leftChopStick)) {
        	pickUpChopStick(leftChopStick);
        }

        if (holdingChopStick(leftChopStick)) {
            if (!holdingChopStick(rightChopStick)) {
                pickUpChopStick(rightChopStick);
            }
        }

        if (holdingChopStick(leftChopStick) && holdingChopStick(rightChopStick)) {
            state = PhilosopherState.EATING;
            log("Philosopher " + id + " is " + state);
            numberOfHungryTurns++;
            timeInState = 0;
        }
    }

    private void changeToThinking() {
        putDownChopStick(leftChopStick);
        putDownChopStick(rightChopStick);

        state = PhilosopherState.THINKING;
        log("Philosopher " + id + " is " + state);
        numberOfEatingTurns++;
        timeInState = 0;
    }

    private boolean holdingChopStick(ChopStick chopStick) {
	    return chopStick.currentUser() == id;
    }

    private void pickUpChopStick(ChopStick chopStick) {
        if (chopStick.myLock.tryLock()) {
            log("Philosopher " + id + " picked up ChopStick " + chopStick.getId());
            chopStick.pickUp(id);
        }
    }

    private void putDownChopStick(ChopStick chopStick) {
	    if (chopStick.currentUser() == id) {
            log("Philosopher " + id + " put down ChopStick " + chopStick.getId());
	        chopStick.putDown();
        }
    }

    private void log(String msg) {
        if (isDebugging) {
            System.out.println(msg);
        }
    }
}

