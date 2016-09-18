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
        setPreferredSize(new Dimension(525,450));
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
            box = PlotConstructor.constructPlot(series.getOverview().split(" "),box);
            add(box, BorderLayout.NORTH);
        }


    }


}
