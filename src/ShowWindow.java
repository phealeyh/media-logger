import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.tv.TvSeries;

import javax.swing.*;
import java.awt.*;

public class ShowWindow extends JFrame{
    /* Private Instance Variables */
    /* Media name */
    private String mediaName;
    /* Border Layout */
    private BorderLayout borderLayout;
    /* Associated show */
    private TvSeries series;

    public ShowWindow(String mediaName){
        //problem code
        series = new TmdbApi(Constants.KEY).getSearch().
                searchTv(mediaName,null,0).getResults().get(0);
        this.mediaName = mediaName;
        //define dimensions
        setup();
        //attach panel and add any additional components
        build();
        pack();
        setVisible(true);
    }

    public void setup(){
        setTitle(mediaName);
        setPreferredSize(new Dimension(500,450));
        setLocation(1100,500);
    }

    public void build(){
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
            JLabel title = new JLabel(Constants.TITLE + " " + series.getName());
            title.setFont(title.getFont().deriveFont(18.0f));
            box.add(title);
            JLabel plot = new JLabel(Constants.OVERVIEW);
            //add plot information here
            box.add(plot);
            //add the overview of the plot
            box = constructPlot(series.getOverview().split(" "),box);
            add(box, BorderLayout.NORTH);
        }

        /* Method: constructPlot
         * -----------------------
         * This method will be called to help construct
         * the Jlabels in a readable format so that it doesn't
         * span over the width of the window. It does this by controlling
         * the amount of words that are going to be added by having a count variable
         * that adds the appended sentences so far and resets the count variable and the
         * appended string. When the final string of the array has been hit and the
         * counter is less than 11, then it will add in whatever it has
         * left in the appended string.
         */


        private Box constructPlot(String strings[], Box box){
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
            return box;
        }

    }


}
