package EvilMario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class board extends JPanel implements ActionListener {
    player p;
    Image background, menuBg;
    Timer time;
    private menu Menu;
    private frame Frame;

    public static enum STATE {MENU,GAME};

    public static STATE State = STATE.MENU;

    public board() {
        this.addMouseListener(new mouseInput());
        p = new EvilMario.player();
        Menu = new EvilMario.menu();

        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("images/Menu.png");
        menuBg = i.getImage();
        i = new ImageIcon("images/EvilMario_Background.png");
        background = i.getImage();
        time = new Timer(20,this);
        time.start();
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }

    public void paintComponent(Graphics g) {
        if(State==STATE.GAME) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.drawImage(background, -p.nx, 0, null);


            if(-p.nx<-575)
                p.nx=-575;
            else if(-p.nx>575)
                p.nx=575;

            if(-p.nx2<-575)
                p.nx2=-575;
            else if(-p.nx2>575)
                p.nx2=575;

            g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        } else {
            g.drawImage(menuBg, 0, 0, null);
            menu.render(g);
        }
    }

    private class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }
}