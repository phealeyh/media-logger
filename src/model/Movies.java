package model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Phealey on 28/06/2014.
 */
public class Movies extends Viewable implements Serializable{
    /*Private Instance Variables */
    private LinkedList<Movie> movies;

    public Movies(){
        movies = new LinkedList<Movie>();
    }

    public void add(String name){
        movies.add(new Movie(name));
        notifyAllViews();
    }

    public void delete(String name){
        movies.remove(movie(name));
        notifyAllViews();
    }


    public Movie movie(String name){
        for(Movie movie: movies){
            if(movie.name().equals(name)){
                return movie;
            }
        }
        return null;
    }

    public LinkedList<Movie> list(){
        return movies; //return the linked list
    }


}
