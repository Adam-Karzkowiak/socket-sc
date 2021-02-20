package client;

import lombok.experimental.PackagePrivate;

import java.io.IOException;
import java.util.Scanner;

@PackagePrivate
class ClientCommandsService {


    void clientCommunication(ClientConnectionService connection) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome. Type 'help' for a list of available commands");
        while (true) {
            switch (scanner.next()) {
                case "help":
                    String help = connection.sendMessage("help");
                    System.out.println(help);
                    break;
                case "info":
                    String info = connection.sendMessage("info");
                    System.out.println(info);
                    break;
                case "uptime":
                    String uptime = connection.sendMessage("uptime");
                    System.out.println(uptime);
                    break;
                case "stop":
                    connection.sendMessage("stop");
                    connection.stopConnection();
                    return;
                default:
                    System.out.println("Command not found.Type 'help' for a list of available commands");
            }
        }

    }
}
