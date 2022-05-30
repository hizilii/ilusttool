package Paint;
import java.awt.*;

class Ellipse extends Figure {
    double a,b;
    Ellipse(){}
    @Override public void paint(Graphics g){
        a=Math.sqrt(2)*w;
        b=Math.sqrt(2)*h;
        g.setColor(color);
        if(w > 0 && h > 0){
            g.drawOval(x-(int)a,y-(int)b,2*(int)a,2*(int)b);
        }else if(w < 0 && h < 0){
            g.drawOval(x+(int)a,y+(int)b,-2*(int)a,-2*(int)b);
        }else if(w > 0 && h < 0){
            g.drawOval(x-(int)a,y+(int)b,2*(int)a,-2*(int)b);
        }else{
            g.drawOval(x+(int)a,y-(int)b,-2*(int)a,2*(int)b);
        }
    }
}
class Ellipsefill extends Figure {
    double a,b;
    Ellipsefill(){}
    @Override public void paint(Graphics g){
        a=Math.sqrt(2)*w;
        b=Math.sqrt(2)*h;
        g.setColor(color);
        if(w > 0 && h > 0){
            g.fillOval(x-(int)a,y-(int)b,2*(int)a,2*(int)b);
        }else if(w < 0 && h < 0){
            g.fillOval(x+(int)a,y+(int)b,-2*(int)a,-2*(int)b);
        }else if(w > 0 && h < 0){
            g.fillOval(x-(int)a,y+(int)b,2*(int)a,-2*(int)b);
        }else{
            g.fillOval(x+(int)a,y-(int)b,-2*(int)a,2*(int)b);
        }
    }
}
