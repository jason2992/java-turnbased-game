/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;

/**
 *
 * @author jason
 */
public abstract class EnemyUnits extends basicStats {
    
    
    
    
    public static int chooseTarget(basicStats[] unit, int dead){
        //40 30 20 10 this one is not used
        //45 30 15 10
        //50 35 15
        //70 30
        //100
        int countedDead = 0;
        //if target is tauntuning
        
        for (int i = 0; i < 4; i++){
            if (unit[i].getTaunt() == true){
                System.out.println ("tauntnotunt?");
                return i;
            }
        }
        //for when all player units are alive
        if (dead == 0){
            int test = (int)(Math.random() * 19 + 1);
//            if (9 >= (int)(Math.random() * 19 + 1)){
          //  System.out.println(test);
            if (9 >= test){
                return 0;        
            }
            if (6 >= (int)(Math.random() * 10 + 1) ){
                return 1;
            }
            if (3 >= (int)(Math.random() * 4 + 1) ){
                return 2;
            }
            return 3;            
        }
        
        if (dead == 1){
            
            if (unit[countedDead].getHealth() <= 0){
                countedDead += 1;
            }
            
            if (1 >= (int)(Math.random() * 1 + 1)){ //50%
                return countedDead;
            }
            
            countedDead += 1; // moves to next target if the one above misses
            if (unit[countedDead].getHealth() == 0){
                countedDead += 1;
            }
            
            if (7 >= (int)(Math.random() * 9 + 1) ){ //35% but written 70% for first missed
                return countedDead;
            }
            
            countedDead += 1; // moves to next target
            if (unit[countedDead].getHealth() == 0){
                countedDead += 1;
            }
            
            return countedDead;            // if first 2 not hit, this gets hit
        }

        if (dead == 2){
            
            if (unit[countedDead].getHealth() == 0){
                countedDead += 1;
            }
            
            if (7 >= (int)(Math.random() * 9 + 1)){ // 70% for first unit
                return countedDead;        
            }
            
            countedDead += 1;
            if (unit[countedDead].getHealth() == 0){
                countedDead += 1;
            }
            
            return countedDead;            
        }
        
        if (dead == 3){
            for (int i = 0; i < 4; i++){ //only 1 target, finds the last target and targets him/her
                if (unit[i].getHealth() > 0){
                    return i;
                }
            }
        }
        return 0;

        
    }
}
