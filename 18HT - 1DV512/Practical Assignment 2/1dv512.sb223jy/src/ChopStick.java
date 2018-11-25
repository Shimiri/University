import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
	private final int id;
	private Philosopher currentUser;
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

    /**
     * @param p The philosopher to check
     * @return true if p is the currentUser
     */
    public boolean isHeldBy(Philosopher p) {
	    if (currentUser == null)
	        return false;
	    return currentUser.equals(p);
    }

    public int getId() {
	    return id;
    }

    /**
     * If the lock is acquired, meaning no other thread is currently using the lock,
     * then the Philosopher p becomes the current user of this ChopStick
     * @param p The philosopher that tries to use the ChopStick
     * @return true if the lock was acquired, false otherwise
     */
    public boolean tryPickUp(Philosopher p) {
        if (myLock.tryLock()) {
            try {
                currentUser = p;
                myLock.lock();
                return true;
            } finally {
                myLock.unlock();
            }
        }
        return false;
    }

    /**
     * If the lock is acquired, it means that the current thread is the current user of the ChopStick,
     * it makes the ChopStick free to use by another thread by unlocking the lock
     * @param p The philosopher that tries to put down the ChopStick
     * @return true if the lock was acquired, false otherwise
     */
    public boolean tryPutDown(Philosopher p) {
        if (myLock.tryLock()) {
            try {
                currentUser = null;
                myLock.unlock();
                return true;
            } finally {
                myLock.unlock();
            }
        }
        return false;
    }
}
