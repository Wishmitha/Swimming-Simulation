package SwimmingSimulation;
/**
 * @author W.S Mendis
 * 
 * A subclass of Person class which represents all the spectators
 * in the simulation.
 * An Observer class which updates its status according to the changes
 * in the ScoreBoard(Observable)
 * This class doesn't implement the Observer interface in java but coded
 * manually to functionality to be same
 */
public class Spectator extends Person {
    private String ticket_No;
    private String status;
    
    // constructor which initiates the conditions
    Spectator(String name){
        super(name); 
        group = "Spectator";
    }
    
    // sets ticket no
    public void set_ticket_No(String no){
        ticket_No=no;
    }
    
    // returns ticket no
    public String get_ticket_No(){
        return ticket_No;
    }
    
    // update method which exicutes when Observable(ScoreBoard) notifies
    public void update(int i){
        if(i<1000){
            status= "Cheering...Watching...";
        }else{
            status="Results Recieved";
        }
    }
    
    // returns status
    public String getStaus(){
        return status;
    }
    
    // prints all the information of this spectaor
    public void info(){
        System.out.println("Class : "+get_Group());
        System.out.println("Name : "+get_Name());
        System.out.println("Age : "+get_Age());
        System.out.println("Ticket No : "+get_ticket_No());
        System.out.println();
    }
    
    void watch(){
    }  
}
