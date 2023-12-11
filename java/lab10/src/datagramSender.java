import java.net.*;
import java.io.*;

class datagramSender{
    public static void main(String[ ] args){
        try{
            InetAddress receiverHost = InetAddress.getByName("10.3.130.105");
            int receiverPort = Integer.parseInt("5000");
            String message = "Hi? my name is Davaasuren";
            DatagramSocket mySocket = new DatagramSocket( );
            byte[] buffer = message.getBytes( );
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverHost,
                    receiverPort);
            mySocket.send(packet);
            mySocket.close( );
        }
        catch(Exception e){ e.printStackTrace( ); }
    }
}