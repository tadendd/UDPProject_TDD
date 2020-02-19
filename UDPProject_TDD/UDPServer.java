  
package Programs;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;

public class UDPServer extends Thread{

    public static DatagramSocket socket = null;
    public static boolean run = true;

    static String q1 = "Programs must be written for people to read, and only incidentally for machines to execute.";
    static String q2 = "Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.";
    static String q3 = "Programming today is a race between software engineers striving to build bigger and better idiot-proof\r\n" + 
    		"programs, and the Universe trying to produce bigger and better idiots. So far, the Universe is winning.";
    static String q4 = "Any fool can write code that a computer can understand. Good programmers write code that humans can\r\n" + 
    		"understand.";
    static String q5 = "I am not a great programmer; I am just a good programmer with great habits.";
    static String q6 = "That's the thing about people who think they hate computers. What they really hate is lousy programmers.";
    static String q7 = "A language that does not affect the way you think about programming is not worth knowing.";
    static String q8 = "Walking on water and developing software from a specification are easy if both are frozen.";
    static String q9 = "Perl – The only language that looks the same before and after RSA encryption.";
    static String q10 = "The most important property of a program is whether it accomplishes the intention of its user.";
    static String q11 = "Programming isn't about what you know; it's about what you can figure out.";
    static String q12 = "The only way to learn a new programming language is by writing programs in it.";
    static String q13 = "Sometimes it's better to leave something alone, to pause, and that's very true of programming.";
    static String q14 = "\"In some ways, programming is like painting. You start with a blank canvas and certain basic raw materials.\r\n"
    		+ "You use a combination of science, art, and craft to determine what to do with them.";
    static String q15 = "Testing leads to failure, and failure leads to understanding.";
    static String q16 = "The best error message is the one that never shows up.";
    static String q17 = "The most damaging phrase in the language is... it's always been done this way.";
    static String q18 = "Don't write better error messages, write code that doesn't need them.";
    static String q19 = "There are two ways to write error-free programs; only the third one works.";
    static String q20 = "Deleted code is debugged code.";
    static String [] ServerQuotes = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20};
    static DatagramPacket sendPacket;
    static byte[] sendPacketData;
    static byte[] receivePacketData;
    static String Quotes;
	private static Scanner input;
	public UDPServer() throws SocketException {
        socket = new DatagramSocket(2020);
    }
 
    public static void runServer() throws IOException {
        run = true;
        int i = 0;
        Date d = new Date();
        System.out.println("Server Started: " + d + "\r\n") ;
        String ServerQuotes[]  = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20};
        for( i = 0; i < ServerQuotes.length; i++) {
            int portNumber = 2020;
            InetAddress address = InetAddress.getByName("192.168.1.77"); //Change this to your computer IP address.
        	
             DatagramSocket(portNumber,address);

        	System.out.print("Request Number\r\n" + i);
        	System.out.print(input);
        	
        	
        	System.out.print("\r\n" + ServerQuotes[i] + "\r\n");
        	sendPacketData = new byte [1024];
        	receivePacketData = new byte [1024];
            receivePacketData = ServerQuotes [i].getBytes();
            DatagramPacket packet 
              = new DatagramPacket(receivePacketData, receivePacketData.length);
           
            System.out.println(packet);

           receive(packet);

            String str = new String("REcieving Data");
            sendPacketData = str.getBytes();
            String str1 = new String ("Recieving");
	        System.out.println("Recieved: " + str1);
	        String receive = str1.toUpperCase();
	        sendPacketData = receive.getBytes();
	        DatagramPacket sendPacket = new DatagramPacket(sendPacketData, sendPacketData.length, address, portNumber);
	    
             System.out.println("Packet sent is from " + address + portNumber + " at " + d );
             System.out.print(sendPacket);
             
        	}
           
        
        while(i > ServerQuotes.length) {
        	socket.close();
        }
    }
    private static void receive(DatagramPacket packet) {
		// TODO Auto-generated method stub
		
	}

	private static void DatagramSocket(int portNumber, InetAddress address) {
		// TODO Auto-generated method stub
		
	}
}
