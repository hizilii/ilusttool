package Paint;
import java.awt.*;

class Extra1 extends Figure {
    int size;
    Extra1(){
        size=100;
    }
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.drawRect(x-size/2, y-size/2, size+50,size);
        g.drawOval(x-size+70,y-size+65,30,30);
        g.drawOval(x-size+150,y-size+65,30,30);
        g.fillOval(x-size+77,y-size+72,15,15);
        g.fillOval(x-size+157,y-size+72,15,15);
        g.drawRect(x-size+90,y-size+120,70,20);
        g.drawRect(x-size+30,y-size+75,20,50);
        g.drawRect(x-size+200,y-size+75,20,50);
        g.drawRect(x-size+100,y-size+30,50,20);
    }
}
class Extra2 extends Figure {
    int size;
    Extra2(){
        size=70;
    }
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.drawRect(x-size/2, y-size-30,size,size+50);
        g.drawRect(x-size+45, y-size-15,50,80);
        g.drawRect(x-size+55, y-size-25,30,5);
        g.drawOval(x-size+63,y-size+70,15,15);
    }
}
class Extra3 extends Figure {
    int size;
    Extra3(){
        size=150;
    }
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.drawOval(x-size/2,y-size/2,size-20,size-50);
        g.drawArc(x-size+170,y-size+20,20,100,335,218);
        g.drawArc(x-size+90,y-size+20,20,100,205,-218);
        Font font1=new Font("HGP創英角ポップ体",Font.ITALIC,30);
        g.setFont(font1);
        g.drawString("チ",x-size+90,y-size+130);
        g.drawString("バ",x-size+150,y-size+130);
        Font font2=new Font("MS Pゴシック",Font.PLAIN,40);
        g.setFont(font2);
        g.drawString("エ",x-size+115,y-size+165);
    }
}
class Extra4 extends Figure {
    int size;
    Extra4(){
        size=100;
    }
    @Override public void paint(Graphics g){
        g.setColor(color);
        g.drawOval(x-size/2,y-size/2,size,size);
        g.drawOval(x-size+55,y-size+90,30,30);
        g.drawOval(x-size+85,y-size+90,30,30);
        g.drawOval(x-size+115,y-size+90,30,30);
        g.fillOval(x-size+80,y-size+70,10,15);
        g.fillOval(x-size+110,y-size+70,10,15);
        g.drawArc(x-size+75,y-size+93,50,40,200,140);
        g.drawArc(x-size+70,y-size+60,30,60,40,105);
        g.drawArc(x-size+100,y-size+60,30,60,140,-105);
        g.drawRect(x-size+63,y-size+97,10,10);
        g.drawRect(x-size+92,y-size+97,15,10);
        g.drawRect(x-size+127,y-size+97,10,10);
    }
}
