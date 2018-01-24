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
public class testingPanel extends JPanel{
    private int squareX = 60;
    private int squareY = 60;
    private int squareW = 30;
    private int squareH = 30;
    private int unitNum = 1;
    private int unitChoice = 1;
    private BufferedImage knight;
    private BufferedImage archer;
    private BufferedImage mage;
    private BufferedImage healer;
    private BufferedImage cursor;
    private BufferedImage unit1;
    private BufferedImage unit2;
    private BufferedImage unit3;
    private BufferedImage unit4;
    private BufferedImage unitUnknown;;
    private BufferedImage layout;
    private int x = 40;
    private int y = 120; 
    private boolean completeSelection = false; //so the main program can tell whether selection is done
    PlayerUnits[] selectedUnits = new PlayerUnits[4]; // send over the selected units information so the main can send the information into another panel
    
    public boolean check(){
        return completeSelection;
    }
    
    public testingPanel(){
        try {                
          knight = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_0.png")); //this is how to add images
          archer = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_1.png")); //this is how to add images
          mage = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_2.png")); //this is how to add images
          healer = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_3.png")); //this is how to add images
          cursor = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_4.png")); //this is how to add images          
          unitUnknown = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_5.png")); //this is how to add images
          layout = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\layout.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }
        /*
        try {                
          archer = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_1.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }
       try {                
          mage = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_2.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }
       try {                
          healer = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_3.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }*/
    }
    
//    private boolean focus = true;
    /*
    public testingPanel(){
        //creates an action 
        
        Action leftAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    if (focus){
//                        x-=50;
//                    }
                    x-=50;
                    repaint();
                }
            };
        //creates an action
        Action rightAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /* so, i can use this panel as the game panel
                    , have the image be the static
                    for healthbars, i can figure that out from google
                    for decision making i can make it pass the units down into this panel to play on?
                        use a bunch of booleans to decide what kind of decision making is going to happen
                        such as
                        press z to confirm (change the booleans, set the cursor somewhere, do stuff
                    but the problem is how to choose target? (since target can be ally or enemy) (want to avoid the massive block like before.)
                            solutions?
                                add a panel to this panel, that takes controll of key listener to help make decisions?
                                make all the action buttons using the key listener in the main function
                                that way it has all the information, its always being read anyways, and can control whats going on
                                use the panel just for animation 
                                    if i want to make a unit attack lets say
                                    have a function i can call after a sequence of presses from the main function. the main function will have ALOT of booleans to ensure the right things are displaying
                                    this panel will also have booleans to coresspond with the main. while they both may be following the same instructions, they are in fact. but one is to controll what the game
                                        is doing, while the other is controlling what the game displays
                                    the function will animate/put the displace for the game
                    
                    use gamePanel to display how to select unit types
                    and switch over to this panel once the selection is done
                    in the units pages, maybe add an image to them so its easier to pass along?
                    
                                
                
                    
                    
                    
//                    if (focus){
//                        x+=50;
//                    }
                    x+=50;
                    //redraws
                    repaint();
                }
            };
        //tells what keystroke does what
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), rightAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0), rightAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), rightAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), rightAction);

        try {                
          image = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\temporary.png")); //this is how to add images
       } catch (IOException ex) {
           System.out.println ("hi");           // handle exception...
       }
    }
    private void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
        //something to check if in focused window?
        InputMap im = getInputMap(condition);
        //something to do with the library?
        ActionMap am = getActionMap();
        
        im.put(keyStroke, name);
        //takes the action map(the panel class?), and calls the action?
        am.put(name, action);
    } 
*/
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
        g.drawImage(knight, 40, 200, this);
        g.drawImage(archer, 140, 200, this);
        g.drawImage(mage, 240, 200, this);
        g.drawImage(healer, 340, 200, this);
        g.drawImage(cursor, x, y, this);

        g.drawImage(unit1, 500, 320, this);
        g.drawImage(unit2, 600, 320, this);
        g.drawImage(unit3, 500, 420, this);
        g.drawImage(unit4, 600, 420, this);

