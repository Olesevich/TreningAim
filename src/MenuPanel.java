import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel {

    private JMenuBar menuBar;
    public static JLabel labenLevel, labenLive;
    private JLabel labelLevelText, labenLiveTeext;

    public MenuPanel() {
        creatinMenuBar();
        creatinIkon();
        labenLevel = new JLabel();
        labenLive = new JLabel();
        labelLevelText = new JLabel();
        labenLiveTeext = new JLabel();
        addLaben();
    }

    private void creatinMenuBar(){
        menuBar = new JMenuBar();
        WindowPanel.panelUp.add(menuBar);
        menuBar.setBounds(0,0,Config.WIDTH-482,22);
    }

    private void creatinIkon(){
        JMenu mnNewMenu = new JMenu("Файл");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Новая игра");
        mnNewMenu.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Выход");
        mnNewMenu.add(mntmNewMenuItem_1);
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        JMenu mnNewMenu_1 = new JMenu("Настройки");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Автор");
        mnNewMenu_1.add(mntmNewMenuItem_2);
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Автор проекта Олесевич Александр Сергеевич");
            }
        });
        menuBar.updateUI();
    }

    private void createLaben(JLabel lab, int a, int b){
        WindowPanel.panelUp.add(lab);
        lab.setBounds(a, b,40, 20);
        lab.setFont(new Font("Arial",Font.BOLD,14));
        lab.setVisible(true);
    }

    private void createLaben(JLabel lab, int a, int b, String st){
        WindowPanel.panelUp.add(lab);
        lab.setBounds(a, b,100, 20);
        lab.setFont(new Font("Arial",Font.BOLD,14));
        lab.setText(st);
        lab.setVisible(true);
    }

    private void addLaben(){
        createLaben(labelLevelText,200 ,2,"Level: ");
        createLaben(labenLiveTeext,400 , 2,"Live: ");
        createLaben(labenLevel,250,2);
        createLaben(labenLive, 440, 2);
    }
}
