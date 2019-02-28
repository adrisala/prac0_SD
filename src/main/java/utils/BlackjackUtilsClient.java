package utils;

import java.io.IOException;

public class BlackjackUtilsClient {
    public ComUtils comUtils;

    public BlackjackUtilsClient(ComUtils comUtils){
        this.comUtils = comUtils;
    }


    public void startGame(int id) throws IOException {
        comUtils.write_string("STRT");
        comUtils.write_int32(id);
    }

    public void cash(){

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
