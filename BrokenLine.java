package Paint;
import java.util.*;
import java.util.List;
import java.awt.*;

class BrokenLine extends Figure {
    private List<Point> brokenList;
    private List<Line> lineList;
    private Point currentBroken;
    private Line currentLine;
    BrokenLine() {
        brokenList = new ArrayList<Point>();
        lineList = new ArrayList<Line>();
    }
    public void newPoint() {
        currentBroken = new Point();
        brokenList.add(currentBroken);
        if (2 <= brokenList.size()) {
            Point b = brokenList.get(brokenList.size() - 2);
            currentLine = new Line();
            currentLine.moveto(b.x, b.y);
            lineList.add(currentLine);
        }
    }
    public void moveto(int x, int y) {
        currentBroken.move(x, y);
        if (currentLine != null) {
            currentLine.setWH(x - currentLine.x, y - currentLine.y);
        }
    }
    public void paint(Graphics g) {
        g.setColor(color);
        for (Line l : lineList) {
            l.paint(g);
        }
    }
}
