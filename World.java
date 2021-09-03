import java.util.*;
/**
 * The world class have on its canvas the nations 
 * with their armies and routes berween them
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class World
{
    private Rectangle world;
    private ArrayList<Nation> nations = new ArrayList<Nation>();
    private ArrayList<Route> routes = new ArrayList<Route>();
    private boolean isVisible;
    private boolean completado; 
    /**
     * Create a rectangle given the height and width
     * @ param lenght, lenght is the lenght of the rectangle
     * @ param width, width is the width of the rectangle
     */
    public World(int lenght, int width){
        world = new Rectangle(lenght,width);
        completado = true;
    }
    /**
     * This method adds a nation
     * @ param color, color is the color of the nation
     * @ param x, x is the x position for the nation is rectangle
     * @ param y, y is the y position for the nation is rectangle
     * @ param armies, armies is the number of armies that 
     * the nation has at the beginning
     */
    public void addNation(String color, int x, int y, int armies){
        if (!nations.contains(searchNation(color))){
            Nation newNation = new Nation(color, x, y, armies, world);
            nations.add(newNation);
        }
        completado = false;
    }
    /**
     * This method adds a route between two nations and gives a cost
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     * @ param cost, cost is the cost of traveling throungh said route
     */
    public void addRoute(String locationA, String locationB, int cost){
        if(!routes.contains(searchRoute(locationA, locationB))){
            Nation nation1 = searchNation(locationA);
            Nation nation2 = searchNation(locationB);
            Route route = new Route(nation1,nation2,cost);
            nation1.addRoute(route,routes,nation2);
            completado = true;
        }
        completado = false;
    }
    /**
     * This method puts an army in a nation
     * @ param location, location is the location of the nation 
     */
    public void putArmy(String location){
        if (!nations.contains(searchNation(location))){
            Nation moreArmy = searchNation(location);
            moreArmy.addArmy();
            completado = true;
        }
        completado = false;
    }
    /**
     * This method eliminates a nation
     * @ param color, color is the identifier of the nation
     * so we delete it
     */
    public void delNation(String color){
        Nation nationDeleted = searchNation(color);
        nationDeleted.delNation(routes);
        nations.remove(nationDeleted);
    }
    /**
     * This method eliminates a route 
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     */
    public void delStreet(String locationA, String locationB){
        Route deletedRoute = searchRoute(locationA, locationB);
        deletedRoute.delRoute(routes);
    }
    /**
     * This method decreases the number of armies a nation has by one
     * @ param location, location is the location of the nation para
     * borrar uno de sus ejercitos
     */
    public void removeArmy(String location){
        Nation minusArmy = searchNation(location);
        minusArmy.delArmy();
    }
    /**
     * This method moves an army from one to another
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     */
    public void moveArmyOneRoute(String locationA, String locationB){
    
    }
    /**
     * This method returns the nations that are conquered
     * @ returns
     */
    public String[] conqueredNations(){
        return null;
    }
    /**
     * This method returns returns the total cost when finally cinquering the world
     * @ return  
     */
    public int payments(){
        return 0;
    }
    /**
     * This method returns if the world has been conquered or not
     * @ return false or true 
     */
    public boolean conquer(){
        return false;
    }
    /**
     * This method makes the world visible
     */
    public void makeVisible(){
        isVisible = true;
        world.makeVisible();
        for(Route i: routes) i.makeVisible();
        for(Nation i: nations) i.makeVisible();
        completado = true;
    }
    /**
     * This method makes the world invisible
     */
    public void makeInvisible(){
        world.makeInvisible();
        for(Nation i: nations)i.makeInvisible();
        for(Route i: routes) i.makeInvisible();
        isVisible = false;
        completado = true;
    }
    /**
     * This method ends whatever operation is being performed
     */
    public void finish(){
        System.exit(0);
    }
    /**
     * This method returns if the last action could be done or not
     * @ return completado, completado is the last actión executed or not
     */
    public boolean ok(){
        return completado;
    }
    private Nation searchNation(String color){
        for (Nation i: nations){
            if (i.getColor().equals(color)) return i;
        }
        return null;
    }
    private Route searchRoute(String locationA, String locationB){
        for (Route i: routes){
            if (i.searchRoute(locationA, locationB)){ 
                return i;
            }
        }
        return null;
    }
}
/** Retrospectiva Ciclo # 1
 * 1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.
 *    Los mini-ciclos elegidos fueron:
 *    1.
 *    2.
 *    3.
 *    4.
 *    
 * 2. ¿Cuál es el estado actual del laboratorio en términos de mini-ciclos? ¿por qué?
 *    En el estado actual del laboatorio logramos llegar hasta el mini-ciclo numero
 *    
 * 3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)
 *    El tiempo total invertido para la entrega del primer ciclo de laboratorio es:
 *    (12 Horas - Ronaldo Henao)
 *    (12 Horas - Cesar Vásquez)
 *    
 * 4. ¿Cuál consideran fue el mayor logro? ¿Por qué?
 *    El mayor logro es hacer de una manera interactiva la interfaz para así lograr entender el problema
 *    de una mejor manera donde lo asimilamos mucho con el tema de grafos. Creemos que entendiendo bien 
 *    graficamente lo que está sucediendo podemos codificar de una buena forma probando y resolviendo lo
 *    que se quiere.
 *    
 * 5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?
 *    El mayor problema técnico para nosotros fue en cierta parte usar de manera correcta Git, 
 *    pues se nos ha dificultado trabajar por comandos que no conocemos y demás, pero es algo que
 *    solucionamos a lo largo del trabajo.
 * 
 * 6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?
 *    Lo que hicimos bien como equipo fue entender el problema, o explicarnos mutuamente si el otro no
 *    entendia. Aparte de eso realizamos el diseño y codificación de manera ordenada y aportando.
 *    Para mejorar resultados claramente hay que dedicarle más tiempo, trabajar más unidos, consultar
 *    dudas con el monitor y profesores que nos puedan ayudar, tambien leer mucho para enteder como 
 *    funcionan nuevas cosas y demás.
 *    
 * 7. Considerando las prácticas XP del laboratorio. ¿cuál fue la más útil? ¿por qué? 
 *    La practica más util fue la de All production code is pair programmed.
 *    Ya que codificamos de manera correcta juntos, aportando, diciendo, dando ideas, entre
 *    otras cosas que se trabajan en equipo.
 *    
 */



