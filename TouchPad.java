/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwimmingSimulation;

import java.io.Serializable;

/**
 *
 * @author W.S Mendis
 * 
 * A TouchPad is assigned to every swimmer
 * ScoreBoard obtains the finishing time of the swimmer via TouchPad
 * 
 */

public class TouchPad implements Serializable {
    private long finishTime;
    private float result;
    
    // sets finish time
    public void setTime(long time){  
        finishTime=time;
    }
    
    // returns finish time
    public long getTime(){  
        return finishTime;
    }
    
}
