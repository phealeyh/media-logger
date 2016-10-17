package main;

import components.MediaBox;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;
import main.Constants;

import javax.swing.*;
import java.awt.*;

public class MovieWindow extends JFrame {
    /* Private Instance Variables */
    /* Media name */
    private String mediaName;
    /* Border Layout */
    private BorderLayout borderLayout;
    /* Associated movie */
    private MovieDb movie;

    public MovieWindow(String mediaName){
        //get first query from the list of searches for that movie
        movie = new TmdbApi(Constants.KEY).getSearch().
                searchMovie(mediaName,0,null,false,0).getResults().get(0);
        this.mediaName = mediaName;
        //define dimensions
        setup();
        //attach panel and add any additional components
        build();
        pack();
        setVisible(true);
    }

    private void setup(){
        setTitle(mediaName);
        setPreferredSize(new Dimension(525, 450));
        setLocation(1100,500);
    }

    private void build(){
        add(new MediaPanel());
    }




    private class MediaPanel extends JPanel {

        private MediaPanel() {
            setup();
            build();
        }




        private void setup() {
            setBackground(Color.WHITE);
            setLayout(borderLayout = new BorderLayout());
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void build(){
            add(MediaBox.getMovieBox(movie), BorderLayout.NORTH);
        }


    }
}
