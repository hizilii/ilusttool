package Paint;
import java.awt.*;

class Rect extends Figure {
    Rect(){}
    @Override public void paint(Graphics g){
        g.setColor(color);
        if(w > 0 && h > 0){
            g.drawRect(x,y,w,h);
        }else if(w < 0 && h < 0){
            g.drawRect(x + w,y + h,-w,-h);
        }else if(w > 0 && h < 0){
            g.drawRect(x ,y + h,w ,-h);
        }else{
            g.drawRect(x + w ,y ,-w, h);
        }
    }
}
class Rectfill extends Figure {
    Rectfill(){}
    @Override public void paint(Graphics g){
        g.setColor(color);
        if(w > 0 && h > 0){
            g.fillRect(x,y,w,h);
        }else if(w < 0 && h < 0){
            g.fillRect(x + w,y + h,-w,-h);
        }else if(w > 0 && h < 0){
            g.fillRect(x ,y + h,w ,-h);
        }else{
            g.fillRect(x + w ,y ,-w, h);
        }
    }
}
