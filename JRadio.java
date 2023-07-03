import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadio extends JFrame {
    private JLabel lbl;
    private JRadioButton pla, bol, ita;
    private ButtonGroup buttonG = new ButtonGroup();

    public JRadio() {
        super("JRadioButton Example");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        lbl = new JLabel("Plain is selected");
        lbl.setFont(new Font("dialog", Font.PLAIN, lbl.getFont().getSize()));
        pla = new JRadioButton("Plain", true);
        bol = new JRadioButton("Bold", false);
        ita = new JRadioButton("Italic", false);
        c.add(pla);
        c.add(bol);
        c.add(ita);
        c.add(lbl);
        pla.addItemListener(new Handler1());
        bol.addItemListener(new Handler1());
        ita.addItemListener(new Handler1());
        
        buttonG.add(pla);
        buttonG.add(bol);
        buttonG.add(ita);

        setSize(200, 150);
        setVisible(true);
    }

    public static void main(String args[]) {
        JRadio app = new JRadio();
        app.addWindowListener(new Handler2());
    }

    class Handler1 implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == pla){
                lbl.setText("Plain is selected");
                lbl.setFont(new Font("dialog", Font.PLAIN, lbl.getFont().getSize()));
            }
            else if (e.getSource() == bol){
                lbl.setText("Bold is selected");
                lbl.setFont(new Font("dialog", Font.BOLD, lbl.getFont().getSize()));
            }
            else{
                lbl.setText("Italic is selected");
                lbl.setFont(new Font("dialog", Font.ITALIC, lbl.getFont().getSize()));
            }
        }
    }

    static class Handler2 extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
