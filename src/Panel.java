import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    static final int width = 800;  //Storlek på spelrutan
    static final int height = 800;
    static final int elementStorlek = 25;
    static final int spelElement = (width*height)/elementStorlek;
    static final int delay = 75;

    final int[] x = new int[spelElement];
    final int[] y = new int[spelElement];
    int ormDelar = 6;
    int matKonsumering;
    int matX;
    int matY;

    String direction = "R";
    boolean running = false;
    Timer timer;
    Random random;


    Panel(){
        random = new Random();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startaSpel();


 }
 public void startaSpel() {    //Fixar alla basics.
        nyMat();
        running = true;
        timer = new Timer(delay, this);
 }
 public void ritaGrejer(Graphics g) {
        super.paintComponent(g);
        rita(g);
 }
 public void rita(Graphics g){

 }
 public void rörelse() {

 }
 public void nyMat() {

 }
 public void duFörlorar() {

 }
 //måste fixa kollisioner också men glömt hur man gör det nu. Så ska fixa det senare då jag frågat om hur man gör.

    private void drawOrm(Graphics g, int x, int y) {
        g.setColor(Color.gray);
        int[] xs = {x, 10 + x, 20 + x};
        int[] ys = {30 + y, y, 30 + y};
        g.fillRect(10 + x, 30 + y, 10, 10);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{

    }
}
