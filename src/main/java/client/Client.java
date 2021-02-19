package client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);

        while (true) {
            System.out.println("Choose command (uptime, info, help, stop)");
            switch (scanner.next()) {
                case "uptime":
                    String uptime = client.sendMessage("uptime");
                    System.out.println(uptime);
                    break;
                case "info":
                    String info = client.sendMessage("info");
                    System.out.println(info);
                    break;
                case "help":
                    String help = client.sendMessage("help");
                    System.out.println(help);
                    break;
                case "stop":
                    client.sendMessage("stop");
                    client.stopConnection();
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

}

