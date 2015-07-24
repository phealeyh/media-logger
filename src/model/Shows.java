package model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Phealey on 28/06/2014.
 */
public class Shows extends Viewable implements Serializable{

    /* Private Instance Variables */
    /* List of shows */
    private LinkedList<Show> shows;

    public Shows(){
        shows = new LinkedList<Show>();
    }

    public void add(String name){
        shows.add(new Show(name));
        notifyAllViews();
    }

    public void delete(String name){
        shows.remove(show(name));
        notifyAllViews();
    }


    public Show show(String name){
        for(Show show: shows){
            if(show.name().equals(name)){
                return show;
            }
        }
        return null;
    }

    public LinkedList<Show> list(){
        return shows; //return the linked list
    }



}
