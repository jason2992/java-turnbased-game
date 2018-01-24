/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;

import java.lang.String;
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
import java.lang.Math;
/**
 *
 * @author jason
 */
public class gamePanel extends JPanel{ 
    public static final int MAX_ENEMY_NUM = 5;
    PlayerUnits[] playerUnit = new PlayerUnits[4]; // send over the selected units information so the main can send the information into another panel
    EnemyUnits[] enemyUnit = new EnemyUnits[MAX_ENEMY_NUM]; // send over the selected units information so the main can send the information into another panel
    private BufferedImage layout;
    private int currentLevel = 1;
    private int numEnemies;
    private int numAlive;
    private int menuAt = 0; //0 = choose unit, 1 = choose action, 2 = choose target, 3 = choose skills, 4 = choose target from skill
    int[] selection = new int[5];
//    private int selection0 = 0; // select unit
//    private int selection1 = 0; // choose action
//    private int selection2 = 0; // target, send info to 4 whenever
//    private int selection3 = 0; // skill selection 
//    private int selection4 = 0; // target, copy 2 whenever get chance
    
    public int getLevel (){
        return currentLevel;
    }
    public void nextLevel (){
        currentLevel += 1;
        //call create enemies
    }
    
    
    public gamePanel(){
        for (int i = 0; i < MAX_ENEMY_NUM;i++){
            enemyUnit[i] = new Slime(); //initialize all enemies as dead            
            enemyUnit[i].setHealth(0); //initialize all enemies as dead
        }
        
        try {                
          layout = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\battlelayout.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }
       
       createLevelEnemies();
       repaint();
    }
    //code goes here
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
        g.setColor(Color.BLUE);
//        g.fillRect(squareX,squareY,squareW,squareH);
        

        g.drawImage(layout, 0, 0, this);
        
        
//        g.drawImage(playerUnit[0].getImage(), 200, 320, this);
//        g.drawImage(playerUnit[1].getImage(), 300, 320, this);
//        g.drawImage(playerUnit[2].getImage(), 400, 320, this);
//        g.drawImage(playerUnit[3].getImage(), 500, 320, this);
        for (int i = 0; i < 4; i++){
            if (playerUnit[i].getHealth() > 0){
                g.drawImage(playerUnit[i].getImage(), 200 + (i * 100), 320, this);                               
            }
        }
        
        if (menuAt == 1){
            
        }
        
        for (int i = 0; i < MAX_ENEMY_NUM; i++){
            if (enemyUnit[i].getHealth() > 0){
                g.drawImage(enemyUnit[i].getImage(), 250 + (i * 75), 170, this);                               
                g.drawString(enemyUnit[i].getHealth() + "/" + enemyUnit[i].getMaxHealth(), 240 + (i * 75), 200);
            }
        }
        

    }
    public void importTeam(PlayerUnits[] teamUnits){
        for (int i = 0; i <= 3; i++){
            playerUnit[i] = teamUnits[i];            
        }
    }
    
    public void createLevelEnemies (){
        if (currentLevel == 1){
            numEnemies = 2;
            for (int i = 0; i < numEnemies; i++){
                enemyUnit[i] = new Slime();
                enemyUnit[i].createStats();
            }
        }
        else if (currentLevel == 2){
            numEnemies = (int) (Math.random() * 2 + 2); //between 2 and 3

        }
    }
    public void pressLeft(){
        if (selection[menuAt] > 0){
            selection[menuAt] -= 1;
        }
    }
    public void pressRight(){
        switch (menuAt){
            case 0: 
                
        }
        
    }
    public void pressX(){
        
    }
    public void pressZ(){
        
        //check if all enemies are dead after each attack and move onto the next level if they are all dead
    }
    
//    public void chooseEnemy (int)
    public void organiseEnemy(){
        EnemyUnits tempSwap;
        for(int k = 0; k < MAX_ENEMY_NUM; k++){ 
            for (int i = 0; i < MAX_ENEMY_NUM - 1; i++){
                if (enemyUnit[i].getHealth() <= 0){
                    tempSwap = enemyUnit[i];
                    enemyUnit[i] = enemyUnit[i + 1];
                    enemyUnit[i + 1] = tempSwap;
                }
            }
        }
    }
    public void organisePlayer(){
        PlayerUnits tempSwap;
        for(int k = 0; k < 4; k++){ 
            for (int i = 0; i < 4 - 1; i++){
                if (playerUnit[i].getHealth() <= 0){
                    tempSwap = playerUnit[i];
                    playerUnit[i] = playerUnit[i + 1];
                    playerUnit[i + 1] = tempSwap;
                }
            }
        }
    }

}

