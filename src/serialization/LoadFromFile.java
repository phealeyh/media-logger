package serialization;




import main.Constants;
import model.Media;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * Created by tranc on 21/08/2016.
 */
public class LoadFromFile {

    public static Media deserialiseMedia(String directory){
        Media media = null;
        try{
            FileInputStream fileIn = new FileInputStream(directory);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            media = (Media) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i) {
            i.printStackTrace();
        }catch(ClassNotFoundException c) {
            System.out.println(Constants.NO_MEDIA);
            c.printStackTrace();
        }
        return media;

    }


}
