package model;

import java.util.LinkedList;

/**
 * Created by Phealey on 28/06/2014.
 */
public class Viewable {
    private LinkedList<View> views = new LinkedList<View>();

    public void attach(View view){
        views.add(view);
    }

    public void notifyAllViews(){
        for(View view: views){
            view.update(); //updates each view panel
        }
    }

    public void detach(View targetView){
        for(View view: views){
            if(view == targetView)
                views.remove(targetView);
        }
    }
}
