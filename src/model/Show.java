package model;

import java.io.Serializable;

/**
 * Created by Phealey on 28/06/2014.
 */
public class Show implements Serializable{
    /* Private Instance Variables */
    private String name;

    public Show(String name){
        this.name = name;
    }

    public String name(){
        return name;
    }

}
