import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {

    static final int width = 800;  //Storlek på spelrutan
    static final int height = 800;
    static final int elementStorlek = 25
    static final int spelElement = (width*height)/(elementStorlek)




    Panel(){


 }
 public void startaSpel() {    //Fixar alla basics.

 }
 public void ritaGrejer(Graphics g) {

 }
 public void rita(Graphics g){

 }
 public void rörelse() {

 }
 public void mat() {

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

    @Override
    public void keyPressed(KeyEvent keyEvent) { //Ska lägga till orm senare.
        if (keyEvent.getKeyChar() == 'a') {
             = -5;
        }
        if (keyEvent.getKeyChar() == 'd') {
             = 5;
        }
        if (keyEvent.getKeyChar() == 'w') {
             = -5;
        }
        if (keyEvent.getKeyChar() == 's') {
             = 5;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
             = -5;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
             = 5;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
             = -5;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
             =5;
        }

    }
 }
}
