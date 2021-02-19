package server;

import java.io.IOException;
import java.net.ServerSocket;

class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(ServerConstants.SERVER_PORT);
    }
}
