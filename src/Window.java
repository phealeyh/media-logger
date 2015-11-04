/**
 * Created by Phealey on 28/06/2014.
 */
import model.Media;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{ //starting window

    /* Private Instance Variables */
    /* The Media Program */
    private Media media;
    /* Menu toolbar */
    private JMenuBar menuBar;
    /* Menu */
    private JMenu menu;
    /* Menu Items */
    private JMenuItem item;


    public Window(){
        media = new Media();
        setup();
        build();
        pack();
        setVisible(true);
    }

    private void setup(){
        setTitle(Constants.PROGRAM_NAME);
        setLocation(500, 500);
        setPreferredSize(new Dimension(600,260)); //size
        setMenuOptions();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setMenuOptions(){
        menu = new JMenu("My menu");
        menu.add(new JMenuItem("First Item"));
        menu.add(new JMenuItem("Second Item"));
        menu.add(new JMenuItem("Third Item"));
        menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void build(){
        add(new Panel());
    }

    private class Panel extends JPanel{ //starting panel
        public Panel(){
            setup();
            build();
        }

        private void setup(){
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void build(){
            RightPanel rightPanel = new RightPanel(media);
            LeftPanel leftPanel = new LeftPanel(rightPanel);
            add(leftPanel);
            add(rightPanel);
        }
    }

}
