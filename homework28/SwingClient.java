package homework28;

/**
 * Java Professional Homework #28
 *
 * @author Artysh
 * @version 20.02 - 23.02
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SwingClient extends JFrame {

    JTextField mgsField;
    JTextArea dialogue;
    PrintWriter writer;
    BufferedReader reader;
    JButton connect;

    public static void main(String[] args) throws IOException {
        new SwingClient();
    }

    public SwingClient() throws IOException {
        setTitle("Client for network chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (writer != null) {
                    writer.println("exit");
                    writer.close();
                }
            }
        });

        dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        dialogue.setEditable(false);
        JScrollPane scroll = new JScrollPane(dialogue);

        mgsField = new JTextField();
        connect = new JButton("Connect");
        JButton send = new JButton("Send");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(connect);
        panel.add(mgsField);
        panel.add(send);

        send.addActionListener(e -> send());
        connect.addActionListener(e -> connect());



        //mgsField.addActionListener();

        add(BorderLayout.CENTER, scroll);
        add(BorderLayout.SOUTH, panel);
        setVisible(true);

        connect();
        send();
    }

    private void connect() {
        try {
            Socket socket = new Socket("localhost", 2048);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connection to server...");
            connect.setEnabled(false);
        } catch (IOException e) {
            System.out.println("Can't connect to server...");
        }
    }

    private void send() {
        try {
            writer.println(mgsField.getText());
            writer.flush();
            String echo = null;

            echo = reader.readLine();

            dialogue.append(echo + "\n");
            mgsField.setText(null);
            if (echo.equals("exit")) {
                connect.setEnabled(true);
            }
        } catch (SocketException ex) {
            System.out.println("Connection to server lost");
            connect.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
