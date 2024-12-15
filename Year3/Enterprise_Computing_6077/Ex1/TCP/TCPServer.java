import java.io.*;
import java.net.*;

public class TCPServer {
   public static void main(String argv[]) {
      ServerSocket welcomeSocket = null;

      try {
         welcomeSocket = new ServerSocket(6789);

         while (true) {
            try {
               System.out.println("Waiting for client connection at port number 6789");
               Socket connectionSocket = welcomeSocket.accept();
               EchoThread echoThread = new EchoThread(connectionSocket);
               echoThread.start();
            } catch (IOException e) {
               System.out.println("Cannot create this connection");
            }
         }
      } catch (IOException e) {
         System.out.println("Cannot create a welcome socket");
         System.exit(1);
      }
   }
}