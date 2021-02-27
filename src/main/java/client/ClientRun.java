package client;


import server.server.ServerConstants;
import java.io.IOException;

class ClientRun {


    public static void main(String[] args) throws IOException {
        ClientConnectionService connection = new ClientConnectionService();
        connection.startConnection(ServerConstants.LOCALHOST, ServerConstants.SERVER_PORT);
        ClientCommandsService commands = new ClientCommandsService();
        commands.clientCommunication(connection);
    }

}

