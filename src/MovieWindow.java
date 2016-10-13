

import images.MediaImage;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

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
            Box box = Box.createVerticalBox();
            //add title information here
            JLabel title = new JLabel(Constants.TITLE + " " + movie.getTitle());
            title.setFont(title.getFont().deriveFont(18.0f));
            box.add(title);
            JLabel plot = new JLabel(Constants.OVERVIEW);
            //add plot information here
            box.add(plot);
            //add the overview of the plot
            box = PlotConstructor.constructPlot(movie.getOverview().split(" "),box);
            MediaImage image = new MediaImage(Constants.IMAGE_URL+movie.getPosterPath());
            box.add(new JLabel(new ImageIcon(image.getImage())));
            add(box, BorderLayout.NORTH);
        }


    }
}
