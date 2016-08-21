package serialization;

import model.Movies;
import model.Shows;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * Created by tranc on 21/08/2016.
 */
public class LoadFromFile {

    public static Movies deserialiseMovies(){
        Movies movies = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("C:/Users/tranc/Desktop/Resume/movies.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            movies = (Movies) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        return movies;

    }

    public static Shows deserialiseShows(){
        Shows shows = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("C:/Users/tranc/Desktop/Resume/shows.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            shows = (Shows) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        return shows;


    }

}
