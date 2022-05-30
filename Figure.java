package Paint;
import java.awt.*;

class Figure extends Coord {
    Color color;
    int w,h;
    Figure(){
        w=h=0;
    }
    public void paint(Graphics g){}
    public void setWH(int w, int h){
        this.w=w;
        this.h=h;
    }
}
