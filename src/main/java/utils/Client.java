package utils;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Client {
    public static void main(String[] args){
        InetAddress maquinaServidora;
        int id;
        Socket socket = null;
        Random ran = new Random();

        BlackjackUtilsClient blackjackUtilsClient;

        int numPort;
        String nomMaquina;

        if(args.length != 2){
            System.out.println("Us: java Client <maquina_servidora> <port>");
            return;
        }

        nomMaquina = args[0];
        numPort = Integer.parseInt(args[1]);

        try{
            maquinaServidora = InetAddress.getByName(nomMaquina);
            blackjackUtilsClient = new BlackjackUtilsClient(new ComUtils(socket));

            socket = new Socket(maquinaServidora, numPort);

            id = ran.nextInt(1000);

            blackjackUtilsClient.startGame(id);

            blackjackUtilsClient.cash();

        }catch(IOException e){

        }
    }
}
