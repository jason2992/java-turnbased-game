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
public class Knight extends PlayerUnits{
    private BufferedImage knight;
    @Override
    public void createStats(){
        try{                
            knight = ImageIO.read(new File("C:\\Users\\jason\\Documents\\NetBeansProjects\\TurnBasedGameImproved\\sprite_0.png")); //this is how to add images
        } catch (IOException ex) {          // handle exception...
        };
        this.setRole("Knight");
        this.setStrength(15);
        this.setDefense(4);
        this.setHealth(120);
        this.setMaxHealth(this.getHealth());
        this.setAccuracy(4);
        this.setAccuracyBuff(0);        
        this.setEvasion(1);
        this.setEvasionBuff(0); 
        this.setImage(knight);
        this.setMana(3);
        this.setMaxMana(getMana());
        this.setSkills(3);
    }
}
