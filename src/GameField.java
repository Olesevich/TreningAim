import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameField implements ActionListener{

    public Timer timer1;
    private int random_x;
    private int random_y;
    private static ArrayList <Integer> position_x;
    private static ArrayList <Integer> position_y;
    private static int positionMouse_x;
    private static int positionMouse_y;
    public static int points;//количество раз, когда попал в кружой
    public static int pastePoints;//количество раз, когда не попал в кружок
    private boolean inGame = true;
    private int lostOval;//количество кружков которые исчезнут до проигрыша, жизни в раунде


    public GameField() {
        timerStart();
        position_x = new ArrayList<Integer>();
        position_y = new ArrayList<Integer>();
        addArrayPosition();
        points = 0;
        pastePoints = 0;
        lostOval = 5;
    }

    public ArrayList<Integer> getPosition_x() {
        return position_x;
    }

    public ArrayList<Integer> getPosition_y() {
        return position_y;
    }

    private void timerStart(){
        timer1 = new Timer(Config.timerCreating, this );
        timer1.start();
    }

    private int randomNumber(){// плохой рандом, предсказуемый
        return (int)(Math.random()*600);
    }

    public static int setPositionMous_X(MouseEvent e){
        return positionMouse_x  = e.getX();
    }

    public static int setPositionMous_Y(MouseEvent e){
        return positionMouse_y  = e.getY();
    }

    public static void positionMouse(MouseEvent e){
        setPositionMous_X(e);
        setPositionMous_Y(e);
        comparePosition();
    }

    private static void comparePosition(){
        boolean inPoint = true;
        for (int i = 0; i < position_x.size(); i++) {
            if ((position_x.get(i) + 15) >= positionMouse_x && positionMouse_x >= position_x.get(i)
                    && (position_y.get(i) + 15) >= positionMouse_y && positionMouse_y >= position_y.get(i)){
                delArray(position_x,i);
                delArray(position_y,i);
                points++;
                Config.hitsOval++;
                inPoint = false;
            }
        }
        if (inPoint){
            pastePoints++;
        }
    }

    private void receivengRandom(){
        random_x = randomNumber();
        random_y = randomNumber();
    }

    private void addArray(ArrayList<Integer> a, int b){
        a.add(b);
    }

    private void addArrayPosition(){
        receivengRandom();
        addArray(position_x,random_x);
        addArray(position_y,random_y);
    }

    private static void delArray(ArrayList<Integer> a, int i){
        a.remove(i);
    }

    private void delArrayPosition(){
        delArray(position_x,0);
        delArray(position_y,0);
    }

    private void outputSkrinText(JLabel lab, int a){
        String str = String.valueOf(a);
        lab.setText(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            addArrayPosition();
            if (position_x.size() > 5) {
                delArrayPosition();
                lostOval--;
            }
        }
        if (lostOval == 0){
            inGame = false;
            timer1.stop();
            JOptionPane.showMessageDialog(null, "Вы проиграли!!!");
            new Statiskik();
        }
        if (points == Config.NEW_LEVEL_POINT){
            timer1.stop();
            Config.level++;
            new LevelUp();
        }
        outputSkrinText(MenuPanel.labenLevel, Config.level);
        outputSkrinText(MenuPanel.labenLive, lostOval);
    }
}
