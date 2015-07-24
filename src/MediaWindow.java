import javax.swing.*;
import java.awt.*;

/**
 * Created by Phealey on 6/07/2014.
 */
public class MediaWindow extends JFrame {
    /* Private Instance Variables */
    /* Media name */
    private String mediaName;
    /* Border Layout */
    private BorderLayout borderLayout;


    public MediaWindow(String mediaName){
        this.mediaName = mediaName;
        setup();
        build();
        pack();
        setVisible(true);
    }

    private void setup(){
        setTitle(mediaName);
        setLocation(1100,500);
        setPreferredSize(new Dimension(600,500));
    }

    private void build(){
       add(new MediaPanel());
    }



    private class MediaPanel extends JPanel {
        public MediaPanel(){
            setup();
            build();
        }

        private void setup(){
            setBackground(Color.WHITE);
            setLayout(borderLayout = new BorderLayout());
        }

        private void build(){
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

    }



}
