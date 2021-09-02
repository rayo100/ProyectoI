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
    private boolean completado; 
    public World(int lenght, int width){
        world = new Rectangle(lenght,width);
        completado = true;
    }
    public void addNation(String color, int x, int y, int armies){
        if (!nations.contains(searchNation(color))){
            Nation newNation = new Nation(color, x, y, armies, world);
            nations.add(newNation);
        }
        completado = false;
    }
   
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
    public void putArmy(String location){
        if (!nations.contains(searchNation(location))){
            Nation moreArmy = searchNation(location);
            moreArmy.addArmy();
            completado = true;
        }
        completado = false;
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
        Nation minusArmy = searchNation(location);
        minusArmy.delArmy();
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
        completado = true;
    }
    public void makeInvisible(){
        world.makeInvisible();
        for(Nation i: nations)i.makeInvisible();
        for(Route i: routes) i.makeInvisible();
        isVisible = false;
        completado = true;
    }
    public void finish(){
        System.exit(0);
    }
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



