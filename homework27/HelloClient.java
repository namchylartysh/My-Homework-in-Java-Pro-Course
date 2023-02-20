package homework27;

/**
 * Java Professional Homework #27
 *
 * @author Artysh
 * @version 20.02 - 23.02
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) {
        new HelloClient();
    }

    public HelloClient() {
        try (Socket socket = new Socket("localhost", 2048)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
