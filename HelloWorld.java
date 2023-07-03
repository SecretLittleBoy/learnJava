import java.io.*;
import java.awt.*;
//import Graph.*;

public class HelloWorld {
    // public void printHelloWorld(){
    //     System.out.println("Hello World!");
    // }
    // public void finalize (){
    //     System.out.println("Finalize method is called");
    //     /*
    //      * 在程序中定义的finalize()方法是Java垃圾回收器在销毁对象时自动调用的。
    //      * 但是，无法保证finalize()方法何时被调用，因为Java垃圾回收器的行为是不可预测的。
    //      * 因此，程序中的finalize()方法可能会被调用，也可能不会被调用。
    //      * 即使它被调用了，也无法保证在程序的控制台输出任何内容，因为finalize()方法是在对象被销毁时自动调用的，此时控制台可能已经关闭。
    //      * 因此，程序中的System.out.println("Finalize method is called");语句可能没有执行。
    //      */
    // }
    // private Point privateP;
    public static void main(String[] args) throws IOException {
        // BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Please input a number:");
        // String input = keyin.readLine();  // read input and store in a variable
        // int number = Integer.parseInt(input);
        // System.out.println("number=" + number);

        Frame f = new Frame("Hello Frame");
        f.setSize(300, 200);
        f.setVisible(true);
        Label l = new Label();
        l.setText("Hello Label!");
        l.setAlignment(Label.CENTER);
        l.setBackground(Color.white);
        l.setForeground(Color.red);
        
        f.add(l);
    }
}