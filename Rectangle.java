import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */

public class Rectangle{

    public static int EDGES = 4;
    
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private int[] positions;
    private String str = "";

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangle(){
        height = 30;
        width = 40;
        xPosition = 70;
        yPosition = 15;
        color = "magenta";
        isVisible = false;
    }
    /**
     * This method create a new rectangle at default position with 
     * default color and with optional height and width
     * @ param xheight, xheight is the heigt of the world rectangle
     * @ param ywidht, ywidht is the widht of the world rectangle
     */
    public Rectangle(int xheight,int ywidth){
        height = xheight;
        width = ywidth;
        xPosition = 50;
        yPosition = 50;
        color = "light_gray";
        isVisible = false;
    }
    /**
     * This method modifies a rectangle and if position
     * @ param newHeight, newHeight is the heigt of the new rectangle
     * @ param newWidth, newWidth is the widht of the new rectangle
     * @ param newXPos, newXPos is the X position of the new rectangle
     * @ param newYPos, newYPos is the Y position of the new rectangle
     */
    public void modRectangle(int newHeight, int newWidth, int newXPos, int newYPos){
        height = newHeight;
        width = newWidth;
        xPosition = newXPos;
        yPosition = newYPos;
        color = "green";
    }
    /**
     * This method returns the Y coordinate of the rectagle
     * @ return yPosition, yPosition is the Y coordinate of the rectagle
     */    
    public int getYPosition(){
        return yPosition;
    }
    /**
     * This method returns the Y coordinate of the rectagle
     * @ return yPosition, yPosition is the Y coordinate of the rectagle
     */
    public int getXPosition(){
        return xPosition;
    }
    /**
     * This method returns the height of the rectagle
     * @ return height, height is the height of the rectagle
     */
    public int getHeight(){
        return this.height;
    }
    /**
     * This method returns the width of the rectagle
     * @ return width, width is the width of the rectagle
     */
    public int getWidth(){
        return this.width;
    }
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }
    /**
     * Move the rectangle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }
    /**
     * Move the rectangle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }
    /**
     * Move the rectangle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }
    /**
     * Move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }
    /**
     * This method changes the positions of the rectangle
     * @ param newX, newX is the new X position of the rectangle
     * @ param newY, newY is the new Y position of the rectangle
     */
    public void changePosition(int newX, int newY){
        xPosition = newX;
        yPosition = newY;
        draw();
    }
    /**
     * This method returns the string
     * @ return str, str is the string I want to get
     */
    public String getString(){
        return this.str;
    }
    /**
     * This method places a new string
     * @ param newString, newString is the new chain that you want to place
     */
    public void setString(String newString){
        this.str = newString;
    }
    /*
     * Draw the rectangle with current specifications on screen.
     */

    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            positions = new int[]{xPosition,yPosition};
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, 
                                       width, height),str,positions);
            canvas.wait(10);
        }
    }

    /*
     * Erase the rectangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}

