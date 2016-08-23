package model;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.LoadException;

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

    public Media(){
        movies = new Movies();
        shows = new Shows();
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

    public void setMovies(Movies movies){
        this.movies = movies;
    }

    public void setShows(Shows shows){
        this.shows = shows;
    }




}
