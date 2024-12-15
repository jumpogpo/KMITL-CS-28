import java.io.*;
import java.net.*;
import java.util.*;

class TCPClient {
    public static void main(String argv[]) throws Exception {
        Scanner inFromUser = null;
        Socket clientSocket = null;
        DataOutputStream outToServer = null;
        Scanner inFromServer = null;

        try {
            inFromUser = new Scanner(System.in);
            clientSocket = new Socket("localhost", 6789);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new Scanner(clientSocket.getInputStream());

            while (true) {
                System.out.print("enter number 1 (to end just press enter): ");
                outToServer.writeBytes(inFromUser.nextLine() + "\n");
                String responseOne = inFromServer.nextLine();

                if (responseOne.equals("Stop")) break;

                System.out.print("enter number 2 (to end just press enter): ");
                outToServer.writeBytes(inFromUser.nextLine() + "\n");
                String responseTwo = inFromServer.nextLine();
                
                if (responseTwo.equals("Stop")) break;
                System.out.println("The result is " + responseTwo);
            }
        } catch (IOException e) {
            System.out.println("Error occurred: Closing the connection");
        } finally {
            try {
                if (inFromServer != null)
                    inFromServer.close();
                if (outToServer != null)
                    outToServer.close();
                if (clientSocket != null)
                    clientSocket.close();
                if (inFromUser != null)
                    inFromUser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}