package Paint;
import java.awt.*;

class Line extends Figure {
    Line(){}
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.drawLine(x,y,x+w,y+h);
    }
}
