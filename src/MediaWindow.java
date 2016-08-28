

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbFind;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.*;
import java.awt.*;


public class MediaWindow extends JFrame {
    /* Private Instance Variables */
    /* Media name */
    private String mediaName;
    /* Border Layout */
    private BorderLayout borderLayout;
    private TmdbMovies movies;
    private MovieDb movie;

    public MediaWindow(String mediaName){
        //fight club movie
        movie = new TmdbApi(Constants.KEY).getMovies().getMovie(550,"en");
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
        setPreferredSize(new Dimension(400, 450));
        setLocation(1100,500);
    }

    private void build(){
        add(new MediaPanel());
    }




    private class MediaPanel extends JPanel {
        String title, mainActor, plot;

        public MediaPanel() {
            setup();
            build();
        }




        private void setup() {
            setBackground(Color.WHITE);

            setLayout(borderLayout = new BorderLayout());
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void build(){
            Box box = Box.createVerticalBox();
            //add title information here
            box.add(new JLabel(Constants.TITLE + " " + movie.getTitle()));
            //add main actor information here
            box.add(new JLabel(Constants.MAIN_ACTOR));
            //add plot information here
            box.add(new JLabel(Constants.PLOT));
            box.add(new JLabel(movie.getImdbID()));
            add(box, BorderLayout.NORTH);

        }
    }





}
