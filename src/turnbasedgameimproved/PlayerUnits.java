/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnbasedgameimproved;

import java.util.Scanner;

/**
 *
 * @author jason
 */
public abstract class PlayerUnits extends basicStats {
    
    
    //will be different in a GUI    
    public static int chooseTarget(){   
        Scanner s = new Scanner(System.in);
        int target = s.nextInt();
        return target;
    }
}