       // g.fillRect(x, y, 50, 50);
    }
    public void run() {
       while(true){
        repaint();
        try {
           Thread.sleep(17);
        } catch (InterruptedException e) {
             System.out.println("Thread generates an error.");
        }
    }
       
  }
    public void moveLeft(){
        
        if (x != 40 && unitNum != 5){
            this.x-=100;          
            repaint();
            unitChoice-=1;
        }
    }
    public void moveRight(){
        if (x != 340 && unitNum != 5){
            this.x+=100;  
            repaint();
            unitChoice+=1;
        }
    }
    public void selectUnit(){
        
        switch (unitNum){
            case 1:
                switch (unitChoice){
                    case 1:
                        unit1 = knight;
                        selectedUnits[0] = new Knight();
                        break;
                    case 2:
                        unit1 = archer;
                        selectedUnits[0] = new Archer();
                        break;
                    case 3:
                        unit1 = mage;
                        selectedUnits[0] = new Mage();
                        break;
                    case 4:
                        unit1 = healer;
                        selectedUnits[0] = new Healer();
                        break;                        
                }
                unitNum += 1;
                break;
            case 2:
                switch (unitChoice){
                    case 1:
                        unit2 = knight;
                        selectedUnits[1] = new Knight();
                        break;
                    case 2:
                        unit2 = archer;
                        selectedUnits[1] = new Archer();
                        break;
                    case 3:
                        unit2 = mage;
                        selectedUnits[1] = new Mage();
                        break;
                    case 4:
                        unit2 = healer;
                        selectedUnits[1] = new Healer();
                        break;                        
                }
                //add to unit 2 image
                unitNum += 1;
                break;
            case 3:
                switch (unitChoice){
                    case 1:
                        unit3 = knight;
                        selectedUnits[2] = new Knight();
                        break;
                    case 2:
                        unit3 = archer;
                        selectedUnits[2] = new Archer();
                        break;
                    case 3:
                        unit3 = mage;
                        selectedUnits[2] = new Mage();
                        break;
                    case 4:
                        unit3 = healer;
                        selectedUnits[2] = new Healer();
                        break;                        
                }
                //add to unit 3 image
                unitNum += 1;
                break;
            case 4:
                switch (unitChoice){
                    case 1:
                        unit4 = knight;
                        selectedUnits[3] = new Knight();
                        break;
                    case 2:
                        unit4 = archer;
                        selectedUnits[3] = new Archer();
                        break;
                    case 3:
                        unit4 = mage;
                        selectedUnits[3] = new Mage();
                        break;
                    case 4:
                        unit4 = healer;
                        selectedUnits[3] = new Healer();
                        break;                        
                }
                //add to unit 4 image                
                unitNum += 1;                
                this.x = 360;
                this.y = 0;
                break;
            case 5:
                completeSelection = true;
                break;
            default:
                
        }
        repaint();
        
    }
    public void removeUnit(){
        switch (unitNum-1){
            case 1: 
                unitNum -= 1;     
                unit1 = unitUnknown;
                break;
            case 2:          
                unitNum -= 1;     
                unit2 = unitUnknown;
                break;
            case 3:          
                unitNum -= 1;      
                unit3 = unitUnknown;
                break;
            case 4:
                unitNum -= 1;
                unit4 = unitUnknown;
                this.x = 40;
                this.y = 120;
                unitChoice = 1;
                break;
        }        
        repaint();
    }
    
    public PlayerUnits[] confirmedUnit(){
//        for (int i = 0; i <= 3; i++){
//            selectedUnits[0].createStats();            
 //           System.out.println("hi");
//        }
        selectedUnits[0].createStats();            
        selectedUnits[1].createStats();            
        selectedUnits[2].createStats();            
        selectedUnits[3].createStats();            

        return selectedUnits;
    }
//    public void focus(){
//        focus = true;
//    }
//    public void unfocus(){
//        focus = false;
//    }
}
