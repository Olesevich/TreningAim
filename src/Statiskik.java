import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Statiskik {

    private JButton b1, b2;
    private JLabel general, total;
    private JLabel levelText, levelTotal, maxLevelTotal;
    private JLabel clikTotalText;
    private JLabel clikTotal, maxClikTotal;
    private JLabel hitsOvalText, hitsTotal, maxHitsTotal;
    private JLabel prozHistOvalText, prozHistOval, maxProzHistOval;


    public Statiskik() {
        callutProz();
        setClikTotal();
        addLabels();
        addButten();
        outputSkrin();
        outputButton();
        addlaben();
    }

    private void addLabels(){
        b1 = new JButton();
        b2 = new JButton();
        general = new JLabel();
        total = new JLabel();
        clikTotalText = new JLabel();
        clikTotal = new JLabel();
        maxClikTotal = new JLabel();
        levelText = new JLabel();
        levelTotal = new JLabel();
        maxLevelTotal = new JLabel();
        hitsOvalText = new JLabel();
        hitsTotal = new JLabel();
        maxHitsTotal = new JLabel();
        prozHistOval = new JLabel();
        prozHistOvalText = new JLabel();
        maxProzHistOval = new JLabel();
    }

    private void createLaben(JLabel lab, int a, int b, String st){
        WindowPanel.panelMiniStatistik.add(lab);
        lab.setBounds(a,b,260,20);
        lab.setText(st);
        lab.setVisible(true);
    }

    private void createLaben(JLabel lab, int a, int b, int c){
        WindowPanel.panelMiniStatistik.add(lab);
        lab.setBounds(a,b,70,20);
        lab.setText(String.valueOf(c));
        lab.setVisible(true);
    }

    private void addlaben(){
        createLaben(general,220, 0, "Дейст.");
        createLaben(total, 260,0,"Макс.");
        createLaben(levelText,10,20,"Уровень: ");
        createLaben(levelTotal,235,20,Config.level);
        createLaben(maxLevelTotal,272,20, Config.maxLevel);
        createLaben(clikTotalText, 10, 35,"Общие количество выстрелов: ");//+15
        createLaben(clikTotal,235,35, Config.numberClikTotal);
        createLaben(maxClikTotal,272,35, Config.maxNumberClikTotal);
        createLaben(hitsOvalText,10,50,"Общее количество попаданий: ");
        createLaben(hitsTotal,235,50,Config.hitsOval);
        createLaben(maxHitsTotal,272,50,Config.maxHistOval);
        createLaben(prozHistOvalText,10,65,"Точность попаданий, %:");
        createLaben(prozHistOval,235,65,Config.prozHistOval);
        createLaben(maxProzHistOval,272,65, Config.prozMaxHistOval);


    }

    private void outputSkrin(){
        setVisible(WindowPanel.panel,false);
        setVisible(WindowPanel.panelUp, false);
        setSizeLocation(Config.MINI_WIDTH + 14,Config.MINI_HEIGH + 37);
        setVisible(WindowPanel.panelMiniStatistik, true);
    }

    private void setSizeLocation(int a, int b){
        MainWindow.jf.setSize(a,b);
        MainWindow.jf.setLocationRelativeTo(null);
    }

    private void setVisible(JPanel pan, boolean bol){
        pan.setVisible(bol);
    }

    private void createButten(JButton bat, String st, int a, int b){
        WindowPanel.panelMiniStatistik.add(bat);
        bat.setBounds(a ,b , 70, 30);
        bat.setFocusable(false);
        bat.setText(st);
        bat.setVisible(true);
    }

    private void addButten(){
        createButten(b1,"Start",60, 250);
        createButten(b2, "Exit", 180, 250);
    }

    private void outputButton(){
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizeLocation(Config.WIDTH + 14,Config.HEIGH + 37);
                setVisible(WindowPanel.panelMiniStatistik, false);
                Config.timerCreating = 1000;
                Config.level = 1;
                Config.numberClikTotal = 0;
                Config.hitsOval = 0;
                new WindowPanel();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    private void setClikTotal(){
        Config.maxNumberClikTotal = setNumber(Config.numberClikTotal, Config.maxNumberClikTotal);
        Config.maxLevel = setNumber(Config.level, Config.maxLevel);
        Config.maxHistOval = setNumber(Config.hitsOval, Config.maxHistOval);
        Config.prozMaxHistOval = setNumber(Config.prozHistOval, Config.prozMaxHistOval);
    }

    private void callutProz(){
        Config.prozHistOval = callut(Config.numberClikTotal,Config.hitsOval);
    }

    private int callut(int a, int b){
        return b * 100 / a;
    }

    private int setNumber(int a, int b){
        if (a > b){
            return a;
        }
        else return b;
    }


}
