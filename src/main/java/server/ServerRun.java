package server;

import server.server.Server;
import server.server.ServerConstants;

import java.io.IOException;

public class ServerRun {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(ServerConstants.SERVER_PORT);
    }
}
