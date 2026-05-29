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
		counter = 0L; //own time of the clock
		this.incrementTime = incrementTime; //time between two clock ticks (in main(), it is 50 ms)
		this.drift = drift;
		this.name = name;
		this.start();
	}

	public synchronized long getTime() {
		// TODO: Implement/modify me!
		return this.counter;
	}

	public synchronized void setTime(long time) {
		// TODO: Implement me!
		this.counter = time;
		}

	public void run() {
		// TODO: Implement me!
		//this method imitates the time
		long timeDrift = (long)(incrementTime*(drift+1));
		while (true) {
			this.counter +=timeDrift;
			try {
				Clock.sleep(incrementTime);
			} catch (InterruptedException ignored) {
			}
		}
	}
}
