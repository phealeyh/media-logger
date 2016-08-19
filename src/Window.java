/**
 * Created by Phealey on 28/06/2014.
 */
import model.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{ //starting window

    /* Private Instance Variables */
    /* The Media Program */
    private Media media;
    /* Menu toolbar */
    private JMenuBar menuBar;
    /* Menu */
    private JMenu menu;

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
        setPreferredSize(new Dimension(600,450)); //size
        setMenuOptions();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setMenuOptions(){
        menu = new JMenu("My menu");
        JMenuItem item1, item2, item3;
        menu.add(item1 = new JMenuItem("First Item"));
        menu.add(item2 = new JMenuItem("Second Item"));
        menu.add(item3 = new JMenuItem("Third Item"));
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(), "Item 1 selected");
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(),"Item 2 selected");
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(),"Item 3 selected");
            }
        });
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
