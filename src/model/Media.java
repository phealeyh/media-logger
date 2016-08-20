package model;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;


public class Media implements Serializable{
    /*Private Instance Variables */
    /* Movies object */
    private Movies movies;
    /* Shows object */
    private Shows shows;
    /* String of the filename */
    private String fileName;

    public Media(){
        movies = new Movies();
        shows = new Shows();
        try{
            load();
        } catch(Exception e){
            e.printStackTrace();
        }
        //movies and shows are both initialised
    }

    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            movies = (Movies) ois.readObject();
            shows = (Shows) ois.readObject();
        } catch (IOException e) {
            movies = new Movies();
            shows = new Shows();
        } finally {
            if (ois != null){
                ois.close();
            }
        }
    }




    public boolean mediaExists(String name){
        return shows.show(name)!= null || movies.movie(name) != null;
    }


    public Movies movies(){
        return movies;
    }

    public Shows shows(){
        return shows;
    }




}
