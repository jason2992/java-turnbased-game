/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;

import java.awt.image.BufferedImage;

/**
 *
 * @author jason
 */
public abstract class basicStats {
//    private string :
    private String role;  // shows role
    private boolean taunt = false;
    private int strength; // attack stat
    private int strengthBuff; // adds or remove defense
    private int defense; // defense stat
    private int defenseBuff; // adds or remove defense
    private int maxHealth; // maintains max health
    private int maxMana; //maintains max mana
    private int health; // health amount 
    private int accuracy; // affects evasion
    private int accuracyBuff; // affects evasion
    private int evasion; // chance to avoid attack      out of 20(5% per number)
    private int evasionBuff; // adds or subtracts evasion
    private int mana;    // amount fo times spells can be used
    private int INT;     // magic damage
    private int skills; //number of skills
    private boolean moved;
    private BufferedImage charImage;
    
    public BufferedImage getImage(){
        return charImage;
    }
    public String getRole(){
        return role;
    }
    public boolean getTaunt(){
        return taunt;
    }
    public int getStrength(){
        return strength;
    }    
    public int getStrengthBuff(){
        return strengthBuff;
    }
    public int getDefense(){
        return defense;
    }
    public int getDefenseBuff(){
        return defenseBuff;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxMana(){
        return maxMana;
    }
    public int getMana(){
        return mana;
    }
    public int getAccuracy(){
        return accuracy;
    }
    public int getAccuracyBuff(){
        return accuracyBuff;
    }
    public int getEvasion(){
        return evasion;
    }
    public int getEvasionBuff(){
        return evasionBuff;
    }
    public int getINT(){
        return INT;
    }
    public int getSkills(){
        return skills;
    }
    public boolean movedYet(){
        return moved;
    }
    
    
    
    
    public void setRole(String role){
        this.role = role;
    }
    public void setTaunt(boolean taunt){
        this.taunt = taunt;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }    
    public void setStrengthBuff(int strengthBuff){
        this.strengthBuff = strengthBuff;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public void setDefenseBuff(int defenseBuff){
        this.defenseBuff = defenseBuff;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setMaxMana(int maxMana){
        this.maxMana = maxMana;
    }
    public void setMana(int mana){
        this.mana = mana;
    }
    public void setAccuracy(int accuracy){
        this.accuracy = accuracy;
    }
    public void setAccuracyBuff(int accuracyBuff){
        this.accuracyBuff = accuracyBuff;
    }
    public void setEvasion(int evasion){
        this.evasion = evasion;
    }
    public void setEvasionBuff(int evasionBuff){
        this.evasionBuff = evasionBuff;
    }
    public void setINT(int INT){
        this.INT = INT;
    }
    public void setSkills(int skills){
        this.skills = skills;
    }
    public void setImage(BufferedImage image){
        this.charImage = image;
    }
    public void setMoved (boolean moved){
        this.moved = moved;
    }
    

    public void displayStats(){
        System.out.println ("-----------------------------------------");
        System.out.println ("Role : " + role);
        System.out.println ("HP: " + health + "/" + maxHealth);
        System.out.println ("MP: " + mana + "/" + maxMana);
        System.out.println ("STR: " + strength);
        System.out.println ("INT: " + INT);
        System.out.println ("DEF: " + defense);
        System.out.println ("ACC: " + accuracy);
        System.out.println ("EVA: " + evasion);
        System.out.println ("");
    }
    
    public void hit (int attackerDamage, int attackerAccuracy){
        int prevHealth = this.health;
        int damage = (attackerDamage - this.defense);
        // minimum 1 damage at all times
        if (damage <= 0){
            damage = 1;
        }
        //chance to evade
        int avoid = (int) (Math.random() * 19 + 1);                            
        if (avoid <= this.evasion + this.evasionBuff){
            System.out.println ("The target dodged the attack");
        }
        //failed to evade, got bodied
        else{
            this.health = this.health - damage;
            System.out.println (prevHealth + " ---> " + this.health);
        }
    }
    //magic is busted and cannot be dodged
    public void magicHit(int attackerDamage){
        int prevHealth = this.health;
        this.health = this.health - attackerDamage;
        System.out.println (prevHealth + " ---> " + this.health);
    }    
    
    public abstract void createStats();
    
}
