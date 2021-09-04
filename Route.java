import java.util.*;
import java.awt.geom.*;

/**
 * The route class allows them to
 * be added to the world canvas connecting
 * two nations with only one of them
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Route
{
    private double x1,x2;
    private double y1,y2;
    private Nation nation1;
    private Nation nation2;
    private int cost;
    private boolean isVisible;
    private String str = "";
    private int[] positions;
    /**
     * Create a route between the nations with
     * their default positions.
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
    /**
     * This method looks for a route between two nations
     * @ param locationA, locationA tells us the location of a nation
     * @ param locationB, locationB tells us the location of the other nation
     */
    public boolean searchRoute(String locationA, String locationB){
        if (locationA.equals(this.getNation1()) && locationB.equals(this.getNation2())) return true;
        else if (locationB.equals(this.getNation1()) && locationA.equals(this.getNation2())) return true;
        return false;
    }
    /**
     * This method makes the path visible
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    /**
     * This method makes the path invisible
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    /**
     * This method remoes the path from those containing the world
     * @ param rutas, rutas is where the path to be removed is located
     */
    public void delRoute(ArrayList<Route> rutas){
        makeInvisible();
        rutas.remove(this);
    }
    /**
     * This method returns nation one
     * @return nation1, nation1 is achieved through color since it is unique
     */
    public String getNation1(){
        return nation1.getColor();
    }
    /**
     * This method returns nation two
     * @return nation2, nation2 is achieved through color since it is unique
     */
    public String getNation2(){
        return nation2.getColor();
    }
    /**
     * This methos returns the cost of the route
     * @ return cost, cost is the cost of the route
     */
    public int getCost(){
        return this.cost;
    }
    /*
     * This method draws the route of two
     * nations on the canvas of the world
     */
    private void draw(){
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this,"black",new Line2D.Double(x1,y1,x2,y2),str,positions);
    }
    /*
     * This method erases the route of two
     * nations on the canvas of the world
     */
    private void erase(){
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(this);
    }
}
