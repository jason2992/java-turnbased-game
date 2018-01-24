/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jason
 */
public class rockgolem extends EnemyUnits{
    private BufferedImage rockgolem;
    @Override
    public void createStats(){
        try{                
            rockgolem = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\enemy_2.png")); //this is how to add images
        } catch (IOException ex) {          // handle exception...
        };
        this.setRole("Rock Golem");
        this.setStrength(8);
        this.setDefense(1);
        this.setHealth(55);
        this.setMaxHealth(this.getHealth());
        this.setAccuracy(1);
        this.setAccuracyBuff(0);        
        this.setEvasion(1);
        this.setEvasionBuff(0); 
        this.setImage(rockgolem);
        this.setMana(8);
        this.setMaxMana(getMana());
        this.setSkills(3);
    }
    
}
