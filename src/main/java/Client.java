import utils.BlackjackUtilsClient;
import utils.ComUtils;
import utils.Funcions;

import java.io.IOException;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        InetAddress maquinaServidora;
        int id;
        Socket socket = null;
        Random ran = new Random();
        boolean gameEnded = false;
        Scanner sc = new Scanner(System.in);

        Funcions funcions = Funcions.STRT;

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

            while (!gameEnded) {
                switch (funcions) {
                    case STRT:
                        blackjackUtilsClient.startGame(id);
                        funcions = Funcions.CASH;
                        break;
                    case CASH:
                        System.out.println("Introdueix els diners dels quals disposes: ");
                        int availableCash = sc.nextInt();
                        blackjackUtilsClient.cash(availableCash);

                        blackjackUtilsClient.readCard(funcions);


                        System.out.println("Quina acció vols fer? (H)it, (S)how, Surrende(r)");
                        char action = sc.next().toLowerCase().charAt(0);

                        switch (action){
                            case 'h':
                                funcions = Funcions.HITT;
                                break;
                            case 's':
                                funcions = Funcions.SHOW;
                                break;
                            case 'r':
                                funcions = Funcions.SRND;
                                break;
                            default:
                                System.out.println("L'has liat");
                                funcions = Funcions.EXIT;
                                break;
                        }
                        break;
                    case HITT:
                        blackjackUtilsClient.readCard(funcions);
                        blackjackUtilsClient.hitt();

                    case EXIT:
                        gameEnded = true;
                        break;
                }
            }

        }catch(IOException e){

        }
    }
}
