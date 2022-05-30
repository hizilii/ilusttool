package Paint;
import java.awt.*;

class Circle extends Figure {
    Circle(){}
    @Override public void paint(Graphics g){
        int r=(int)Math.sqrt((double)(w*w+h*h));
        g.setColor(color);
        g.drawOval(x-r, y-r, r*2, r*2);
    }
}
class Circlefill extends Figure {
    Circlefill(){}
    @Override public void paint(Graphics g){
        int r=(int)Math.sqrt((double)(w*w+h*h));
        g.setColor(color);
        g.fillOval(x-r, y-r, r*2, r*2);
    }
}
