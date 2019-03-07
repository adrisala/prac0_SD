package utils;

import java.io.IOException;

public class BlackjackUtilsServer {
    public ComUtils comUtils;

    public BlackjackUtilsServer(ComUtils comUtils){
        this.comUtils = comUtils;
    }

    public void init(int initialBet) throws IOException {
        String funcName = comUtils.read_string();

        //Inicialitzar aposta minima
        if(!funcName.equals("STRT"))
            throw new IOException("...");

        comUtils.read_char();
        int clientId = comUtils.read_int32();

        comUtils.write_string("INIT");
        comUtils.write_char(' ');
        comUtils.write_int32(initialBet);
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
