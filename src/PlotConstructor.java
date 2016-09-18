import javax.swing.*;

/**
 * Created by tranc on 18/09/2016.
 */
public class PlotConstructor {

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


    public static Box constructPlot(String strings[], Box box){
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
            else if(i == (strings.length - 1)){
                label.setText(text);
                label.setFont(label.getFont().deriveFont(10.0f));
                box.add(label);
            }
            count++;
        }
        return box;
    }
}
