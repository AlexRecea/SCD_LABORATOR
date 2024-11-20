import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    DatagramSocket socket = new DatagramSocket(1977);
    byte[] buffer = new byte[256];
    DatagramPacket packet = new DatagramPacket(buffer, 256);
    socket.receive(packet);
    InetAddress address = packet.getAddress();
    int port = packet.getPort();
    //get bytes
    buffer = ((new Date()
    packet = new DatagramPacket (buffer, 256, adress, port);
    public Server() throws SocketException {
    }).toString)
}
