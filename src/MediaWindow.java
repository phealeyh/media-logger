

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.*;
import java.awt.*;

public class MediaWindow extends JFrame {
    /* Private Instance Variables */
    /* Media name */
    private String mediaName;
    /* Border Layout */
    private BorderLayout borderLayout;
    private MovieDb movie;

    public MediaWindow(String mediaName){
        //get first query from the list
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
        setPreferredSize(new Dimension(500, 450));
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
            JLabel plot = new JLabel(Constants.PLOT);
            //add plot information here
            box.add(plot);

            //first part of the plot
            String strings[] = movie.getOverview().split(" ");
            int count = 0;
            String text = "";
            for(int i = 0; i < strings.length; i++){
                text += strings[i] + " ";
                JLabel label = new JLabel(text);
                if(count == 11){
                    label.setText(label.getText());
                    count = 0;
                    label.setFont(label.getFont().deriveFont(10.0f));
                    text = "";
                    box.add(label);
                }
                if(i == (strings.length - 1)){
                    label.setText(text);
                    label.setFont(label.getFont().deriveFont(10.0f));
                    box.add(label);
                }
                count++;
             }
            add(box, BorderLayout.NORTH);
        }


    }


}
