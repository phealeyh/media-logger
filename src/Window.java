
import model.Media;
import serialization.LoadFromFile;
import serialization.WriteToFile;

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

        menu = new JMenu(Constants.MENU);
        JMenuItem saveItem, saveAsItem, loadItem, closeItem;
        menu.add(saveItem = new JMenuItem(Constants.SAVE));
        menu.add(saveAsItem = new JMenuItem(Constants.SAVE_AS));
        menu.add(loadItem = new JMenuItem(Constants.LOAD));
        menu.add(closeItem = new JMenuItem(Constants.EXIT));
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(), "Saving Media");
            }
        });
        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Save file
                WriteToFile.serialiseMovies(media.movies());
                WriteToFile.serialiseShows(media.shows());
            }
        });
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(),"Loading media");
                media.setMovies(LoadFromFile.deserialiseMovies());
                media.setShows(LoadFromFile.deserialiseShows());

            }
        });
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(), "Closing Program");
                System.exit(0);

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
