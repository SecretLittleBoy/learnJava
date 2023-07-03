package Graph;
import java.lang.Math;
public class Circle extends Point{
    private int r;
    private Color c;
    public Circle(int x, int y, int r){
        super(x, y);
        this.r = r;
    }
    public int getR(){
        return r;
    }
    public void setR(int r){
        this.r = r;
    }
    public String toString(){
        return "(" + getX() + ", " + getY() + ", " + r + ")";
    }
    public double getArea(){
        return Math.PI * r * r;
    }
}
