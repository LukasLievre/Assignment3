package de.uni_potsdam.mon.ds.clocks.cristian;

import java.net.DatagramPacket;
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
		while (true) {
			try {
				DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
				serverSocket.receive(packet); // Hier füllt Java die Absender-Adresse in 'packet'

				// current correct time
				long currentTime = clock.getTime();


				byte[] timeBytes = java.nio.ByteBuffer.allocate(8).putLong(currentTime).array();


				DatagramPacket response = new DatagramPacket(timeBytes, timeBytes.length, packet.getSocketAddress());
				serverSocket.send(response);

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
