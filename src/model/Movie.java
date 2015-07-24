package model;

import java.io.Serializable;

/**
 * Created by Phealey on 28/06/2014.
 */
public class Movie implements Serializable{

    /* Private Instance Variables */
    private String name;

    public Movie(String name){
        this.name = name;

    }

    public String name(){
        return name;
    }


}
