import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client extends Thread implements Serializable {

    DatagramSocket socket = new DatagramSocket();
    Scanner scanner = new Scanner(System.in);
    String mesaj = scanner.nextLine();

    byte[] citireBuffer = mesaj.getBytes();
    DatagramPacket packet = new DatagramPacket(citireBuffer, 256);
    socket.recive(packet);
    InetAddress adress = packet.getAddress();
    int port = packet.getPort();
    packet = new DatagramPacket(citireBuffer,256,adress,port);


    @Override
    public void run() {
        System.out.println("Client is running");
    }
}
// pentru server