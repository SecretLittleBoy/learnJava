import java.awt.*;

public class Painting extends Frame {
    public Painting() {
        super("Painting");
        setSize(200, 150);
        setVisible(true);
    }

    public static void main(String args[]) {
        Painting app = new Painting();
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(50, 60, 150, 60);
        g.drawRect(50, 70, 100, 50);
        Font fnt = new Font("dialog", Font.ITALIC + Font.BOLD, 15);
        g.setFont(fnt);
        g.drawString("Painting", 70, 100);
    }
}
