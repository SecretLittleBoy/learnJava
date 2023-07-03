import java.awt.*;
import java.awt.event.*;

public class KeysEvent2 extends Frame {
    static KeysEvent2 frm = new KeysEvent2();
    static TextField txt1, txt2;

    public static void main(String args[]) {
        frm.setTitle("KeyEvent");
        frm.setSize(240, 130);
        frm.setLayout(new FlowLayout());
        txt1 = new TextField(20);
        txt2 = new TextField(20);
        txt2.setEditable(false);
        txt1.addKeyListener(new KeysAdapter());
        frm.add(txt1);
        frm.add(txt2);
        frm.setVisible(true);
    }

    static class KeysAdapter extends KeyAdapter {
        public void keyTyped(KeyEvent e) {
            txt2.setText(e.getKeyChar() + " is entered!");
        }
    }
}
