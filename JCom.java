import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JCom extends JFrame {
    private JLabel lbl;
    private Object cities[] = { "北京市", "上海市", "天津市", "重庆市", "郑州市", "太原市", "石家庄市" };
    private JList lst;
    public JCom() {
        super("JList");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        lst = new JList(cities);
        //lst.setMaximumRowCount(4);
        lbl = new JLabel("请从组合框中选择 ");
        c.add(lst);
        c.add(lbl);
        lst.addListSelectionListener(new Handler1());
        //addItemListener(new Handler1());
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String args[]) {
        JCom app = new JCom();
        app.addWindowListener(new Handler2());
    }

    class Handler1 implements ListSelectionListener { // 使用ListSelectionListener接口
        public void valueChanged(ListSelectionEvent e) { // 使用valueChanged方法
            lbl.setText("您选中了：" + lst.getSelectedValue()); // 使用getSelectedValue方法获取选中项
        }
    }

    static class Handler2 extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
