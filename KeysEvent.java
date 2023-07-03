import java.awt.*;
import java.awt.event.*;

public class KeysEvent extends Frame implements KeyListener {
    static KeysEvent frm = new KeysEvent();
    static TextField txf;
    static TextArea txa;

    public static void main(String args[]) {
        frm.setTitle("KeyEvent");
        frm.setSize(240, 200);
        frm.setLayout(new FlowLayout());
        txf = new TextField(20);
        txa = new TextArea(20, 20);
        txa.setEditable(false);
        txf.addKeyListener(frm);
        frm.add(txf);
        frm.add(txa);
        frm.setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        txa.setText("");
        txa.append(e.getKeyChar() + " is pressed!\n");
    }

    public void keyReleased(KeyEvent e) {
        txa.append(e.getKeyChar() + " is released!\n");
    }

    public void keyTyped(KeyEvent e) {
        txa.append(e.getKeyChar() + " is typed!\n");
    }
}