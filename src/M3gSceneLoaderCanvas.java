/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author volcan
 */
import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.m3g.*;
import javax.microedition.midlet.MIDlet;
public class M3gSceneLoaderCanvas  extends Canvas{
    MIDlet myParent;
    Graphics3D myGraphics3D;
    World myWorld;
    String m3gResource = "/Scene1.m3g";
    
    M3gSceneLoaderCanvas(MIDlet m){
        myParent=m;
        myGraphics3D = Graphics3D.getInstance();
        myWorld = new World();
        loadWorld();
    }
    
    public void loadWorld(){
        try{
            Object3D obs[] = Loader.load(m3gResource);
            Group root = (Group)obs[0];
            myWorld=(World)root;
            
 
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics g){
            long startRendering=System.currentTimeMillis();
            g.setColor(0x00);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            myGraphics3D.bindTarget(g);
            myGraphics3D.setViewport(0,0,this.getWidth(),this.getHeight());
            myGraphics3D.render(myWorld);
            myGraphics3D.releaseTarget();
            long endRendering=System.currentTimeMillis();
            long renderingTime=endRendering-startRendering;
            g.setColor(0xFFFFFF);
            g.drawString("RenderingTime:"+renderingTime+"ms",0,this.getHeight()-10,g.BASELINE|g.LEFT);
    }
}
