import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String args[])
   {
     // BufferedReader inFromUser =
      //   new BufferedReader(new InputStreamReader(System.in)); para escribir lo que te de la gana
      int BYTE = 16384;
      try{
      DatagramSocket clientSocket = new DatagramSocket(); // Puse otro puerto distinto porque los probe en mi misma maquina
      InetAddress IPAddress = InetAddress.getByName("192.168.0.106");
      byte[] sendData = new byte[BYTE];
      byte[] receiveData = new byte[BYTE];

      String sentence = "";
      // EJERCICIO 1.1
      /*int byteMax = Integer.parseInt(args[0]) / 4;
      for (int i = 0; i < byteMax ; i++) {
        sentence = sentence + "Hola";
      }
      */

      // EJERCICIO 1.2
      sentence = args[0];

      //byte[] sentence = new byte[8193]; /*inFromUser.readLine();*/
      // ENVIO
      sendData = sentence.getBytes();
      System.out.println("Cliente: " + "Voy a enviar " + sendData.length + " bytes.");
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);


      //RESPUESTA
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("Servidor: " + modifiedSentence);

      clientSocket.close();
    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (SocketTimeoutException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
   }
}
