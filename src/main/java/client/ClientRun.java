package client;


import server.ServerConstants;

import java.io.IOException;
import java.util.Scanner;

class ClientRun {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ClientConnectionService connection = new ClientConnectionService();
        connection.startConnection(ServerConstants.LOCALHOST, ServerConstants.SERVER_PORT);
        ClientCommandsService commands = new ClientCommandsService();
        commands.clientCommunication(connection);
    }

}

