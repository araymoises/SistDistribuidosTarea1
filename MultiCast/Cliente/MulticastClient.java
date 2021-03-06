import java.net.*;
import java.io.*;
public class MulticastClient{
	public static void main(String args[]){
	// args give message contents and destination multicast group (e.g. "228.5.6.7")224.1.1.1
		MulticastSocket s =null;
		try {
			InetAddress group = InetAddress.getByName(args[1]);
			s = new MulticastSocket(5007);
			s.joinGroup(group);
			byte [] m = args[0].getBytes();
			DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
			s.send(messageOut);
			byte[] buffer = new byte[1000];
			for(int i=0; i< 10000;i++) {		// get messages from others in group
				DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
				s.receive(messageIn);
				System.out.println("Received:" + new String(messageIn.getData()));
			}
			s.leaveGroup(group);
		}
		catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
		}
		catch (IOException e){
			System.out.println("IO: " + e.getMessage());
		}
		finally {if(s != null) s.close();}
	}
}
