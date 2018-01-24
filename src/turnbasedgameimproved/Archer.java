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
public class Archer extends PlayerUnits{
    private BufferedImage archer;
    @Override
    public void createStats(){
        try{                
            archer = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_1.png")); //this is how to add images
        } catch (IOException ex) {          // handle exception...
        };
        this.setRole("Archer");
        this.setStrength(20);
        this.setDefense(1);
        this.setHealth(70);
        this.setMaxHealth(this.getHealth());
        this.setAccuracy(6);
        this.setAccuracyBuff(0);        
        this.setEvasion(6);
        this.setEvasionBuff(0); 
        this.setImage(archer);
        this.setMana(4);
        this.setMaxMana(getMana());
        this.setSkills(3);
    }
}
