package SwimmingSimulation;

import java.util.*;
import java.io.*;
/**
 * @author W.S Mendis
 * This class serialize and deserialize the given array list of person
 * Stores all the instances in the memory, so it is not required create
 * same instance again and again
 */
public class SaveLoadData {
    // Serialize method 
    public static void save(ArrayList ppl, String filename){
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(ppl);
    }catch(IOException ex){
        System.out.println("Error Occurs");
        System.out.println(ex.getMessage());
        }
    }
    
    // Deserialize method
    public static ArrayList load (String filename){
        ArrayList<Person> ppl= new ArrayList<Person>();
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file); 
            ppl=(ArrayList<Person>) in.readObject();
    }catch(IOException | ClassNotFoundException ex){
        System.out.println("Error Occurs");
        System.out.println(ex.getMessage());
        }        
        
        return ppl;
    }
       
}