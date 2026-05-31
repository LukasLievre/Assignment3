package de.uni_potsdam.mon.ds.clocks.cristian;

import java.net.DatagramPacket;
import java.net.InetSocketAddress;

import de.uni_potsdam.mon.ds.clocks.Clock;
import de.uni_potsdam.mon.ds.communicationLib.VSDatagramSocket;

public class Timeclient implements Runnable {

	private Clock clock;
	private VSDatagramSocket clientSocket;
	private String name;
	private final static long delta = 1000; //maximum delta between two clocks
	private final static double maximal_drift_rate = 0.16d; // TODO: Correct me

	public Timeclient(Clock clock, InetSocketAddress address, String name) {
		this.clock = clock;
		clientSocket = new VSDatagramSocket(address);
		this.name = name;
	}

	public void run() {

		InetSocketAddress serverAddr = new InetSocketAddress("localhost", 4000);

		while (true) {
			try {
				// starting time
				long t0 = clock.getTime();
				DatagramPacket request = new DatagramPacket(new byte[1], 1, serverAddr);
				clientSocket.send(request);

				DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
				clientSocket.receive(response);

				// end point of measurement
				long t1 = clock.getTime();

				long serverTime = java.nio.ByteBuffer.wrap(response.getData(), 0, response.getLength()).getLong();

				// actual algorithm
				long rtt = t1 - t0;
				long newTime = serverTime + (rtt / 2);
				clock.setTime(newTime);

				// wait for the intervall
				Thread.sleep(3125); //answer for c but already computed (delta/2c)

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
