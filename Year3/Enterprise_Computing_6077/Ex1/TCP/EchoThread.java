import java.io.*;
import java.net.*;
import java.util.*;

public class EchoThread extends Thread {
   private Socket connectionSocket;

   public EchoThread(Socket connectionSocket) {
      this.connectionSocket = connectionSocket;
   }

   public void run() {
      int numberOne;
      Scanner inFromClient = null;
      DataOutputStream outToClient = null;

      try {
         inFromClient = new Scanner(connectionSocket.getInputStream());
         outToClient = new DataOutputStream(connectionSocket.getOutputStream());

         while (true) {
            String inputNumberOne = inFromClient.nextLine();

            try {
               numberOne = Integer.parseInt(inputNumberOne);
               outToClient.writeBytes("Next\n");
   
               String inputNumberTwo = inFromClient.nextLine();
   
               try {
                  int numberTwo = Integer.parseInt(inputNumberTwo);
                  outToClient.writeBytes(numberOne + numberTwo + "\n");
               } catch (NumberFormatException e) {
                  throw new NumberFormatException();
               }
            } catch (NumberFormatException e) {
               outToClient.writeBytes("Stop\n");
               break;
            }  
         }
      } catch (IOException e) {
         System.err.println("Closing Socket connection");
      } finally {
         try {
            if (inFromClient != null)
               inFromClient.close();
            if (outToClient != null)
               outToClient.close();
            if (connectionSocket != null)
               connectionSocket.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}