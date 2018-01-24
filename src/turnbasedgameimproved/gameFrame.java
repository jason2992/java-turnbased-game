/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jason
 */
public class gameFrame extends JPanel{
    PlayerUnits[] playerUnit = new PlayerUnits[4]; // send over the selected units information so the main can send the information into another panel
    EnemyUnits[] enemyUnit = new EnemyUnits[5]; // send over the selected units information so the main can send the information into another panel
    private BufferedImage layout;
    
    public gameFrame(){
        try {                
          layout = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\battlelayout.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }
       repaint();
    }
    //code goes here
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
//        g.setColor(Color.BLUE);
//        g.fillRect(squareX,squareY,squareW,squareH);
        
        int width = getWidth() - 20;
        int height = getHeight() - 20;
        //g.drawArc(x, y, width, height, 0, 360);
        //g.fillRect(squareX,squareY,squareW,squareH);

        g.drawImage(layout, 0, 0, this);
        g.drawImage(playerUnit[0].getImage(), 200, 320, this);
        g.drawImage(playerUnit[1].getImage(), 300, 320, this);
        g.drawImage(playerUnit[2].getImage(), 400, 320, this);
        g.drawImage(playerUnit[3].getImage(), 500, 320, this);

    }
    public void importTeam(PlayerUnits[] teamUnits){
        for (int i = 0; i <= 3; i++){
            playerUnit[i] = teamUnits[i];            
        }
    }
}
