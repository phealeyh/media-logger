package serialization;




import model.Media;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * Created by tranc on 21/08/2016.
 */
public class LoadFromFile {

    public static Media deserialiseMedia(){
        Media media = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("C:/Users/tranc/Desktop/Resume/media.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            media = (Media) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.println("Media not found");
            c.printStackTrace();
        }
        return media;

    }


}
