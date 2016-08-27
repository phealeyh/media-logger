package serialization;

import model.Media;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tranc on 21/08/2016.
 */
public class WriteToFile {

    public static void serialiseMedia(Media media, String directory){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(directory);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(media);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + directory);
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }




}
