import java.io.*; 
import java.net.*; 
import java.util.*;
public class TCPConcurrentServer { 
   public static void main(String argv[])  { 
      String clientSentence; 
      String capitalizedSentence; 
      ServerSocket welcomeSocket = null;
      try {
         welcomeSocket = new ServerSocket(6789);
      }
      catch (IOException e) {
         System.out.println("Cannot create a welcome socket");
         System.exit(1);
      }
      while(true) {
         try {	 
            System.out.println("The server is waiting ");
			   Socket connectionSocket = welcomeSocket.accept(); 
			   EchoThread echoThread = new EchoThread(connectionSocket);
            echoThread.start();
         }
         catch (IOException e) {
            System.out.println("Cannot create this connection");
         }
      }
   } 
} 