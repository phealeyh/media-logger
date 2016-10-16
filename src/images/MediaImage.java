package images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

/**
 * Created by phealeyhang on 14/10/2016.
 */
public class MediaImage {
    private Image image = null;
    public MediaImage(String path){
        try{
            URL url = new URL(path);
            image = ImageIO.read(url);
            image = image.getScaledInstance(185,215,Image.SCALE_FAST);
        }
        catch(java.io.IOException f){
            f.printStackTrace();
        }
    }

    public Image getImage(){
        return image;
    }

}
