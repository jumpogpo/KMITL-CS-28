package Iterative;
import java.io.*; 
import java.net.*; 
import java.util.*;
class TCPServer { 
   public static void main(String argv[])  { 
      String clientSentence; 
      String capitalizedSentence; 
      ServerSocket welcomeSocket = null;
      Socket connectionSocket = null;
      Scanner inFromClient = null;
	   DataOutputStream outToClient = null;
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
			   connectionSocket = welcomeSocket.accept(); 
			   inFromClient = new Scanner(connectionSocket.getInputStream());
			   outToClient = 
             	new DataOutputStream(connectionSocket.getOutputStream()); 
			   clientSentence = inFromClient.nextLine(); 
      	   capitalizedSentence = clientSentence.toUpperCase() + '\n'; 
      	   outToClient.writeBytes(capitalizedSentence);
         }
         catch (IOException e) {
            System.out.println("Error cannot create this connection");
         }
         finally {
            try {
               if (inFromClient != null)
                  inFromClient.close();
               if (outToClient != null)
                  outToClient.close();
               if (connectionSocket != null)
                  connectionSocket.close();
            }
            catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   } 
} 
