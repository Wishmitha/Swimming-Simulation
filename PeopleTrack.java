package SwimmingSimulation;

import java.util.*;
/**
 * @author W.S Mendis
 * Tracks all the instances of people created in the simulation in separate array lists
 * according to their class
 */
public class PeopleTrack {
    /* Each of the array lists are loaded by the already serialized array list objects
       which contains all the intances prevoiusly created.*/
    
    private  static ArrayList<Swimmer> Male_Swimmer = (SaveLoadData.load("src/SwimmingSimulation/MaleSwimmer.ser"));
    private  static ArrayList<Swimmer> Female_Swimmer = (SaveLoadData.load("src/SwimmingSimulation/FemaleSwimmer.ser"));
    private static ArrayList<Judge> Judge = (SaveLoadData.load("src/SwimmingSimulation/Judge.ser"));
    private  static ArrayList<Spectator> Spectator = new ArrayList<Spectator>(SaveLoadData.load("src/SwimmingSimulation/Spectator.ser"));
    private static ArrayList<Supporting_Staff> SupportStaff = new ArrayList<Supporting_Staff>();
    
    // Following 5 methods adds new instances to the current array lists
    
    public static void addMaleSwimmer(Swimmer P){                            // Adds person to a list
        PeopleTrack.Male_Swimmer.add(P);
        SaveLoadData.save(PeopleTrack.getMaleSwimmer(),"src/SwimmingSimulation/MaleSwimmer.ser");        
    }
    
    public static void addFemaleSwimmer(Swimmer P){                            // Adds person to a list
        PeopleTrack.Female_Swimmer.add(P);
        SaveLoadData.save(PeopleTrack.getFemaleSwimmer(),"src/SwimmingSimulation/FemaleSwimmer.ser");
    }
 
     public static void addJudge(Judge P){                            // Adds person to a list
        PeopleTrack.Judge.add(P);
        SaveLoadData.save(PeopleTrack.getJudge(),"src/SwimmingSimulation/Judge.ser");
    }
     
     public static void addSpectator(Spectator P){                            // Adds person to a list
        PeopleTrack.Spectator.add(P);
        SaveLoadData.save(PeopleTrack.getSpectator(),"src/SwimmingSimulation/Spectator.ser");
    }
     
     public static void addSupportStaff(Supporting_Staff P){
         PeopleTrack.SupportStaff.add(P);
     }

    /* Following 4 methods removes the created instances in given index from each array list
     PS : User can't remove support staff members because it is automatically assigned by
          the SwimminCompetetion Class */
     
    public static void removeMaleSwimmer(int i){
        if(Male_Swimmer.size()>0){
            Male_Swimmer.remove(i);
            SaveLoadData.save(PeopleTrack.getMaleSwimmer(),"src/SwimmingSimulation/MaleSwimmer.ser"); 
        }
    }

    public static void removeFemaleSwimmer(int i){
        if(Female_Swimmer.size()>0){
            Female_Swimmer.remove(i);
            SaveLoadData.save(PeopleTrack.getFemaleSwimmer(),"src/SwimmingSimulation/FemaleSwimmer.ser"); 
        }
    }
    
    public static void removeJudge(int i){
        if(Judge.size()>0){
            Judge.remove(i);
            SaveLoadData.save(PeopleTrack.getJudge(),"src/SwimmingSimulation/Judge.ser");
        }
    }
    
    public static void removeSpectator(int i){
        if(Spectator.size()>0){
            Spectator.remove(i);
            SaveLoadData.save(PeopleTrack.getSpectator(),"src/SwimmingSimulation/Spectator.ser");
        }
    }

    /* Following 5 methods returns each of the array lists */
    public static ArrayList<Swimmer> getMaleSwimmer(){
        return Male_Swimmer;
    }
    
    public static ArrayList<Swimmer> getFemaleSwimmer(){
        return Female_Swimmer;
    }
     
    public static ArrayList<Judge> getJudge(){
        return Judge;
    }
    
    public static ArrayList<Spectator> getSpectator(){
        return Spectator;
    }
    
    public static ArrayList<Supporting_Staff> getSupportStaff(){
        return SupportStaff;
    }
    
    /* Each of the following 4 methods stores the names of the each person in the list
       list in a array which is useful to indicate in combo boxes in GUI */ 
    
    public static String[] getNameMaleSwimmer(){
        String[] name = new String[Male_Swimmer.size()];
        for(int i=0;i<Male_Swimmer.size();i++){
            name[i]=Male_Swimmer.get(i).get_Name();
        }
        return name;
    }
    
    public static String[] getNameFemaleSwimmer(){
        String[] name = new String[Female_Swimmer.size()];
        for(int i=0;i<Female_Swimmer.size();i++){
            name[i]=Female_Swimmer.get(i).get_Name();
        }
        return name;
    }

    public static String[] getNameJudge(){
        String[] name = new String[Judge.size()];
        for(int i=0;i<Judge.size();i++){
            name[i]=Judge.get(i).get_Name();
        }
        return name;
    }
    
    public static String[] getNameSpectator(){
        String[] name = new String[Spectator.size()];
        for(int i=0;i<Spectator.size();i++){
            name[i]=Spectator.get(i).get_Name();
        }
        return name;
    }
    
    
}