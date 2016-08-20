package serialization;

import model.Movies;
import model.Shows;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tranc on 21/08/2016.
 */
public class WriteToFile {

    public static void serialiseMovies(Movies movies){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("C:/Users/tranc/Desktop/Resume/movies.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(movies);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in C:/Users/tranc/Desktop/Resume/movies.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }

    }

    public static void serialiseShows(Shows shows){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("C:/Users/tranc/Desktop/Resume/shows.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(shows);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in C:/Users/tranc/Desktop/Resume/shows.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }

    }


}
