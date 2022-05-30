package Paint;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Paint3 extends Frame implements MouseListener,MouseMotionListener,ActionListener {
    int x, y;
    ArrayList<Figure> objList,objList_Undo,objList_Redo;
    CheckboxGroup cbg;
    CheckboxGroup cbgcolor;
    CheckboxGroup cbgfill;
    Checkbox c1, c2, c3, c4,c5,c6,c7;
    Checkbox cc1, cc2, cc3, cc4;
    Checkbox cf1, cf2;
    Button end,Undo,Redo,save,load;
    int mode=0;
    int count=1;
    Figure obj;
    boolean judge=false;
    public static void main(String[] args){
        Paint3 f = new Paint3();
        f.setSize(640,480);
        f.setTitle("Paint Sample");
        f.addWindowListener(new WindowAdapter(){
            @Override public void windowClosing(WindowEvent e){
                System.exit(0);
            }});
        f.setVisible(true);
        if(args.length==1) f.load(args[0]);
    }
    Paint3(){
        objList = new ArrayList<Figure>();
        objList_Undo = new ArrayList<Figure>();
        objList_Redo = new ArrayList<Figure>();
        setLayout(null);
        cbg=new CheckboxGroup();
        c1=new Checkbox("丸", cbg, true);
        c1.setBounds(20,30,50,30);
        add(c1);
        c2=new Checkbox("円", cbg, false);
        c2.setBounds(20,60,50,30);
        add(c2);
        c3=new Checkbox("四角", cbg, false);
        c3.setBounds(20,90,50,30);
        add(c3);
        c4=new Checkbox("線", cbg, false);
        c4.setBounds(20,120,50,30);
        add(c4);
        c5=new Checkbox("楕円", cbg, false);
        c5.setBounds(20,150,50,30);
        add(c5);
        c6=new Checkbox("折れ線",cbg,false);
        c6.setBounds(20,180,50,30);
        add(c6);
        c7=new Checkbox("拡張",cbg,false);
        c7.setBounds(20,210,50,30);
        add(c7);
        cbgcolor=new CheckboxGroup();
        cc1=new Checkbox("赤", cbgcolor, true);
        cc1.setBounds(70,30,30,30);
        add(cc1);
        cc2=new Checkbox("青", cbgcolor, false);
        cc2.setBounds(70,60,30,30);
        add(cc2);
        cc3=new Checkbox("黄", cbgcolor, false);
        cc3.setBounds(70,90,30,30);
        add(cc3);
        cc4=new Checkbox("緑", cbgcolor, false);
        cc4.setBounds(70,120,30,30);
        add(cc4);
        cbgfill=new CheckboxGroup();
        cf1=new Checkbox("あり", cbgfill, true);
        cf1.setBounds(120,60,50,30);
        add(cf1);
        cf2=new Checkbox("なし", cbgfill, false);
        cf2.setBounds(120,90,50,30);
        add(cf2);
        Undo=new Button("元に戻る");
        Undo.setBounds(20,250,60,30);
        add(Undo);
        Redo=new Button("やり直し");
        Redo.setBounds(20,300,60,30);
        add(Redo);
        save=new Button("保存");
        save.setBounds(90,250,60,30);
        add(save);
        load=new Button("読込");
        load.setBounds(90,300,60,30);
        add(load); 
        end=new Button("終了");
        end.setBounds(90,350,60,30);
        add(end);
        addMouseListener(this);
        addMouseMotionListener(this);
        end.addActionListener(this);
        Undo.addActionListener(this);
        Redo.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
    }
    public void save(String fname){
        try{
            FileOutputStream fos=new FileOutputStream(fname);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(objList);
            oos.close();
            fos.close();
        }catch(IOException e){
        }
    }
    @SuppressWarnings("unchecked")
    public void load(String fname){
        try{
            FileInputStream fis=new FileInputStream(fname);
            ObjectInputStream ois=new ObjectInputStream(fis);
            objList=(ArrayList<Figure>)ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException e){
        }catch(ClassNotFoundException e){
        }
        repaint();
    } 
    @Override public void paint(Graphics g){
        Figure f;
        g.drawString("塗りつぶし",110,50);
        g.drawRect(105,35,70,20);
        for(int i=0; i<objList.size(); i++){
            f=objList.get(i);
            f.paint(g);
        }
        if(mode>=1) obj.paint(g);
    }
    @Override public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==save){
            FileDialog f_dialog=new FileDialog(new Frame(),"Paint3",FileDialog.SAVE);
            f_dialog.setVisible(true);
            save("paint.dat");
        }else if(obj==load){
            FileDialog f_dialog=new FileDialog(new Frame(),"Paint3",FileDialog.LOAD);
            f_dialog.setVisible(true);
            load("paint.dat");
        }else if(obj==end){
            System.exit(0);
        }else if(obj==Undo){
            if(judge==false){
                objList_Undo=new ArrayList<>(objList);
                judge=true;
            }else if(objList.size()-1>=0){
                objList.remove(objList.size()-1);
                objList_Redo=new ArrayList<>(objList);
                repaint();
            }
        }else if(obj==Redo){
            objList_Redo=new ArrayList<>(objList);
            if(objList_Redo.size()<objList_Undo.size()){
                objList_Redo.add(objList_Undo.get(objList_Redo.size()));
            }
            objList=new ArrayList<>(objList_Redo);
            repaint();
        }
    }
    @Override public void mousePressed(MouseEvent e){
        Checkbox c;
        Checkbox cf;
        x=e.getX();
        y=e.getY();
        judge=false;
        c=cbg.getSelectedCheckbox();
        cf=cbgfill.getSelectedCheckbox();
        obj=null;
        if(c==c1){
            mode=1;
            if(cf==cf1){
                obj=new Dotfill();
            }else{
                obj=new Dot();
            }
        }else if(c==c2){
            mode=2;
            if(cf==cf1){
                obj=new Circlefill();
            }else{
                obj=new Circle();
            }
        }else if(c==c3){
            mode=2;
            if(cf==cf1){
                obj=new Rectfill();
            }else{
                obj=new Rect();
            }
        }else if(c==c4){
            mode=2;
            obj=new Line();
        }else if(c==c5){
            mode=2;
            if(cf==cf1){
                obj=new Ellipsefill();
            }else{
                obj=new Ellipse();
            }
        }else if(c==c6){
            mode=1;
            BrokenLine bl;
            if(0<objList.size() && objList.get(0) instanceof BrokenLine){
                bl=(BrokenLine)objList.get(0);
            }else{
                bl=new BrokenLine();
            }
            bl.newPoint();
            obj=bl;
        }else if(c==c7){
            mode=1;
            if(count%5==0){
                obj=new Extra4();
            }else if(count%3==1){
                obj=new Extra1();
            }else if(count%3==2){
                obj=new Extra2();
            }else{
                obj=new Extra3();
            }
            count++;
        }
        if(obj!=null){
            obj.moveto(x,y);
            repaint();
        }
        Checkbox cc;
        cc=cbgcolor.getSelectedCheckbox();
        if(cc==cc1){
            obj.color=Color.red;
        }else if(cc==cc2){
            obj.color=Color.blue;
        }else if(cc==cc3){
            obj.color=Color.yellow;
        }else if(cc==cc4){
            obj.color=Color.green;
        }
    }
    @Override public void mouseReleased(MouseEvent e){
        x=e.getX();
        y=e.getY();
        if(mode==1) obj.moveto(x,y);
        else if(mode==2) obj.setWH(x - obj.x, y - obj.y);
        if(mode>=1){
            objList.add(obj);
            obj=null;
        }
        mode=0;
        repaint();
    }
    @Override public void mouseClicked(MouseEvent e){}
    @Override public void mouseEntered(MouseEvent e){}
    @Override public void mouseExited(MouseEvent e){}
    @Override public void mouseDragged(MouseEvent e){
        x=e.getX();
        y=e.getY();
        if(mode==1){
            obj.moveto(x,y);
        }else if(mode==2){
            obj.setWH(x - obj.x, y - obj.y);
        }
        repaint();
    }
    @Override public void mouseMoved(MouseEvent e){}
}
