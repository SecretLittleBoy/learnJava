package Graph;
import java.lang.Math;


class Color{
    private int r,g,b;
    public Color(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public int getR(){
        return r;
    }
    public int getG(){
        return g;
    }
    public int getB(){
        return b;
    }
    public void setR(int r){
        this.r = r;
    }
    public void setG(int g){
        this.g = g;
    }
    public void setB(int b){
        this.b = b;
    }
    public String toString(){
        return "(" + r + ", " + g + ", " + b + ")";
    }
}

public class Point{
    private int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
