/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
/**
 *
 * @author jason
 */
public class TurnBasedGameImproved extends JPanel {
    
    static final int BORDER_SIZE_H = 18;
    static final int BORDER_SIZE_V = 46;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        //JPanel test = new JPanel();
        gamePanel gamePanel = new gamePanel();
        testingPanel panel1 = new testingPanel();
        JFrame frame = new JFrame("potato turnbased game");
        //test.setLayout(null);

        gamePanel.setForeground(Color.blue);
        // background should be black, except it's not opaque, so 
        // background will not be drawn
        gamePanel.setBackground(Color.black);
        // set opaque to false - background not drawn
        gamePanel.setOpaque(false);
        gamePanel.setBounds(0, 0,800, 600);
        
                // drawing should be in blue
        panel1.setForeground(Color.green);
        // background should be black, except it's not opaque, so 
        // background will not be drawn
        panel1.setBackground(Color.black);
        // set opaque to false - background not drawn
        panel1.setOpaque(false);
        panel1.setBounds(0, 0, 800, 600);
        
        frame.add(panel1); 
        
        
        //frame.setContentPane(test);
        //frame.setSize(800, 630);  
        
        //panel1.setPreferredSize(new Dimension(800,600));
        //gamePanel.setPreferredSize(new Dimension(800,600));

        //frame.setUndecorated(true);
        //frame.setMinimumSize(new Dimension(818,646));
        frame.setMinimumSize(new Dimension(800+BORDER_SIZE_H,600+BORDER_SIZE_V));
//        frame.validate();
//        frame.setMaximumSize(new Dimension(900,700));
        frame.pack();
//        frame.getContentPane().setPreferredSize(new Dimension(800, 600));

        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);      
                
        frame.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent event) {
                
                int key = event.getKeyCode();
                System.out.println(key); 
                System.out.println(KeyEvent.VK_LEFT);
                if (panel1.check() == false){                                    
                    switch (key){
                        case 37:
                            System.out.println("you pressed LEFT");
                            panel1.moveLeft();               
                        break;
                    case 38:
                        System.out.println("you pressed UP");
                        break;
                    case 39:
                            System.out.println("you pressed RIGHT");
                            panel1.moveRight();                        
                        break;
                    case 40:
                        System.out.println("you pressed DOWN");
//                panel1.focus();
//                   panel.unfocus();
                //test.add(panel1); //change whos the most recent and is in controlll
//                    panel1.setFocusable(true);
//                    panel.setFocusable(false);
                 //frame.setContentPane(test);
                   //frame.setVisible(true);  
                        break;              
                    case 88:
                        panel1.removeUnit();
                        break;
                    case 90:
                        panel1.selectUnit();
                        break;
                    }
                    if (panel1.check() == true){
//                        frame.getContentPane().removeAll();
                        frame.getContentPane().remove(panel1);
//                        PlayerUnits[] team = new PlayerUnits[4]; // send over the selected units information so the main can send the information into another panel
//                        team = panel1.confirmedUnit();
                        gamePanel.importTeam(panel1.confirmedUnit());
                        frame.getContentPane().add(gamePanel);
//                        gamePanel.setMinimumSize(new Dimension(800,600));
//                        frame.add (gamePanel);
//                        gamePanel.setPreferredSize(new Dimension(800,600));         

                        SwingUtilities.updateComponentTreeUI(frame);
                        frame.pack();
                    }                    
                }
                else {
                    switch (key){
                        case 37://LEFT
                            gamePanel.pressLeft();
                            break;
                        case 38: //UP
                            break;
                        case 39: //RIGHT
                            gamePanel.pressLeft();                            
                            break;
                        case 40: //DOWN
                            break;              
                        case 88: //X
                            gamePanel.pressX();
                            break;
                        case 90: //Z
                            gamePanel.pressZ();
                            break;
                    }            
                }
            }
        }
    );
    frame.setVisible(true);  
               
}
//    public void menuControl(int key){
//        
//    }
}

/*
class Keychecker extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {

        int key = event.getKeyCode();

        System.out.println(key); 
        System.out.println(KeyEvent.VK_LEFT);
        switch (key){
            case 37:
               System.out.println("you pressed LEFT");
               
               break;
           case 38:
               System.out.println("you pressed UP");
               
               break;
           case 39:
               System.out.println("you pressed RIGHT");
               break;
           case 40:
               System.out.println("you pressed DOWN");
               break;
              
      }
    }
      
       
}
*/