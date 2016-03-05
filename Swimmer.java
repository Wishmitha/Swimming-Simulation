package SwimmingSimulation;

import java.util.*;
import javax.swing.*;

/**
 * 
 * @author W.S Mendis
 * 
 * Represents both male and female swimmers in the simulations
 * Abstract class which is a subclass of person and superclass of
 * Female and Male swimmer
 * 
 * 
 */

public abstract class Swimmer extends Person {
    private String gender;
    private String player_ID;
    private String lane;
    private String kit_Colour;
    /* Player rating represents player's skill to each of four events
       This rating list is used in thread class to configure player's movement*/
    private ArrayList<Integer> rating ;
    private TouchPad pad;
    
    // constructor which initiates the conditions
    Swimmer(String name){
        super(name);
        group="Swimmer";
    }
    
    // sets player id
    public void set_palyer_ID(String id){
        player_ID=id;
    }
    
    // sets gender
    public void set_gender(String gen){
        gender=gen;
    }
    
    // sets lane
    public void setLane(String ln){
        lane=ln;
    }
    
    // sets kit colur
    public void set_kit_Colour(String col){
        kit_Colour = col;
    }
    
    // assign touchpad to the swimmer
    public void setPad(){
        pad = new TouchPad();
    }
    
    /* Sets player ratings according to user inputs
       Each index represents each event as follows
       0th index : BackStroke
       1st index : BreastStroke
       2nd index : ButterflyStroke
       3rd index : FreeStyle */
    public void set_rating(int a,int b,int c,int d){
        rating= new ArrayList();
        rating.add(a);
        rating.add(b);
        rating.add(c);
        rating.add(d);
    }
    
    // returns player id
    public String get_player_ID(){
        return player_ID;
    } 
    
    // returns lane name
    public String getLane(){
        return lane;
    }
    
    // returns kit colour
    public String get_kit_Colour(){
        return kit_Colour;
    }
    
    // returns rating list
    public ArrayList get_rating(){
        return rating;
    }
    
    // returns gender
    public String get_gender(){
        return gender;
    }
    
    // returns the touch pad
    public TouchPad getPad(){
        return pad;
    }
    
    // prints all the information of current swimmer
    public void info(){
        System.out.println("Class : "+get_Group());
        System.out.println("Name : "+get_Name());
        System.out.println("Gender : "+get_gender());
        System.out.println("Age : "+get_Age());
        System.out.println("Player ID : "+get_player_ID());
        System.out.println("Ratings : "+get_rating());
        System.out.println();
    }
    
    /*Following abstract methods are overriden differently in sub classes
      male swimmmer and female swimmr*/
    abstract void do_Butterfly();                           
    abstract void do_Back_Stroke();
    abstract void do_Breast_Stroke();
    abstract void do_Free_Style();
}
