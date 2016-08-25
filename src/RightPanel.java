import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.LinkedList;

import model.*;
import org.jsoup.Jsoup;

public class RightPanel extends JPanel implements View{

    /* Private Instance Variables */
    private Media media;
    private BorderLayout borderLayout;
    private DefaultListModel showModel = new DefaultListModel();
    private DefaultListModel movieModel = new DefaultListModel();
    private JList list;

    public RightPanel(Media media){
        this.media = media;
        setup();
        build();
        //attach the panel at the very end
        media.movies().attach(this);
        media.shows().attach(this);
       // media.attach(this); //send itself as an object frame
    }

    private void setup(){
        setBorder(BorderFactory.createLineBorder(Color.blue));
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.white);
        setLayout(borderLayout = new BorderLayout());
    }

    private void build(){
        add(list = new JList(movieModel), BorderLayout.NORTH);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListListener());
    }


    public void update(){
        if(movieListSelected()) {
            toggleMovies();
        }
        else{
            toggleShows();
        }
    }

    public void toggleShows(){
        showModel.clear();
        LinkedList<Show> shows = media.shows().list();
        for(Show show: shows){
            showModel.addElement(show.name());
        }
        list.setModel(showModel);
    }

    public void toggleMovies(){
        movieModel.clear();
        LinkedList<Movie> movies = media.movies().list();
        for(Movie movie: movies){
            movieModel.addElement(movie.name());
        }
        list.setModel(movieModel);
    }



    public void addShow(String name){
        if(!media.mediaExists(name)) { //show doesn't exist
            media.shows().add(name);
            JOptionPane.showMessageDialog(new JFrame(), name.substring(0,1).toUpperCase()
                    + name.substring(1) + " added");
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "This already exists as either a movie or show");
        }
    }

    public void addMovie(String name){
        if(!media.mediaExists(name)) { //use boolean function within movies/shows classes
            media.movies().add(name);
            JOptionPane.showMessageDialog(new JFrame(), name.substring(0, 1).toUpperCase()
                    + name.substring(1) + " added");
        }
        else{
           JOptionPane.showMessageDialog(new JFrame(), "This already exists as either a movie or a show");
        }
    }

    public void deleteMovie(String name){
        if(media.mediaExists(name)) {
            media.movies().delete(name);
            JOptionPane.showMessageDialog(new JFrame(), name.substring(0,1).toUpperCase()
                    + name.substring(1) + " deleted");
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Movie doesn't exist");
        }
    }

    public void deleteShow(String name){
        if(media.mediaExists(name)) {
            media.shows().delete(name);
            JOptionPane.showMessageDialog(new JFrame(), name.substring(0,1).toUpperCase()
                    + name.substring(1) + " deleted");
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Show doesn't exist");
        }
    }


    public void viewShow(String name){
        if(media.mediaExists(name)){
            JOptionPane.showMessageDialog(new JFrame(), "Showing " + name.substring(0,1).toUpperCase()
                    + name.substring(1));
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Show doesn't exist");
        }
    }

    public void viewMovie(String name){
        if(media.mediaExists(name)){
            JOptionPane.showMessageDialog(new JFrame(), "Showing " + name.substring(0,1).toUpperCase()
                    + name.substring(1));
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Movie doesn't exist");
        }
    }



    public boolean movieListSelected(){
        return list.getModel() == movieModel;
    }

    private class ListListener implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent e){
            //define what happens when one of the rows is clicked on
            if(e.getValueIsAdjusting())
                return;
            int index = list.getSelectedIndex();
            if(index == -1) //nothing was selected
                return;
            //get name of media
            String name;
            if(movieListSelected()){
                name = (String)movieModel.get(index);
                JOptionPane.showMessageDialog(new JFrame(), "Movie Selected");
                //open url based on the movie name
            }
            else{
                name = (String)showModel.get(index);
                JOptionPane.showMessageDialog(new JFrame(), "Show Selected");
                //open url based on movie name
            }
            //create new window and frame based on the media selected
            new MediaWindow(name);
        }

    }


}
