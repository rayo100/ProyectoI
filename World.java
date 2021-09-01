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
 * 1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.
 *    Los mini-ciclos elegidos fueron:
 *    
 * 2. ¿Cuál es el estado actual del laboratorio en términos de mini-ciclos? ¿por qué?
 *    En el estado actual del laboatorio logramos llegar hasta el mini-ciclo numero
 *    
 * 3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)
 *    El tiempo total invertido para la entrega del primer ciclo de laboratorio es:
 *    (12 Horas - Ronaldo Henao)
 *    (11 Horas - Cesar Vásquez)
 *    
 * 4. ¿Cuál consideran fue el mayor logro? ¿Por qué?
 *    El mayor logro es hacer de una manera interactiva la interfaz para así lograr entender el problema
 *    de una mejor manera donde lo asimilamos mucho con el tema de grafos. Creemos que entendiendo bien 
 *    graficamente lo que está sucediendo podemos codificar de una buena forma probando y resolviendo lo
 *    que se quiere.
 *    
 * 5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?
 *    
 * 
 * 6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?
 * 7. Considerando las prácticas XP del laboratorio. ¿cuál fue la más útil? ¿por qué? 
 */



