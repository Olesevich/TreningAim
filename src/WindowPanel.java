import javax.swing.*;
import java.awt.*;

public class WindowPanel {

    public static JPanel panel;
    public static JPanel panelUp;
    public static JPanel panelMiniStatistik;


    public WindowPanel() {
        panel = new JPanel();
        panelUp = new JPanel();
        panelMiniStatistik = new JPanel();
        addPanels();
        new MenuPanel();
        addDrawSkrin();
        addMouse();
    }

    private void creatPanel(JPanel pan, int x, int y, int h, int l, Color col, boolean visebabl){
        pan.setLayout(null);
        MainWindow.jf.add(pan);
        pan.setBounds(x,y,h,l);
        pan.setVisible(visebabl);
        pan.setBackground(col);
    }

    public void addPanels(){
        creatPanel(panel,0,22,Config.HEIGH,Config.WIDTH,Color.DARK_GRAY, true);//оснавная панель
        creatPanel(panelUp,0,0,Config.WIDTH, 22, Color.WHITE, true);//дополнительная панель, которая сверху
        creatPanel(panelMiniStatistik,0,0,Config.MINI_WIDTH,Config.MINI_HEIGH,Color.WHITE,false);
    }

    private void addDrawSkrin(){
        panel.add(new DrawSkrin());
        panel.updateUI();
    }

    private void addMouse(){
        panel.addMouseListener(new Mouse());
    }

}
