import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyMenu extends JFrame {
    private JLabel lbl;
    private JMenuBar mb;
    private JMenu col, ext;
    private JMenuItem gre, yel, blu, clo;

    public MyMenu() {
        super("MyMenu");
        Container c = getContentPane();
        mb = new JMenuBar();
        col = new JMenu("color");
        ext = new JMenu("exit");
        gre = new JMenuItem("green");
        yel = new JMenuItem("yellow");
        blu = new JMenuItem("blue");
        clo = new JMenuItem("close window");
        gre.addActionListener(new Handler1());
        yel.addActionListener(new Handler1());
        blu.addActionListener(new Handler1());
        clo.addActionListener(new Handler1());
        mb.add(col);
        mb.add(ext);
        col.add(gre);
        col.add(yel);
        col.add(blu);
        ext.add(clo);
        setJMenuBar(mb);
        lbl = new JLabel("Menu Example");
        add(lbl);
        setSize(200, 150);
        setVisible(true);
    }

    public static void main(String args[]) {
        MyMenu app = new MyMenu();
    }

    class Handler1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem mi = (JMenuItem) e.getSource();
            if (mi == gre)
                lbl.setForeground(Color.green);
            if (mi == yel)
                lbl.setForeground(Color.yellow);
            if (mi == blu)
                lbl.setForeground(Color.blue);
            if (mi == clo)
                System.exit(0);
        }
    }
}
