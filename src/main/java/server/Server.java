package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String SERVER_VERSION = "0.1";
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            switch (in.readLine()) {
                case "uptime":
                    showTime();
                    break;
                case "info":
                    showInfo();
                    break;
                case "help":
                    showHelp();
                    break;
                case "stop":
                    stop();
                    return;
                default:
                    out.println("Unknown command");
            }
        }
    }

    private void showTime() {
    }

    private void showInfo() {
        JsonObject response = new JsonObject();
        response.addProperty("serverVersion", SERVER_VERSION);
        out.println(response);
    }

    private void showHelp() {
        JsonObject response = new JsonObject();
        response.addProperty("uptime", "Returns the days, hours, minutes, and seconds since the server started.");
        response.addProperty("info", "Returns the server version and creation date.");
        response.addProperty("help", "Returns a list of available commands.");
        response.addProperty("stop", "Stops the server and the client");
        out.println(response);
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(6666);
    }
}
