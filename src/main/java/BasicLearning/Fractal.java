package BasicLearning;

import java.applet.Applet;
import java.awt.*;

public class Fractal extends Applet {
    private Image display;
    private Graphics drawingArea;
    @Override
    public void init(){
        int height = getSize().height;
        int width = getSize().width;
        display = createImage(width,height);
        drawingArea = display.getGraphics();
        randomFractal(0,height/2,width,height/2,drawingArea);
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(display,0,0,null);
    }
    public static void randomFractal(
            int leftX,
            int leftY,
            int rightX,
            int rightY,
            Graphics drawingArea
    ){
        final int  STOP = 4;
        int midX,midY;
        int delta;
        if ((rightX - leftX) <= STOP){
            drawingArea.drawLine(leftX,leftY,rightX,rightY);
        }else {
            midX = (rightX + leftX)/2;
            midY = (rightY + leftY)/2;
            delta = (int)((Math.random() - 0.5)*(rightX - leftX));
            midY += delta;
            randomFractal(leftX,leftY,midX,midY,drawingArea);
            randomFractal(midX,midY,rightX,rightY,drawingArea);
        }

    }
}
//<applet code="src.main.java.BasicLearning.Fractal.class" width=300 height=300></applet>