import javax.swing.*;
import java.awt.*;

/**
 * Created by tranc on 4/09/2016.
 */
public class AboutWindow extends JFrame {

    public AboutWindow() {
        setup();
        build();
        pack();
        setVisible(true);
    }

    private void setup(){
        setTitle(Constants.ABOUT);
        setLocation(500, 500);
        setPreferredSize(new Dimension(600,600));

    }

    private void build(){
        add(new AboutPanel());
    }


    private class AboutPanel extends JPanel{
        private AboutPanel(){
            setup();
            build();
        }

        private void setup(){
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }


        private void build(){
            ImageIcon icon = new ImageIcon(getClass().getResource(Constants.IMAGE_PATH));
            add(new JLabel(Constants.CREATOR));
            add(new JLabel(Constants.CONTACT_ME));
            add(new JLabel(Constants.GITHUB));
            add(new JLabel(icon,JLabel.CENTER));
        }




    }

}
