package SwimmingSimulation;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author W.S Menids
 * 
 * A Subclass of the Thread super class
 * Configure all the movements of the swimmer
 * Each swimmer creates their own thread in their BackStroke,BreastStroke..
 * methods by making a instance of this class
 * But each of the threads differ from one player to another because
 * this thread generates random values according to the rating of the 
 * player
 * So multiple threads are not required for each swimmer in this simulation
 */
public class ThreadMovement extends Thread {
    private static ArrayList<Swimmer> result = new ArrayList<Swimmer>();
    private static ArrayList<Float> finalTimes = new ArrayList<Float>();
    private JSlider lane; 
    private Swimmer swimmer;
    private int event;
    
    // constructor which initiates the condition
    public ThreadMovement(JSlider ln, Swimmer sw, int ev){
        lane=ln;
        swimmer=sw;  
        event=ev;
    }
    
    /*Arraylist result stores the swimmers in the finishing order
      This method returns that list */
    public static ArrayList<Swimmer> getResult(){
        return result;
    }
    
    /*ArrayList finalTimes stores the time taken by the each swimmer
      according to the finishing order*/
    public static ArrayList<Float> getFinalTimes(){
        return finalTimes;
    }
    
    /*Clears result,finalTimes lists
      This is required when user starts another event immediately*/
    public static void clear(){
        result=new ArrayList<Swimmer>();
        finalTimes=new ArrayList<Float>();
        SwimmingCompetetion.players= new ArrayList<Swimmer>();
    }
   
    /*Configure all the movement of the swimmer*/
    @Override
    public synchronized void run(){
        if(IntroJFrame.condition()){
            int x;
            int tot=0;
            Random rnd = new Random();
            for(int i=0;i<1000;i++){
                SwimmingCompetetion.updateSpec(); // update spectator status
                Swimming_Simulation.control(i); // update judge status
                ScoreBoard.notifySpectator(i); // notifies spectator about changes
                if(event<4){
                    // a random value generated according player rating
                    x=rnd.nextInt((int)swimmer.get_rating().get(event));
                }else{
                    x=rnd.nextInt((int)swimmer.get_rating().get(event-4));
                }
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadMovement.class.getName()).log(Level.SEVERE, null, ex);
                }
                tot=tot+x;  

                if(tot<=1000){
                    // set values of the JSliders
                    Swimming_Simulation.setvalue(lane, tot);
                }else{
                    Swimming_Simulation.control(tot); // update judges
                    ScoreBoard.notifySpectator(tot); // update spectators
                    swimmer.getPad().setTime(System.currentTimeMillis());
                    ScoreBoard.getTime(swimmer.getPad()); // get finishing time
                    result.add(swimmer);// add swimmer according to finishing order
                    // print reults
                    System.out.printf(swimmer.get_Name()+" "+"%.2f",ScoreBoard.printTime());
                    System.out.println();
                    finalTimes.add(ScoreBoard.printTime()); // add times to finalTImes list
                    if(result.size()==1){
                        try {
                            // writes reult of the event in Result.txt
                            SwimmingEvent ev =new SwimmingEvent(result.get(0),finalTimes.get(0));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ThreadMovement.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(ThreadMovement.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Swimming_Simulation.printResults(result, finalTimes); // displays results
                    Swimming_Simulation.changeCol(result);
                    break;
                }
            }
        }
    }
    
}
