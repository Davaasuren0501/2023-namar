import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(5000);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port:5000.");
            System.exit(-1);
        }

        while (listening)
            new Thread (new ClientHandler (serverSocket.accept())).start();

        serverSocket.close();
    }
}