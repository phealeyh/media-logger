package model;

import java.io.Serializable;

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
