import utils.BlackjackUtilsServer;
import utils.ComUtils;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket socket = null;

        Scanner sc = new Scanner(System.in);

        BlackjackUtilsServer blackjackUtilsServer;

        int portServidor = 1234, minimalBet;

        if(args.length > 1){
            System.out.println("Us: java Servidor <port>");
            return;
        }

        if (args.length == 1)
            portServidor = Integer.parseInt(args[0]);

        try{
            serverSocket = new ServerSocket(portServidor);

            System.out.println("IP del servidor" + serverSocket.getInetAddress().toString());
            System.out.println("Servidor socket preparat en el port " + portServidor);

            while (true){
                socket = serverSocket.accept();
                System.out.println("Connexió acceptada");

                blackjackUtilsServer = new BlackjackUtilsServer(new ComUtils(socket));

                System.out.println("Aposta minima: ");
                minimalBet = sc.nextInt();

                blackjackUtilsServer.init(minimalBet);


            }
        }catch(IOException e){

        }
    }
}
