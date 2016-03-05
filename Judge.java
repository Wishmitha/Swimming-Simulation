package SwimmingSimulation;
/**
 * @author W.S Mendis
 * Represents all the judges in the simulation
 * Subclass of Person Class
 */
public class Judge extends Person {
    private String judge_ID;
    
    // constructor which intiate the name
    Judge(String name){
        super(name);
        group="Judge";
    }
    
    // sets judge id
    public void set_ID(String id){
        judge_ID=id;
    }
    
    // returns judge id
    public String get_judge_ID(){
        return judge_ID;
    }
    
    // prints all the information about current judge
    public void info(){
        System.out.println("Class : "+get_Group());
        System.out.println("Name : "+get_Name());
        System.out.println("Age : "+get_Age());
        System.out.println("Judge ID : "+get_judge_ID());
        System.out.println();
    }
    
    /* Following three methods are actions performed by the Judge.
       These are performed during different stages of the simulation
        using a thread*/
    
    public static String blowsWhistle(){
        return "Blows Whistle";
    }
    
    public static String inspect(){
        return "Inspecting...";
    }
    
    public static String getRestlts(){
        return "Reslts Recieved";
    }
}
