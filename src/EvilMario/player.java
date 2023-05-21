package EvilMario;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class player {
    int x, dx, y, nx, nx2, distanceTraveled;
    Image player;
    ImageIcon playerFacingLeft = new     ImageIcon("images/MarioLeft.png");
    ImageIcon playerFacingRight = new     ImageIcon("images/MarioRight.png");

    public player() {
        player = playerFacingRight.getImage();
        x = 75;
        y = 285;
        nx = -0;
        nx2 = -575;
        distanceTraveled = 24;
    }

    public void move() {
        if(x>0 && x<300) {
            x = x+dx;
            nx = nx+dx;
            nx2 = nx2+dx;
        }
        if(x<=0) {
            x=1;                                                                             
            nx = nx+(dx*(int)0.5);
            nx2 = nx2+(dx*(int)0.5);
        }
        if(x>=300) {
            x=299;
            nx = nx+(dx*(int)0.5);
            nx2 = nx2+(dx*(int)0.5);
        }
        if(dx>0)distanceTraveled++;else if(dx<0)distanceTraveled--;
        if(distanceTraveled>104)x=299;
        if(x==1 && dx<0)
            distanceTraveled++;
        if(distanceTraveled<104){
            nx=0;
            nx2=-575;
        }
    }

    public int   getX()     { return x;      }
    public int   getY()     { return y;      }
    public Image getImage() { return player; }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT) {
            player = playerFacingLeft.getImage();
            if(distanceTraveled<104)dx=-3;else dx=-2;
        }

        if(key == KeyEvent.VK_RIGHT) {
            player = playerFacingRight.getImage();
            if(distanceTraveled<104)dx=3;else dx=2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
            dx = 0;
    }
}