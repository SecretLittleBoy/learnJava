import java.awt.*;
import java.awt.event.*;

public class MouEvent3 extends Frame {
    static MouEvent2 frm = new MouEvent2();
    static TextArea txa;
    static TextField txt1, txt2;

    public static void main(String args[]) {
        frm.setTitle("MouEvent");
        frm.setSize(240, 200);
        frm.setLayout(new FlowLayout());
        txa = new TextArea(5, 30);
        txt1 = new TextField(30);
        txt2 = new TextField(30);
        txa.setEditable(false);
        txa.addMouseMotionListener(new MouMotionAdapter());
        frm.add(txa);
        frm.add(txt1);
        frm.add(txt2);
        frm.setVisible(true);
    }

    static class MouMotionAdapter extends MouseMotionAdapter {
        public void mouseMoved(MouseEvent e) // 处理鼠标移动事件
        {
            txt1.setText("Mouse is moved in txa");
        }

        public void mouseDragged(MouseEvent e) // 处理鼠标拖动事件
        {
            txt2.setText("Mouse is dragged in txa");
        }
    }
}
