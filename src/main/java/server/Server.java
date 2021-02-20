package server;


import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public void start(int port) throws IOException {
        final DateTime startupDate = DateTime.now();
        final CommandsService commands = new CommandsService();

        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            switch (in.readLine()) {
                case "help":
                    commands.getHelp(out);
                    break;
                case "info":
                    commands.getServerInfo(out, startupDate);
                    break;
                case "uptime":
                    commands.getUptime(out, startupDate);
                    break;
                case "stop":
                    stop();
                    return;
                default:
                    out.println("Command not found ");
            }
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(ServerConstants.SERVER_PORT);
    }

}
