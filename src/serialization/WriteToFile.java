package serialization;

import model.Media;
import model.Movies;
import model.Shows;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tranc on 21/08/2016.
 */
public class WriteToFile {

    public static void serialiseMedia(Media media){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("C:/Users/tranc/Desktop/Resume/media.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(media);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in C:/Users/tranc/Desktop/Resume/media.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }




}
