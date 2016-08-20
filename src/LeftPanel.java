import javax.swing.*;
import javax.swing.JTextField;

import model.Media;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LeftPanel extends JPanel{
    /* Private Instance Variables */
    /* Right Panel */
    private RightPanel rightPanel;
    /* Border Layout */
    private BorderLayout borderLayout;
    /* Labels */
    private JLabel mediaLabel;
    private JLabel toggle;

    /* Buttons */
    private JButton add;
    private JButton delete;
    private JButton view;
    private JButton movies;
    private JButton shows;
    /* Radio buttons */
    private JRadioButton showButton;
    private JRadioButton movieButton;
    private ButtonGroup radioButtons;
    /* Text Fields */
    private JTextField mediaName;

    public LeftPanel(RightPanel rightPanel){
        this.rightPanel = rightPanel;
        setup();
        build();
    }

    private void setup(){
        setLayout(borderLayout = new BorderLayout());//set layout
        radioButtons = new ButtonGroup();
    }

    /* Method: build
     * --------------
     * This method will basically create 1 veritcal box and 2 horizontal boxes
     * They will be used to store the buttons, text fields and labels
     * The boxes will then be added to the panel.
     *
     */

    private void build(){ //break down code for the creation of the boxes
        //create two combo boxes
        ButtonListener listener = new ButtonListener();
        //first box
        Box firstBox = Box.createVerticalBox();
        firstBox.add(mediaLabel = new JLabel(Constants.MEDIA));
        mediaLabel.setLocation(200, 200);
        firstBox.add(mediaName = new JTextField());
        firstBox.add(movieButton = radioButton(Constants.MOVIE));
        movieButton.setSelected(true);
        firstBox.add(showButton = radioButton(Constants.SHOW));
        firstBox.add(toggle = new JLabel(Constants.TOGGLING_MOVIES));
        //second box
        Box secondBox = Box.createHorizontalBox();
        secondBox.add(add = button(Constants.ADD, listener));
        secondBox.add(delete = button(Constants.DELETE, listener));
        secondBox.add(view = button(Constants.VIEW, listener));
        Box thirdBox = Box.createHorizontalBox();
        thirdBox.add(shows = button(Constants.SHOW_TOGGLE, listener));
        thirdBox.add(movies = button(Constants.MOVIE_TOGGLE, listener));
        add(firstBox, BorderLayout.NORTH);
        add(thirdBox, BorderLayout.CENTER);
        add(secondBox, BorderLayout.SOUTH);
    }

    private JButton button(String label, ButtonListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    private JRadioButton radioButton(String name){
    JRadioButton radioButton = new JRadioButton(name);
        radioButtons.add(radioButton);
        return radioButton;
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            Object source = event.getActionCommand();
            String name = mediaName.getText();
            if(source.equals(Constants.ADD)){
                if(showButton.isSelected()){
                    rightPanel.addShow(name);
                }
                else{
                    rightPanel.addMovie(name);
                }
            }
            else if(source.equals(Constants.DELETE)){
                if(showButton.isSelected()){
                    rightPanel.deleteShow(name);
                }
                else{
                    rightPanel.deleteMovie(name);
                }
            }
            else if(source.equals(Constants.VIEW)){
                if(showButton.isSelected()){
                    rightPanel.viewShow(name);
                }
                else{
                    rightPanel.viewMovie(name);
                }
            }
            else if(source.equals(Constants.SHOW_TOGGLE)){
                rightPanel.toggleShows();
            }
            else{ //movies toggle has been chosen
                rightPanel.toggleMovies();
                //Show only list of movies through the right panel
            }
            setListLabel();
        } //end method

        private void setListLabel(){
            if(rightPanel.movieListSelected()){
                toggle.setText(Constants.TOGGLING_MOVIES);
            }
            else{
                toggle.setText(Constants.TOGGLING_SHOWS);
            }
        }

    }

}
