package SwimmingSimulation;
import java.io.*;
import java.util.*;

/**
 * @author W.S Mendis
 * All sub classes swimmer, judge, spectator, support staff inherits
 * from this superclass.
 * This is a abstract class,  therefore user can't create instances 
 * of this.
 * This class implements Serializable in java.io, so each instances
 * created by sub classes of this can be serialized and stored in
 * memory
 */

abstract public class Person implements Serializable {
    private String this_name;
    private int age;
    public String group;
    
    // constructor which intiates the conditions
    Person(String name){
        this_name = name;
    }
    
    // sets age
    public void set_Age(int in){
        age=in;
    }
    
    // returns name
    public String get_Name(){
        return this_name;
    }
    
    // returns age
    public int get_Age(){
        return age;
    }
    
    // returns the group person belongs(swimmer,judge or spectator etc.)
    public String get_Group(){
        return group;
    }
    
    /* abstract method info which is overridden in sub class to display
       all the information about created person */
    
    abstract void info();
}
