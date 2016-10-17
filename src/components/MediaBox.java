package components;

import images.MediaImage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.tv.TvSeries;
import main.Constants;
import main.PlotConstructor;
import javax.swing.*;

/**
 * Created by phealeyhang on 17/10/2016.
 */


public class MediaBox{

    public static Box getMovieBox(MovieDb movie){
        Box box = Box.createVerticalBox();
        //add title information here
        JLabel title = new JLabel(Constants.TITLE + " " + movie.getTitle());
        title.setFont(title.getFont().deriveFont(18.0f));
        box.add(title);
        JLabel plot = new JLabel(Constants.OVERVIEW);
        //add and get image of the movie
        MediaImage image = new MediaImage(Constants.IMAGE_URL+movie.getPosterPath());
        box.add(new JLabel(new ImageIcon(image.getImage())));

        //add plot information here
        box.add(plot);
        //add the overview of the plot
        box = PlotConstructor.constructPlot(movie.getOverview().split(" "),box);

        //add the popularity of the movie
        box.add(new JLabel(Constants.POPULARITY + movie.getPopularity()));
        return box;
    }

    public static Box getShowBox(TvSeries series){
        Box box = Box.createVerticalBox();

        //add title information here
        JLabel title = new JLabel(Constants.TITLE + " " + series.getName());
        title.setFont(title.getFont().deriveFont(18.0f));
        box.add(title);
        JLabel plot = new JLabel(Constants.OVERVIEW);

        //add and get image of the series
        MediaImage image = new MediaImage(Constants.IMAGE_URL+series.getPosterPath());
        box.add(new JLabel(new ImageIcon(image.getImage())));

        //add plot information here
        box.add(plot);
        //add the overview of the plot
        box = PlotConstructor.constructPlot(series.getOverview().split(" "),box);

        //add the popularity of the show
        box.add(new JLabel(Constants.POPULARITY + series.getPopularity()));

        return box;
    }


}
