
import com.sun.xml.internal.stream.writers.WriterUtility;
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
        JMenuItem saveItem, saveAsItem, loadItem, closeItem;
        menu.add(saveItem = new JMenuItem("Save"));
        menu.add(saveAsItem = new JMenuItem("Save As"));
        menu.add(loadItem = new JMenuItem("Load"));
        menu.add(closeItem = new JMenuItem("Close"));
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
                WriteToFile.saveToFile();
            }
        });
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(),"Loading media");
            }
        });
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getGlassPane(), "Closing Program");
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
