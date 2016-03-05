package SwimmingSimulation;

import javax.swing.JSlider;
/**
 * @author W.S Mendis
 * Female swimmer is a sub class of swimmer class which represents
 * all the female swimmers of the competition 
 * 
 */
public class Female_Swimmer extends Swimmer {
    // constructor which sets intial conditions
    Female_Swimmer(String name){
        super(name);
        set_kit_Colour("Red");
        set_gender("Female");
    }

/* Each of the following four methods set the movement of the each
   JSlider in SwimmingSimulation by activating threads according to
   each event*/
    
void do_Back_Stroke(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,4);
            tr.start();
            break;
        }
    }
}

void do_Breast_Stroke(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,5);
            tr.start();
            break;
        }
    }
}

void do_Butterfly(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,6);
            tr.start();
            break;
        }
    }
}

void do_Free_Style(){
    Swimming_Simulation.setNames(this);
    for(JSlider x:SwimmingCompetetion.getLanes()){
        if(x.getName().equals(this.getLane())){
            ThreadMovement tr = new ThreadMovement(x,this,7);
            tr.start();
            break;
        }
    }
}

}
