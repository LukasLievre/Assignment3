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
		super("Clock " + name);
		counter = 0L;
		this.incrementTime = incrementTime;
		this.drift = drift;
		this.name = name;
		this.start();
	}

	public synchronized long getTime() {
		// TODO: Implement/modify me!
		return 0;
	}

	public synchronized void setTime(long time) {
		// TODO: Implement me!
	}

	public void run() {
		// TODO: Implement me!
	}
}
