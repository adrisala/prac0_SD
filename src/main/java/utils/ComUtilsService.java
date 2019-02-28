package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ComUtilsService {
    private ComUtils comUtils;

    public ComUtilsService(InputStream inputStream, OutputStream outputStream) throws IOException {
        comUtils = new ComUtils(inputStream, outputStream);
    }

    public void writeTest() {
        try {
            comUtils.write_int32(9898);
            comUtils.write_string("Testing");
            comUtils.write_string_variable(2, "Enginyeria Informatica");
            comUtils.write_char('A');
        }catch (IOException e){
            System.out.println("Error Found during Operation:" + e.getMessage());
            e.printStackTrace();
        }

    }

    public String readTest() {
        String result = "";
        try{
            result += Integer.toString(comUtils.read_int32());
            result += " | "+comUtils.read_string();
            result += " | "+comUtils.read_string_variable(2);
            result += " | "+comUtils.read_char();
        }catch (IOException e){
            System.out.println("Error Found during Operation:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



}
