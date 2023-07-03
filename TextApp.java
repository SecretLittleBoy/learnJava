import java.awt.*;
public class TextApp
{
  public static void main(String args[])
  {
   Frame fra=new Frame("文本框程序");
   TextField txt1=new TextField(5);
   TextField txt2=new TextField("Text Field", 5);
   fra.setBounds(0,0,300,200);
   fra.setLayout(null);               
   txt1.setBounds(50,50,130,20);     //设置文本框的大小
   txt2.setBounds(50,100,130,30);    
   fra.add(txt1);     fra.add(txt2); 
   fra.setVisible(true);     }
}
