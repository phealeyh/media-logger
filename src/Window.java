
import components.FileChooser;
import model.Media;
import serialization.LoadFromFile;
import serialization.WriteToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{ //starting window

    /* Private Instance Variables */
    private Media media;
    /* Menu toolbar */
    private JMenuBar menuBar;
    /* Menu */
    private JMenu menu;
    /* Panel containing the left and right panels */
    private Panel myPanel;
    /* FileChooser dialogs along with save and load locations */
    private FileChooser fc;

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
        JMenuItem saveAsItem, loadItem, closeItem;
        menu.add(saveAsItem = new JMenuItem(Constants.SAVE_AS));
        menu.add(loadItem = new JMenuItem(Constants.LOAD));
        menu.add(closeItem = new JMenuItem(Constants.EXIT));
        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.saveFileDialog();
                WriteToFile.serialiseMedia(media,fc.getSaveLocation());
            }
        });
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.loadFileDialog();
                media.setMovies(LoadFromFile.deserialiseMedia(fc.getLoadLocation()).movies());
                media.setShows(LoadFromFile.deserialiseMedia(fc.getLoadLocation()).shows());
                myPanel.rightPanel().update();

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
        fc = new FileChooser(getGlassPane());
        add(myPanel = new Panel());
    }

    /* Private class that includes both the left and right panel */

    private class Panel extends JPanel{ //starting panel

        private RightPanel rightPanel;
        private LeftPanel leftPanel;

        private Panel(){
            setup();
            build();
        }

        private void setup(){
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private void build(){
            rightPanel = new RightPanel(media);
            leftPanel = new LeftPanel(rightPanel);
            add(leftPanel);
            add(rightPanel);
        }

        private RightPanel rightPanel(){
            return rightPanel;
        }

        private LeftPanel leftPanel(){
            return leftPanel;
        }
    }

}
