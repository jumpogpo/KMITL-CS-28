import java.io.*; 
import java.net.*;
import java.util.*; 
class UDPClient { 
   public static void main(String args[]) throws Exception { 
      Scanner inFromUser = new Scanner(System.in);
      DatagramSocket clientSocket = new DatagramSocket(); 
      InetAddress IPAddress = InetAddress.getByName("localhost"); 
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 
      System.out.print("Please enter words: ");
      String sentence = inFromUser.nextLine();
      sendData = sentence.getBytes();  
		DatagramPacket sendPacket = 
         new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
      clientSocket.send(sendPacket); 
      DatagramPacket receivePacket = 
         new DatagramPacket(receiveData, receiveData.length); 
      clientSocket.receive(receivePacket); 
      String modifiedSentence = new String(receivePacket.getData()); 
      System.out.println("FROM SERVER:" + modifiedSentence.trim()); 
	   clientSocket.close(); 
   } 
} 