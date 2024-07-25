import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawSkrin extends JLabel {

    GameField gf = new GameField();

    public DrawSkrin() {
        setLayout(null);
        setBounds(0,0,Config.WIDTH,Config.HEIGH);
        setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (int i = 0; i < gf.getPosition_x().size(); i++) {
            g.fillOval(gf.getPosition_x().get(i),gf.getPosition_y().get(i),15,15);//15
        }
        repaint();
    }
}
