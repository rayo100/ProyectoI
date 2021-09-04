import java.util.*;
/**
 * The route class allows adding them to
 * the world canvas, contain armies, be
 * conquered and others
 * 
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
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
    private Rectangle marca = new Rectangle(ALTO/2,ANCHO/2);
    private ArrayList<Route> properRoutes = new ArrayList<Route>();
    private boolean conquered;
    private boolean isVisible;
    /**
     * Creates a nation with an army number and is 
     * identified by a unique color
     */
    public Nation(String color, int x, int y, int nArmies, Rectangle world){
        this.color = color;
        this.world = world;
        xPosition = getPositionX(x);
        yPosition = getPositionY(y);
        this.nArmies = nArmies;
        isVisible = false;
        visual = new Rectangle(ANCHO,ALTO);
        conquered = false;
        configureVisual();
    }
    /**
     * This method returns the Y coordinate of 
     * the world canvas.
     * @ return YPosition, YPosition is the Y coordinate of the world canvas
     */
    public int extractYCoordinate(){
        return world.getYPosition();
    }
    /**
     * This method returns the X coordinate of 
     * the world canvas.
     * @ return XPosition, XPosition is the X coordinate of the world canvas
     */
    public int extractXCoordinate(){
        return world.getXPosition();
    }
    /**
     * This method returns the x coordinate of the
     * nation which must be within the world canvas
     * @ return xPosition, xPosition fits the canvas of the world
     */
    public int getXPos(){
        return this.xPosition+ANCHO/2;
    }
    public int getArmies(){
        return nArmies;
    }
    public boolean conquest(){
        return this.conquered;
    }
    public void setConquest(boolean conquista){
        this.conquered = conquista;
        update();
    }
    /**
     * This method returns the y coordinate of the
     * nation which must be within the world canvas
     * @ return yPosition, yPosition fits the canvas of the world
     */
    public int getYPos(){
        return this.yPosition+ALTO/2;
    }
    /**
     * This method returns the color of the nation
     * @ return color, color is the identifier of the nation
     */
    public String getColor(){
        return this.color;
    }
    /**
     * This method locates the nation on the canvas of the world 
     * with its respective color and strict location
     */
    public void configureVisual(){
        visual.changeColor(color);
        visual.changePosition(xPosition, yPosition);
        String nArmy = Integer.toString(this.nArmies);
        visual.setString(nArmy);
        if (conquered){            
            marca.changeColor("black");
            marca.changePosition(xPosition+5, yPosition+5);
        }
        else marca.changeColor(color);
    }
    public void update(){        
        configureVisual();
        if (isVisible) makeVisible();
    }
    /**
     * This method makes the nation visible
     */
    public void makeVisible(){
        isVisible = true;
        visual.makeVisible();
        if(conquered)marca.makeVisible();
    }
    /**
     * This method makes the nation invisible
     */
    public void makeInvisible(){
        isVisible = false;
        visual.makeInvisible();
    }
    /**
     * This method adds an army to a nation
     */
    public void addArmy(){
        nArmies ++;
        update();
    }
    /**
     * This method removes an army from a nation
     */
    public void delArmy(){
        nArmies --;
        update();
    }
    /**
     * This method adds a route of the nation with another
     * @ param ruta, ruta is the new route for the nation with another
     * @ param rutas, rutas is added to the world is routes
     * @ param nation2, nation2 is the nation with which a route will be created
     */
    public void addRoute(Route ruta, ArrayList<Route> rutas,Nation nation2){
        rutas.add(ruta);
        properRoutes.add(ruta);
        nation2.addRoute(ruta);
    }
    /**
     * This method adds a new route to the nation is own routes 
     * @ param ruta, ruta will be added to the nation is own routes
     */
    public void addRoute(Route ruta){
        if (!properRoutes.contains(ruta))properRoutes.add(ruta);
    }
    /**
     * This method removes a nation from the world canvas
     */
    public void delNation(ArrayList<Route> rutas){
        this.makeInvisible();
        for(Route i: properRoutes) i.delRoute(rutas);
        rutas.removeAll(properRoutes);
    }
    /*
     * This method returns the Y coordinate of the nation
     * of the taking into account the world canvas
     * @ param yPosition, yPosition is the Y coordinate of the antion
     */
    private int getPositionY(int yPosition){
        int total = world.getHeight();
        if (yPosition == 0) return total - yPosition + 
            world.getYPosition() - ALTO;
        return total - yPosition + world.getYPosition();
    }
    /*
     * This method returns the X coordinate of the nation
     * of the taking into account the world canvas
     * @ param xPosition, xPosition is the X coordinate of the antion
     */
    private int getPositionX(int xPosition){
        int total = world.getXPosition();
        if (xPosition == 0) return total + xPosition;
        return total + xPosition-ANCHO;
    }
    
}
