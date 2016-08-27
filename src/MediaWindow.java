
import com.omertron.themoviedbapi.AppendToResponseBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;


public class MediaWindow extends JFrame {
    /* Private Instance Variables */
    /* Media name */
    private String mediaName;
    /* Border Layout */
    private BorderLayout borderLayout;


    public MediaWindow(String mediaName){
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
        setLocation(1100,500);
        setPreferredSize(new Dimension(600,500));
    }

    private void build(){
       add(new MediaPanel());
    }




    private class MediaPanel extends JPanel {

        public MediaPanel() {
            setup();
            build();
        }

        private void setup() {
            setBackground(Color.WHITE);
            setLayout(borderLayout = new BorderLayout());
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void build() {
            Box box = Box.createVerticalBox();
            box.add(new JLabel(Constants.TITLE));
            box.add(new JLabel(Constants.MAIN_ACTOR));
            box.add(new JLabel(Constants.PLOT));
            AppendToResponseBuilder rp;
            add(box, BorderLayout.NORTH);

        }
    }





}
