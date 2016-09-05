package components;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * Created by phealeyhang on 25/08/2016.
 */
public class FileChooser extends JFileChooser{

    private FileNameExtensionFilter filter;
    private Component component;
    private String saveLocation, loadLocation;


    public FileChooser() {
        super();

    }


    public FileChooser(Component component){
        this.component = component;
    }

    public void loadFileDialog(){
        filter = new FileNameExtensionFilter("Ser", "ser");
        this.setFileFilter(filter);
        int returnVal = showOpenDialog(component);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    this.getSelectedFile().getName());
            loadLocation = this.getSelectedFile().getAbsolutePath();
        }
    }

    public void saveFileDialog(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        if (fileChooser.showSaveDialog(component) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            saveLocation = getSsveLocation(fileToSave);
        }
    }

    //a private helper method to ensure the .ser extension
    //is used if one isn't specified by the user.
    private String getSsveLocation(File fileToSave){
        String path = fileToSave.getAbsolutePath();
        //doesn't contain extension
        if(!path.contains(".ser")) {
            path += ".ser";
        }
        return path;
    }

    public String getLoadLocation() {
        return loadLocation;
    }

    public void setLoadLocation(String loadLocation) {
        this.loadLocation = loadLocation;
    }

    public String getSaveLocation() {
        return saveLocation;
    }

    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }


}
