package utils;

import java.io.IOException;

public class BlackjackUtilsServer {
    public ComUtils comUtils;

    public BlackjackUtilsServer(ComUtils comUtils){
        this.comUtils = comUtils;
    }

    public void init(int initialBet) throws IOException {
        String funcName = comUtils.read_string();
        int clientId = comUtils.read_int32();

        //Inicialitzar aposta minima
    }

    public void initialDeck(){

    }

    public void card(){

    }

    public void showCards(){

    }

    public void wins(){

    }

    public void error(String message){

    }
}
