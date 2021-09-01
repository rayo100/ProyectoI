import java.util.*;
/**
 * Write a description of class World here.
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (August 31, 2021)
 */
public class World
{
    private Rectangle world;
    private ArrayList<Nation> nations = new ArrayList<Nation>();
    private ArrayList<Route> routes = new ArrayList<Route>();
    private boolean isVisible;
    public World(int lenght, int width){
        world = new Rectangle(lenght,width);
    }
    public void addNation(String color, int x, int y, int armies){
        Nation newNation = new Nation(color, x, y, armies, world);
        nations.add(newNation);
    }
   
    public void addRoute(String locationA, String locationB, int cost){
        Nation nation1 = searchNation(locationA);
        Nation nation2 = searchNation(locationB);
        Route route = new Route(nation1,nation2,cost);
        nation1.addRoute(route,routes,nation2);       
    }
    public void putArmy(String location){
        Nation moreArmy = searchNation(location);
        moreArmy.addArmy();
    }
    public void delNation(String color){
        Nation nationDeleted = searchNation(color);
        nationDeleted.delNation(routes);
        nations.remove(nationDeleted);
    }
    public void delStreet(String locationA, String locationB){
        Route deletedRoute = searchRoute(locationA, locationB);
        deletedRoute.delRoute(routes);
    }
    public void removeArmy(String location){
    
    }
    public void moveArmyOneRoute(String locationA, String locationB){
    
    }
    public String[] conqueredNations(){
        return null;
    }
    public int payments(){
        return 0;
    }
    public boolean conquer(){
        return false;
    }
    public void makeVisible(){
        isVisible = true;
        world.makeVisible();
        for(Route i: routes) i.makeVisible();
        for(Nation i: nations) i.makeVisible();
        
    }
    public void makeInvisible(){
        world.makeInvisible();
        for(Nation i: nations)i.makeInvisible();
        for(Route i: routes) i.makeInvisible();
        isVisible = false;
    }
    public void finish(){
    
    }
    public boolean ok(){
        return false;
    }
    private Nation searchNation(String color){
        for (Nation i: nations){
            if (i.getColor().equals(color)) return i;
        }
        return null;
    }
    

    
}
/** Retrospectiva
 * Diseñar en Astah las clases, metodos y atributos.
 */