/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwimmingSimulation;

import java.util.ArrayList;

/**
 * @author W.S Mendis
 * An Observable class which contains list of spectators and update them
 * whenever the notify method is called
 * This doesn't implement Observable interface in java, but the code is
 * written manually to act as a Observable.
 * Other than that this class calculates the finishing times to each swimmer
 * by obtaining data from the touch pad and displays it.
 * PS : There are no attach and detach methods in this class because it can be
 *      done using add/remove methods in PeopleTrack class. 
 */
public class ScoreBoard {
    // The list of observers(Spectators)
    private static ArrayList<Spectator> spec = PeopleTrack.getSpectator();
    
    private static long finalTime;
    private static long currentTime;
    
    // gets the current time 
    public static void setTime(long time){
        currentTime=time;
    }
    
    // gets the final time from the touch pad
    public static void getTime(TouchPad tp){
        finalTime=tp.getTime();
    }
    
    // return finishing times to dispaly
    public static float printTime(){
        float f = finalTime-currentTime;
        return f/1000;
    }
    
    // notifies the observers (spectator) to update there status
    public static void notifySpectator(int i){
        for(Spectator sp:spec){
                sp.update(i);
                SwimmingCompetetion.updateSpec();
        }
    }   
}
