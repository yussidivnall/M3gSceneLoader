/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import javax.microedition.m3g.*;
/**
 * @author volcan
 */
public class M3gSceneLoader extends MIDlet {
    boolean resume=false;
    
    Display myDisplay;
    M3gSceneLoaderCanvas myCanvas;
    
    public void init(){
        myDisplay=Display.getDisplay(this);
        myCanvas = new M3gSceneLoaderCanvas(this);
    }
    
    public void startApp() {
        if(!resume){
            init();
            resume=true;
        }
        myDisplay.setCurrent(myCanvas);
        //myDisplay.setCurrent(myCanvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
