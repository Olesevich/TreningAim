import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUp implements ActionListener {

    private Timer timer;
    private JLabel lab;

    public LevelUp() {
        timeRStart();
        creatinLaben();
    }

    private void timeRStart(){
        timer = new Timer(2000,this);
        timer.start();
    }

    private void creatinLaben(){
        lab = new JLabel();
        WindowPanel.panel.add(lab);
        lab.setBounds(250,250,300,100);
        lab.setForeground(Color.RED);
        lab.setFont(new Font("Arial",Font.BOLD,32));
        lab.setText("LEVEL " + Config.level);
        lab.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        lab.setVisible(false);
        Config.timerCreating -= 50;
        new GameField();
    }
}
