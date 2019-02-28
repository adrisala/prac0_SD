import org.junit.Test;
import static org.junit.Assert.*;
import utils.ComUtils;
import utils.ComUtilsService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ComUtilsTest {

    @Test
    public void example_test() {
        File file = new File("test");
        try {
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));
            comUtils.write_int32(2);
            int readedInt = comUtils.read_int32();

            assertEquals(2, readedInt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void first_test(){
        File file = new File("test1");
        try {
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));

            comUtils.write_char('!');
            comUtils.write_string_variable(2,"Hey siri, what's the weather like?");

            char charRead = comUtils.read_char();
            assertEquals('!', charRead);
            String stringRead = comUtils.read_string_variable(2);
            System.out.println(stringRead);
            assertEquals("Hey siri, what's the weather like?", stringRead);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
