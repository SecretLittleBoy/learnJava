import java.awt.*;
import java.awt.event.*;

public class MouEvent extends Frame implements MouseListener {
    static MouEvent frm = new MouEvent();
    static TextArea txa1, txa2;

    public static void main(String args[]) {
        frm.setTitle("MouEvent");
        frm.setSize(240, 300);
        frm.setLayout(new FlowLayout());
        txa1 = new TextArea(5, 30);
        txa2 = new TextArea(8, 30);
        txa2.setEditable(false);
        txa1.addMouseListener(frm);
        frm.add(txa1);
        frm.add(txa2);
        frm.setVisible(true);
    }

    public void mouseEntered(MouseEvent e) // 鼠标进入事件处理
    {
        txa2.setText("Mouse enters txa1\n");
    }

    public void mouseClicked(MouseEvent e) // 鼠标单击事件处理
    {
        txa2.append("Mouse is clisked  at[" + e.getX() + "," + e.getY() + "]\n");
    }

    public void mousePressed(MouseEvent e) // 鼠标按键事件处理
    {
        txa2.append("Mouse is pressed at [" + e.getX() + "," + e.getY() + "]\n");
    }

    public void mouseReleased(MouseEvent e) // 鼠标键释放事件处理
    {
        txa2.append("Mouse is released at [" + e.getX() + "," + e.getY() + "]\n");
    }

    public void mouseExited(MouseEvent e) // 鼠标离开事件处理
    {
        txa2.append("Mouse exits from txa1 ");
    }
}
