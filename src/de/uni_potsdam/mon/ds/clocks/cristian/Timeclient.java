package de.uni_potsdam.mon.ds.clocks.cristian;

import java.net.InetSocketAddress;

import de.uni_potsdam.mon.ds.clocks.Clock;
import de.uni_potsdam.mon.ds.communicationLib.VSDatagramSocket;

public class Timeclient implements Runnable {

	private Clock clock;
	private VSDatagramSocket clientSocket;
	private String name;
	private final static long delta = 1000;
	private final static double maximal_drift_rate = 0.0d; // TODO: Correct me

	public Timeclient(Clock clock, InetSocketAddress address, String name) {
		this.clock = clock;
		clientSocket = new VSDatagramSocket(address);
		this.name = name;
	}

	public void run() {
		// TODO: Implement me!
	}
}
