package SwimmingSimulation;

import javax.swing.JSlider;
/**
 * @author W.S Mendis
 * Represents all the male swimmers of the simulation
 * Subclass of abstract class Swimmer
 */
public class Male_Swimmer extends Swimmer{
    // constructor which sets initial conditions
    Male_Swimmer(String name){
        super(name);
        set_kit_Colour("Blue");
        set_gender("Male");
    }
    

        

/* Each of the following four methods set the movement of the each
   JSlider in SwimmingSimulation by activating threads according to
   each event*/
    
void do_Back_Stroke(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,0);
            tr.start();
            break;
        }
    }
}

void do_Breast_Stroke(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,1);
            tr.start();
            break;
        }
    }
}

void do_Butterfly(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,2);
            tr.start();
            break;
            
        }
    }
}

void do_Free_Style(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,3);
            tr.start();
            break;
        }
    }
}

}
