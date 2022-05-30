package Paint;
import java.awt.*;

class Dot extends Figure {
    int size;
    Dot(){
        size=10;
    }
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.drawOval(x-size/2, y-size/2, size, size);
    }
}
class Dotfill extends Figure {
    int size;
    Dotfill(){
        size=10;
    }
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x-size/2, y-size/2, size, size);
    }
}
