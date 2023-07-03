import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCheck extends JFrame {
    private JLabel lblp, lblb;
    private JCheckBox pla, bol;

    public JCheck() {
        super("JCheckBox");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        pla = new JCheckBox("Plain", true);
        bol = new JCheckBox("Bold", false);
        lblp = new JLabel("Plain is selected");
        lblb = new JLabel("Bold is not selected");
        c.add(pla);
        c.add(bol);
        c.add(lblp);
        c.add(lblb);
        pla.addItemListener(new Handler1());
        bol.addItemListener(new Handler1());
        setSize(200, 150);
        setVisible(true);
    }

    public static void main(String args[]) {
        JCheck app = new JCheck();
        app.addWindowListener(new Handler2());
    }

    class Handler1 implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == pla)
                if (e.getStateChange() == ItemEvent.SELECTED)
                    lblp.setText("Plain is selected");
                else
                    lblp.setText("Plain is not selected");
            if (e.getSource() == bol)
                if (e.getStateChange() == ItemEvent.SELECTED)
                    lblb.setText("Bold is selected");
                else
                    lblb.setText("Bold is not selected");
        }
    }

    static class Handler2 extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
