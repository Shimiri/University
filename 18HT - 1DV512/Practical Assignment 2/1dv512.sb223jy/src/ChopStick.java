import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
	private final int id;
	private int currentUser = -1;
	Lock myLock = new ReentrantLock();
	
	public ChopStick(int id) {
		this.id = id;
	}

	/* TODO
	 * Implement the pickup and put down chopstick logic
	 * Please note that the same chopstick can not be picked up by more than one philosopher at a time.
	 * Use the myLock to lock this chopstick. Print the logs only when the lock has been acquired. 
	 * The myLock.tryLock() method provides a boolean value indicating whether the lock was acquired or not.
	 */

	public int currentUser() {
	    return currentUser;
    }

    public int getId() {
	    return id;
    }

    public void pickUp(int id) {
	    currentUser = id;
	    myLock.lock();
    }

    public void putDown() {
	    currentUser = -1;
	    myLock.unlock();
    }
}
