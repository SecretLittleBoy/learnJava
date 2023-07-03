import java.awt.*;
import java.awt.event.*;
class TexEvent extends Frame implements TextListener
{  
  static TexEvent frm=new TexEvent();
  static TextField txt1,txt2;
  public static void main(String args[])
  {  	frm.setTitle("TextEvent");
  	        frm.setSize(240,160);
  	        frm.setLayout(new FlowLayout());
             txt1=new TextField(20);   
  	         txt2=new TextField(20); 
  	         txt1.addTextListener(frm);
  	         frm.add(txt1);       
             txt2.setEditable(false);
              frm.add(txt1);       
              frm.add(txt2);
              frm.setVisible(true);     
   }
   public void textValueChanged(TextEvent e)
   {
       txt2.setText(txt1.getText());
       }
 }
