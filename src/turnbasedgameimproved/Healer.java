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
public class Healer extends PlayerUnits{
    private BufferedImage healer;
    @Override
    public void createStats(){
        try{                
            healer = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_3.png")); //this is how to add images
        } catch (IOException ex) {          // handle exception...
        };
        this.setRole("Healer");
        this.setStrength(10);
        this.setDefense(3);
        this.setHealth(80);
        this.setMaxHealth(this.getHealth());
        this.setAccuracy(2);
        this.setAccuracyBuff(0);        
        this.setEvasion(3);
        this.setEvasionBuff(0); 
        this.setImage(healer);
        this.setMana(8);
        this.setMaxMana(getMana());
        this.setSkills(3);
    }
}
