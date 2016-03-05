/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwimmingSimulation;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author W.S Mendis
 * 
 * The controller class which connects GUI with the model
 * Obtain information from the the GUI and calls the necessary methods
 * of the model and Obtains information from the model and updates the GUI
 * 
 */
public class SwimmingCompetetion {
    
    private static JSlider[] lanes;
    public static ArrayList<Swimmer> players = new ArrayList<Swimmer>();
    public static int event;
    
    /*Creates intances of swimmers according to user inputs of Swimmer Jframe*/
    public static void createSwimmer(String strName, String strID, int age, int[] rt, boolean maleSelected) {
        if (maleSelected) {
            Swimmer player = new Male_Swimmer(strName);
            player.set_gender("Male");
            player.set_palyer_ID(strID);
            player.set_Age(age);
            player.set_rating(rt[0], rt[1], rt[2], rt[3]);
            if(Arrays.asList(PeopleTrack.getNameMaleSwimmer()).contains(strName)){
                JOptionPane.showMessageDialog(null,"Name already exists.");
            }else{
                PeopleTrack.addMaleSwimmer(player);
                System.out.println(PeopleTrack.getMaleSwimmer());
            }

        } else {
            Swimmer player = new Female_Swimmer(strName);
            player.set_gender("Female");
            player.set_palyer_ID(strID);
            player.set_Age(age);
            player.set_rating(rt[0], rt[1], rt[3], rt[3]);
            if(Arrays.asList(PeopleTrack.getNameFemaleSwimmer()).contains(strName)){
                JOptionPane.showMessageDialog(null,"Name already exists.");
            }else{
                PeopleTrack.addFemaleSwimmer(player);
            }
        }
    }
    
    /*Creates instances of judges according to the user inputs of JudgeJFrame*/
    public static void createJudge(String strName, String strID, int age) {
        Judge judge = new Judge(strName);
        judge.set_ID(strID);
        judge.set_Age(age);
        if(Arrays.asList(PeopleTrack.getNameJudge()).contains(strName)){
            JOptionPane.showMessageDialog(null,"Name already exists.");
        }else{
            PeopleTrack.addJudge(judge);
        }
    }
    
    /*Creates intances of spectator according to the user inputs of Spectator JFrame*/
    public static void createSpectator(String name,String id){
        Spectator sp = new Spectator(name);
        sp.set_ticket_No(id);
        if(Arrays.asList(PeopleTrack.getNameSpectator()).contains(name)){
            JOptionPane.showMessageDialog(null,"Name already exists.");
        }else{
            PeopleTrack.addSpectator(sp);
        }
        
    }
    
    /*Sorts out which event is selected according to the user inputs
      of IntroJFrame*/
    public static int getEvent(JComboBox gen, JComboBox ev) {
        if (gen.getSelectedIndex() == 0) {
            event=0 + ev.getSelectedIndex();
            return 0 + ev.getSelectedIndex();
        } else {
            event=4 + ev.getSelectedIndex();
            return 4 + ev.getSelectedIndex();
            
        }
    }
    
    /*Sorts out which swimmers are seleted according to the user inputs of
      IntroJFrame*/
    public static Swimmer getSwimmer(JComboBox gen, JComboBox sw) {
        if (gen.getSelectedIndex() == 0) {
            return PeopleTrack.getMaleSwimmer().get(sw.getSelectedIndex());
        } else {
            return PeopleTrack.getFemaleSwimmer().get(sw.getSelectedIndex());
        }
    }
    
    /*Initiates the movement of the selected swimmers by calling swimmer's
      backstroke, breaststroke methods in the model*/
    public static void setMovement(JComboBox gen, JComboBox ev, JComboBox sw) {
        
        Swimmer swimmer = getSwimmer(gen, sw);
        players.add(swimmer);

        if(sw.getName().equals("ln1")){
            swimmer.setLane(lanes[0].getName());
            swimmer.setPad();
        }else if(sw.getName().equals("ln2")){
            swimmer.setLane(lanes[1].getName());
            swimmer.setPad();
        }else if(sw.getName().equals("ln3")){
            swimmer.setLane(lanes[2].getName());
            swimmer.setPad();
        }else if(sw.getName().equals("ln4")){
            swimmer.setLane(lanes[3].getName());
            swimmer.setPad();
        }else if(sw.getName().equals("ln5")){
            swimmer.setLane(lanes[4].getName());
            swimmer.setPad();
        }
        
        if (getEvent(gen, ev) == 0 || getEvent(gen, ev) == 4) {
            swimmer.do_Back_Stroke();
        }

        if (getEvent(gen, ev) == 1 || getEvent(gen, ev) == 5) {
            swimmer.do_Breast_Stroke();
        }

        if (getEvent(gen, ev) == 2 || getEvent(gen, ev) == 6) {
            swimmer.do_Butterfly();
        }

        if (getEvent(gen, ev) == 3 || getEvent(gen, ev) == 7) {
            swimmer.do_Free_Style();
        }
    }
    
    /*Combines GUI and the model by assingning JSlider componets to
      each selected swimmers*/
    public static void assignLanes(JSlider ln1,JSlider ln2,JSlider ln3,JSlider ln4,JSlider ln5){
        lanes = new JSlider[5];
        lanes[0]=ln1;
        lanes[1]=ln2;
        lanes[2]=ln3;
        lanes[3]=ln4;
        lanes[4]=ln5;
        
    }
    
    /*Checks whether the same player is assigned twice in the simulation*/
    public static boolean validatePlayer(){
        for(int i=0;i<players.size();i++){
            for(int j=i+1;j<players.size();j++){
                if(players.get(i).equals(players.get(j))){
                    return false;
                }
            }
        }
        return true;   
    }
    
    /*Checks whether the same judge is assigned twice*/
    public static boolean validateJudge(JComboBox jd1,JComboBox jd2){
        return !PeopleTrack.getJudge().get(jd1.getSelectedIndex()).equals(PeopleTrack.getJudge().get(jd2.getSelectedIndex()));
    }
    
    /*returns lanes array*/
    public static JSlider[] getLanes(){
        return lanes;
    }
    
    /*Sorts out which judge is selected according to user inputs*/
    public static Judge getJudges(JComboBox judge){
        return PeopleTrack.getJudge().get(judge.getSelectedIndex());
    }
    
    /*Update GUI of the judge according to inputs given by Model
      This is done by the passing each values of the thread loop into
      this method, acoordingly the GUI will be updated*/
    public static String control(int val){
        if(val<25){
            return Judge.blowsWhistle();
        }else if(val<1000){
            return Judge.inspect();
        }else{
            return Judge.getRestlts();
        }
    }
    
    /*Update GUI according to the spectators created*/
    public static void assignSeats(){
        Swimming_Simulation.setSeats(PeopleTrack.getSpectator());
    }
    
    /*Creates support staff members and assign them to the simulation*/
    public static void assignSupportStaff(){
        Supporting_Staff ss1 = new Supporting_Staff("Jax");
        Supporting_Staff ss2 = new Supporting_Staff("Stryker");
        Supporting_Staff ss3 = new Supporting_Staff("Johnny");
        Swimming_Simulation.setSupportStaff(PeopleTrack.getSupportStaff());
    }
    
    /*Updates spectator GUI when ScoreBoard(Obserable) notifies
      Spectator(Observer) to update*/
    public static void updateSpec(){
        Swimming_Simulation.setSpecStatus(PeopleTrack.getSpectator().get(0).getStaus());
    }
}
