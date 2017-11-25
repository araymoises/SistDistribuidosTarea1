import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
     // BufferedReader inFromUser =
      //   new BufferedReader(new InputStreamReader(System.in)); para escribir lo que te de la gana
      int BYTE = 1024;
      DatagramSocket clientSocket = new DatagramSocket(); // Puse otro puerto distinto porque los probe en mi misma maquina
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[BYTE];
      byte[] receiveData = new byte[BYTE];
      String sentence = "Hola soy Java me reporto"; /*inFromUser.readLine();*/
      //RESPUESTA
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("Server: " + modifiedSentence);
      // ENVIO
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
      clientSocket.send(sendPacket);

      clientSocket.close();
   }
}