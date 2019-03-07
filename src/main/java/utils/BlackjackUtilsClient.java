package utils;

import java.io.IOException;

public class BlackjackUtilsClient {
    public ComUtils comUtils;

    public BlackjackUtilsClient(ComUtils comUtils){
        this.comUtils = comUtils;
    }


    public void startGame(int id) throws IOException {
        comUtils.write_string("STRT");
        comUtils.write_char(' ');
        comUtils.write_int32(id);
    }

    public int readInitialBet() throws IOException{
        String funcName = comUtils.read_string();

        if(!funcName.equals("INIT"))
            throw new IOException("...");

        comUtils.read_char();
        return comUtils.read_int32();
    }

    public Card[] readCard(Funcions funcions) throws IOException{
        String funcName = comUtils.read_string();

        switch (funcions){
            case CASH:
                if(!funcName.equals("IDCK"))
                    throw new IOException("...");
                Card c1 = new Card(comUtils.read_char(), comUtils.read_char());
                Card c2 = new Card(comUtils.read_char(), comUtils.read_char());

                Card[] cards = {c1, c2};
                return cards;
            case HITT:
                if(!funcName.equals("CARD"))
                    throw new IOException("...");
                Card c = new Card(comUtils.read_char(), comUtils.read_char());
                Card[] card = {c};
                return card;
        }

        return null;
    }

    public void cash(int availableCash) throws IOException{

    }

    public void hitt(){

    }

    public void showCards(){

    }

    public void makeBet(){

    }

    public void surrender(){

    }

    public void replay(){

    }

    public void exit(){

    }
}
