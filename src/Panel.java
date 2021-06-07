import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Panel extends JPanel implements ActionListener{

    static final int width = 800;  //Storlek på spelrutan
    static final int height = 650;
    static final int elementStorlek = 50;
    static final int spelElement = (width*height)/elementStorlek;
    static final int delay = 120;

    final int x[] = new int[spelElement];
    final int y[] = new int[spelElement];

    int ormDelar = 6;
    int matKonsumering;
    int matX;
    int matY;
    char direction = 'R';
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
        timer = new Timer(delay,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rita(g);
    }
    public void rita(Graphics g) {                     //Visste ej hur man gjorde detta såtog hjälp av google men förstår koden nu.
                                                       //Men detta är ormen hur hur den blir större.
        if(running) {
            g.setColor(Color.white);
            g.fillRect(matX, matY, elementStorlek, elementStorlek);

            for(int i = 0; i< ormDelar;i++) {
                if(i == 0) {
                    g.setColor(Color.green  );
                    g.fillRect(x[i], y[i], elementStorlek, elementStorlek);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    g.fillRect(x[i], y[i], elementStorlek, elementStorlek);
                }
            }
            g.setColor(Color.white);
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+matKonsumering, (width - metrics.stringWidth("Score: "+matKonsumering))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }
    public void nyMat(){
        matX = random.nextInt((int)(width/elementStorlek))*elementStorlek;
        matY = random.nextInt((int)(height/elementStorlek))*elementStorlek;
    }
    public void rörelse(){
        for(int i = ormDelar;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - elementStorlek;
                break;
            case 'D':
                y[0] = y[0] + elementStorlek;
                break;
            case 'L':
                x[0] = x[0] - elementStorlek;
                break;
            case 'R':
                x[0] = x[0] + elementStorlek;
                break;
        }

    }
    public void checkMat() {
        if((x[0] == matX) && (y[0] == matY)) {
            ormDelar++;
            matKonsumering++;
            nyMat();
        }
    }
    public void checkCollisions() {                //Suicide kollision
        for(int i = ormDelar;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
                                                   //Kollision vänster
        if(x[0] < 0) {
            running = false;
        }
                                                   //Kollision höger
        if(x[0] > width) {
            running = false;
        }
                                                   //Kollision tak
        if(y[0] < 0) {
            running = false;
        }
                                                   //Kollision golv
        if(y[0] > height) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {             //game over texten
        g.setColor(Color.white);
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+matKonsumering, (width - metrics1.stringWidth("Score: "+matKonsumering))/2, g.getFont().getSize());
        g.setColor(Color.red);
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (width - metrics2.stringWidth("Game Over"))/2, height/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            rörelse();
            checkMat();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {          //Rörelse
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
