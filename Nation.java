import java.util.*;
/**
 * Write a description of class Nation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nation
{
    private final int ANCHO = 20;
    private final int ALTO = 20;
    private String color;
    private int xPosition,yPosition;
    private int nArmies;
    private Rectangle world;
    private Rectangle visual;
    private ArrayList<Route> properRoutes = new ArrayList<Route>(); 
    public Nation(String color, int x, int y, int nArmies, Rectangle world){
        this.color = color;
        this.world = world;
        xPosition = getPositionX(x);
        yPosition = getPositionY(y);
        this.nArmies = nArmies;
        visual = new Rectangle(ANCHO,ALTO);
        configureVisual();
    }
    public int extractYCoordinate(){
        return world.getYPosition();
    }
    public int extractXCoordinate(){
        return world.getXPosition();
    }
    public int getXPos(){
        return this.xPosition+ANCHO/2;
    }
    public int getYPos(){
        return this.yPosition+ALTO/2;
    }
    public String getColor(){
        return this.color;
    }
    private int getPositionY(int yPosition){
        int total = world.getHeight();
        if (yPosition == 0) return total - yPosition + 
            world.getYPosition() - ALTO;
        return total - yPosition + world.getYPosition();
    }
    private int getPositionX(int xPosition){
        int total = world.getXPosition();
        if (xPosition == 0) return total + xPosition;
        return total + xPosition-ANCHO;
    }
    public void configureVisual(){
        visual.changeColor(color);
        visual.changePosition(xPosition, yPosition);
    }
    public void makeVisible(){
        visual.makeVisible();
    }
    public void makeInvisible(){
        visual.makeInvisible();
    }
    public void addArmy(){
        nArmies ++;
    }
    public void addRoute(Route ruta, ArrayList<Route> rutas,Nation nation2){
        rutas.add(ruta);
        properRoutes.add(ruta);
        nation2.addRoute(ruta);
    }
    public void addRoute(Route ruta){
        if (!properRoutes.contains(ruta))properRoutes.add(ruta);
    }
    public void visualArmies(){
        //Falta hacer la visualizacion de los ejercitos
        //Canvas canvas = Canvas.getCanvas();
        //canvas.draw(this,color,new Line2D.Double(xx1,yy1,xx2,yy2));
    }
    public void delNation(ArrayList<Route> rutas){
        this.makeInvisible();
        for(Route i: properRoutes) i.delRoute(rutas);
        rutas.removeAll(properRoutes);
    }

    
}
