import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Helper {
    static void writeToFile(String contents, String path)
    {
        try {
            FileWriter writer=new FileWriter(path);
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static String readFromFile(String path)
    {
        String out="";
        try {
            FileReader writer=new FileReader(path);
            int ch;
            while((ch=writer.read())!=-1)
            {
                out+=(char)ch;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
