import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class UDPServer {
  public static void main(String args[]) throws Exception {

    DatagramSocket serverSocket = new DatagramSocket(9876);
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];

    try {
      while (true) {
        System.out.println("The server is waiting ");
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        sendData = formattedDateTime.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
      }
    } catch (Exception e) {
      System.out.println("An error occurred");
      serverSocket.close();
    }
  }
}