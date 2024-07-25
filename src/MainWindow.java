import javax.swing.*;

public class MainWindow {

    public static JFrame jf;


    public MainWindow() {
        jf = new JFrame("Trening_Aim");
        jf.setSize(Config.WIDTH + 14,Config.HEIGH + 59);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Config();
        new MainWindow();
        new WindowPanel();
    }
}
