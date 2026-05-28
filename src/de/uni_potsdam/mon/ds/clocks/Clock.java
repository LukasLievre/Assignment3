package de.uni_potsdam.mon.ds.clocks;


/**
 * This Class simulates a hardware clock.
 */
public class Clock extends Thread {

	private final long incrementTime;
	private final double drift;
	private long counter;
	private final String name;

	public Clock(String name, long incrementTime, double drift) {
		super("Clock " + name); //allocates a new thread object
		counter = 0L;
		this.incrementTime = incrementTime; //time between two clock ticks (in main(), it is 50 ms)
		this.drift = drift;
		this.name = name;
		this.start();
	}

	public synchronized long getTime() {
		// TODO: Implement/modify me!
		return (counter*incrementTime) + (long) (counter*(drift+1));
	}

	public synchronized void setTime(long time) {
		// TODO: Implement me!
		this.counter = time;
		}

	public void run() {
		// TODO: Implement me!
		//this method imitates the time
		while (true) {
			counter +=1;
			try {
				Clock.sleep(incrementTime);
			} catch (InterruptedException ignored) {
			}
		}
	}
}
