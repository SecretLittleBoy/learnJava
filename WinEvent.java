import java.awt.*;
import java.awt.event.*;

public class WinEvent extends Frame implements WindowListener {
    static WinEvent frm = new WinEvent();

    public static void main(String args[]) {
        frm.setTitle("MouEvent");
        frm.setSize(240, 200);
        frm.addWindowListener(frm);
        frm.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing() method");
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed() method");
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated() method");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated() method");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified() method");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified() method");
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened() method");
    }
}
