package SwimmingSimulation;
/**
 * @author W.S Mendis
 * 
 * Represents all the support staff members of the simulation
 * A subclass of Person class
 * User can't create instance of this class because it is restricted
 * assign automatically by SwimmingCompetition class 
 */
public class Supporting_Staff extends Person {
    // constructor which initiates the conditions
    Supporting_Staff(String name){
        super(name);
        group="Support Staff";
        PeopleTrack.addSupportStaff(this);
    }
    
    void maintain(){
    }
    
    // prints all the information about this member
    public void info(){
        System.out.println("Class : "+get_Group());
        System.out.println("Name : "+get_Name());
        System.out.println("Age : "+get_Age());
        System.out.println();
    }
}
