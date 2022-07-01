import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {
    public static void main(String[] args) throws IOException{
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
             String resp = in.readLine();
             out.println(String.format("Hi, %s ", resp));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

