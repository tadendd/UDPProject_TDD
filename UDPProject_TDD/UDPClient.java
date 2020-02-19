  
package Programs;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;



public class UDPClient extends UDPServer {
	
	 protected static DatagramSocket s1;
	    private static InetAddress UDPAddress;
	 
	    private static byte[] b1;
    	static byte [] sendPacketData = new byte [1024];
    	static byte [] receivePacketData = new byte [1024];
	    static String sendQuote = "Send a Quote:";
		private static java.net.DatagramSocket socket;
		public static boolean running;
	 
	    public UDPClient() throws SocketException, UnknownHostException {
	        s1 = new DatagramSocket();
	        UDPAddress = InetAddress.getByName("TadenPC");
	    }
	 
	    public static String sendClient() throws IOException {
	    	 for( int i = 0; i < ServerQuotes.length; i++) {
	    	b1 = new byte[256];
			sendPacketData = new byte [1024];
        	receivePacketData = new byte [1024];
        	sendPacketData = sendQuote.getBytes();
        	InetAddress address = InetAddress.getByName("192.168.1.77"); //change to Computer IP Address.
	        DatagramPacket receivePacket = new DatagramPacket(receivePacketData, receivePacketData.length);
	        socket = null;

	        String str = new String (receivePacket.getData());
	        System.out.println("Recieved: " + i  + " : " +ServerQuotes[i]);
	        address = receivePacket.getAddress();
	        int portNumber = receivePacket.getPort();
	        String receive = str.toUpperCase();
	        sendPacketData = receive.getBytes();
	        DatagramPacket sendPacket = new DatagramPacket(sendPacketData, sendPacketData.length, address, 2020);
	        Scanner input = new Scanner(System.in);
	        System.out.println("Enter a Request. ");
	        i = input.nextInt();
	        Date d = new Date();
	        System.out.println(ServerQuotes[i] + "\r\nRecieved on: " + d);

	        if(i == 22) {
	        	UDPClient.close();
	        }
	        	
			} return null;
	    }
	 
	    public static void close() {
	        s1.close();
	    }

		public String sendClient1(String msg) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public static void main (String[] args) throws IOException {
			
			
			runServer();
			
			sendClient();


		}

}