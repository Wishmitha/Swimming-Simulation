/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwimmingSimulation;

import java.util.ArrayList;
import java.io.*;
import java.time.LocalDateTime;

/**
 * @author W.S Menids
 * 
 * Stores result of the each event in memory by writing the reults
 * into Result.txt file
 */
public class SwimmingEvent{
    private String name;
    private Swimmer winner;
    private Float time;
    PrintWriter writer;
    
    /* Constructor automatically calls writeResult() method, so
       results will be recorded whenever a instance is created.*/
    SwimmingEvent(Swimmer sw,float t) throws FileNotFoundException, UnsupportedEncodingException{
        this.writer = new PrintWriter(new FileOutputStream("src/SwimmingSimulation/Results.txt", true));
        winner =sw;
        time=t;
        writeResults();
    }
    
    // returns event name(Men's BackStroke, Women's FreeStyle etc...) 
    public String getName(){
        return name;
    }
    
    /* sorts out the name of the event by analyzing information of the
       SwimmingCompetetion(Controller) class */
    public String getEvent(){
        if(SwimmingCompetetion.event==0){
            name="Men's Back Stroke";
            return name;
        }else if(SwimmingCompetetion.event==1){
            name="Men's Breast Stroke";
            return name;
        }else if(SwimmingCompetetion.event==2){
            name="Men's ButterFly Stroke";
            return name;
        }else if(SwimmingCompetetion.event==3){
            name="Men's Free Style";
            return name;
        }else if(SwimmingCompetetion.event==4){
            name="Women's Back Stroke";
            return name;
        }else if(SwimmingCompetetion.event==5){
            name="Women's Breast Stroke";
            return name;
        }else if(SwimmingCompetetion.event==6){
            name="Women's ButterFly Stroke";
            return name;
        }else{
            name="Women's Free Style";
            return name;
        }
    }
    
    // returns the string which will be written to Result.txt
    public String results(){
        return "| Winner: "+winner.get_Name()+" | Time: "+time+"s";
    }
    
    // writes results to the Result.txt
    public void writeResults(){
        writer.append("Date/Time: "+LocalDateTime.now()+" "+" | Event: "+getEvent()+" "+results()+'\n');
        writer.close();
        
    }

        
}
