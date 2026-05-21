package de.uni_potsdam.mon.ds.clocks.cristian;

import java.net.InetSocketAddress;

import de.uni_potsdam.mon.ds.clocks.Clock;
import de.uni_potsdam.mon.ds.communicationLib.VSDatagramSocket;

public class Timeserver implements Runnable {

	private final Clock clock;
	private final VSDatagramSocket serverSocket;

	public Timeserver(Clock clock, InetSocketAddress address) {
		this.clock = clock;
		this.serverSocket = new VSDatagramSocket(address);
	}

	public void run() {
		// TODO: Implement me
	}
}
