import java.util.*;
import java.awt.geom.*;

/**
 * Write a description of class Route here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route
{
    private double x1,x2;
    private double y1,y2;
    private Nation nation1;
    private Nation nation2;
    private int cost;
    private boolean isVisible;
    /**
     * Constructor for objects of class Route
     */
    public Route(Nation n1, Nation n2, int cost)
    {
        x1 = (double) n1.getXPos();
        y1 = (double) n1.getYPos();
        x2 = (double) n2.getXPos();
        y2 = (double) n2.getYPos();
        nation1 = n1;
        nation2 = n2;
        this.cost = cost;
        isVisible = false;
    }
    public String getNation1(){
        return nation1.getColor();
    }
    public String getNation2(){
        return nation2.getColor();
    }
    public boolean searchRoute(String locationA, String locationB){
        if (locationA.equals(this.getNation1()) && locationB.equals(this.getNation2())) return true;
        else if (locationB.equals(this.getNation1()) && locationA.equals(this.getNation2())) return true;
        return false;
    }
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    public void delRoute(ArrayList<Route> rutas){
        makeInvisible();
        rutas.remove(this);
    }
    private void draw(){
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this,"black",new Line2D.Double(x1,y1,x2,y2));
    }
    private void erase(){
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(this);
    }
}
