package SwimmingSimulation;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author W.S Mendis
 * 
 * Main GUI interface of the simulation
 * All the events take place in this interface
 */
public class Swimming_Simulation extends javax.swing.JFrame {

    /**
     * Creates new form Swimming_Simulation
     */
    
    // assigns each lane to the given swimmer
    public void setLanes(){
        SwimmingCompetetion.assignLanes(lane1, lane2, lane3, lane4, lane5);  
    }
    
    /* set the values of the JSlider. The values are obtained from the
       thread class*/
    public static void setvalue(JSlider ln,int val){
        if(ln.getName().equals("lane1")){
            lane1.setValue(val);     
        }else if(ln.getName().equals("lane2")){
            lane2.setValue(val); 
        }else if(ln.getName().equals("lane3")){
            lane3.setValue(val); 
        }else if(ln.getName().equals("lane4")){
            lane4.setValue(val); 
        }else if(ln.getName().equals("lane5")){
            lane5.setValue(val); 
        }
    }
    
    // Updates the GUI of the swimmer and display their names
    public static void setNames(Swimmer sw){
        if(sw.getLane().equals("lane1")){
            sw1.setText(sw.get_Name());
            if(sw.get_kit_Colour().equals("Red")){
                tp1.setBackground(Color.RED);
            }else{
                tp1.setBackground(Color.BLUE);
            }
        }else if(sw.getLane().equals("lane2")){
            sw2.setText(sw.get_Name());
            if(sw.get_kit_Colour().equals("Red")){
                tp2.setBackground(Color.RED);
            }else{
                tp2.setBackground(Color.BLUE);
            }
        }else if(sw.getLane().equals("lane3")){
            sw3.setText(sw.get_Name());
            if(sw.get_kit_Colour().equals("Red")){
                tp3.setBackground(Color.RED);
            }else{
                tp3.setBackground(Color.BLUE);
            }
        }else if(sw.getLane().equals("lane4")){
            sw4.setText(sw.get_Name());
            if(sw.get_kit_Colour().equals("Red")){
                tp4.setBackground(Color.RED);
            }else{
                tp4.setBackground(Color.BLUE);
            }
        }else if(sw.getLane().equals("lane5")){
            JudgeLabel2.setText(sw.get_Name());
            if(sw.get_kit_Colour().equals("Red")){
                tp5.setBackground(Color.RED);
            }else{
                tp5.setBackground(Color.BLUE);
            }
        }
        
    }
    
    /*displys reults in the score board list of swimmers according
      to finishing order and their finishing time is given as parameters */
    public static void printResults(ArrayList<Swimmer> sw, ArrayList<Float> tm){
        if(sw.size()>=1){
            res1.setVisible(true);
            pl1.setVisible(true);
            tm1.setVisible(true);
            pl1.setText(sw.get(0).get_Name());
            tm1.setText(Float.toString(tm.get(0)));
        }

        if(sw.size()>=2){
            res2.setVisible(true);
            pl2.setVisible(true);
            tm2.setVisible(true);
            pl2.setText(sw.get(1).get_Name());
            tm2.setText(Float.toString(tm.get(1)));
        }
        
        if(sw.size()>=3){
            res3.setVisible(true);
            pl3.setVisible(true);
            tm3.setVisible(true);
            pl3.setText(sw.get(2).get_Name());
            tm3.setText(Float.toString(tm.get(2)));
        }
        
        if(sw.size()>=4){
            res4.setVisible(true);
            pl4.setVisible(true);
            tm4.setVisible(true);
            pl4.setText(sw.get(3).get_Name());
            tm4.setText(Float.toString(tm.get(3)));
        }
        
        if(sw.size()==5){
            res5.setVisible(true);
            pl5.setVisible(true);
            tm5.setVisible(true);
            pl5.setText(sw.get(4).get_Name());
            tm5.setText(Float.toString(tm.get(4)));
        }
        
    }
    
    // hides unwanted labels of the GUI initially
    public void hideLabel(){
        res1.setVisible(false);
        res2.setVisible(false);
        res3.setVisible(false);
        res4.setVisible(false);
        res5.setVisible(false);
        
        pl1.setVisible(false);
        pl2.setVisible(false);
        pl3.setVisible(false);
        pl4.setVisible(false);
        pl5.setVisible(false);
        
        tm1.setVisible(false);
        tm2.setVisible(false);
        tm3.setVisible(false);
        tm4.setVisible(false);
        tm5.setVisible(false);
    }
    
    // Updates the GUI of the touch pad when swimmer finishes the event
    public static void changeCol(ArrayList<Swimmer> sw){
        for(Swimmer x : sw){
            if(x.getLane().equals("lane1")){
                tp1.setBackground(Color.GREEN);
            }else if(x.getLane().equals("lane2")){
                tp2.setBackground(Color.GREEN);
            }else if(x.getLane().equals("lane3")){
                tp3.setBackground(Color.GREEN);
            }else if(x.getLane().equals("lane4")){
                tp4.setBackground(Color.GREEN);
            }else{
                tp5.setBackground(Color.GREEN);
            }
        }
    }
    
    // Initiates GUI of the judges
    public static void initJudge(String name1,String name2){
        JudgeLabel1.setText(name1);
        JudgeLabel2.setText(name2);
        jd1.setBackground(Color.ORANGE);
        jd2.setBackground(Color.ORANGE);
    }
    
    /* Updates the status of the judge by calling control method in
       SwimminCompetition(Controller) */
    public static void control(int val){
       JudgeStatus1.setText(SwimmingCompetetion.control(val));
       JudgeStatus2.setText(SwimmingCompetetion.control(val));
    }
    
    /* Update spectator GUI by assigning seats to each Spectator
    PS : Only maximum of six spectators are allowed in this simulation */
    public static void setSeats(ArrayList<Spectator> sp){
        if(sp.size()==1){
            sp1.setBackground(Color.YELLOW);
            spec1.setText(sp.get(0).get_Name());
        }else if(sp.size()==2){
            sp1.setBackground(Color.YELLOW);
            sp2.setBackground(Color.YELLOW);
            spec1.setText(sp.get(0).get_Name());
            spec2.setText(sp.get(1).get_Name());
        }else if(sp.size()==3){
            sp1.setBackground(Color.YELLOW);
            sp2.setBackground(Color.YELLOW);
            sp3.setBackground(Color.YELLOW);
            spec1.setText(sp.get(0).get_Name());
            spec2.setText(sp.get(1).get_Name());
            spec3.setText(sp.get(2).get_Name());
        }else if(sp.size()==4){
            sp1.setBackground(Color.YELLOW);
            sp2.setBackground(Color.YELLOW);
            sp3.setBackground(Color.YELLOW);
            sp4.setBackground(Color.YELLOW);
            spec1.setText(sp.get(0).get_Name());
            spec2.setText(sp.get(1).get_Name());
            spec3.setText(sp.get(2).get_Name());
            spec4.setText(sp.get(3).get_Name());
        }else if(sp.size()==5){
            sp1.setBackground(Color.YELLOW);
            sp2.setBackground(Color.YELLOW);
            sp3.setBackground(Color.YELLOW);
            sp4.setBackground(Color.YELLOW);
            sp5.setBackground(Color.YELLOW);
            spec1.setText(sp.get(0).get_Name());
            spec2.setText(sp.get(1).get_Name());
            spec3.setText(sp.get(2).get_Name());
            spec4.setText(sp.get(3).get_Name());
            spec5.setText(sp.get(4).get_Name());
        }else{
            sp1.setBackground(Color.YELLOW);
            sp2.setBackground(Color.YELLOW);
            sp3.setBackground(Color.YELLOW);
            sp4.setBackground(Color.YELLOW);
            sp5.setBackground(Color.YELLOW);
            sp6.setBackground(Color.YELLOW);
            spec1.setText(sp.get(0).get_Name());
            spec2.setText(sp.get(1).get_Name());
            spec3.setText(sp.get(2).get_Name());
            spec4.setText(sp.get(3).get_Name());
            spec5.setText(sp.get(4).get_Name());
            spec6.setText(sp.get(5).get_Name());
        }
        
    }
    
    // initiates the GUI components related to support staff
    public static void setSupportStaff(ArrayList<Supporting_Staff> ss){
        if(ss.size()==1){
            ss1.setBackground(Color.DARK_GRAY);
        }else if(ss.size()==2){
            ss1.setBackground(Color.DARK_GRAY);
            ss2.setBackground(Color.DARK_GRAY);
        }else{
            ss1.setBackground(Color.DARK_GRAY);
            ss2.setBackground(Color.DARK_GRAY);
            ss3.setBackground(Color.DARK_GRAY);
        }
    }
    
    //sets the spectator status
    public static void setSpecStatus(String st){
        status.setText(st);
    }
    
    public Swimming_Simulation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JudgeLabel2 = new javax.swing.JLabel();
        sw1 = new javax.swing.JLabel();
        sw2 = new javax.swing.JLabel();
        lane5 = new javax.swing.JSlider();
        lane1 = new javax.swing.JSlider();
        lane2 = new javax.swing.JSlider();
        lane3 = new javax.swing.JSlider();
        lane4 = new javax.swing.JSlider();
        sw3 = new javax.swing.JLabel();
        sw4 = new javax.swing.JLabel();
        sp4 = new javax.swing.JProgressBar();
        sp1 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        sp3 = new javax.swing.JProgressBar();
        sp2 = new javax.swing.JProgressBar();
        jProgressBar6 = new javax.swing.JProgressBar();
        jProgressBar7 = new javax.swing.JProgressBar();
        jProgressBar9 = new javax.swing.JProgressBar();
        sp5 = new javax.swing.JProgressBar();
        jProgressBar11 = new javax.swing.JProgressBar();
        sp6 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jd2 = new javax.swing.JProgressBar();
        jButton4 = new javax.swing.JButton();
        tp1 = new javax.swing.JProgressBar();
        ss4 = new javax.swing.JProgressBar();
        ss3 = new javax.swing.JProgressBar();
        ss2 = new javax.swing.JProgressBar();
        jProgressBar18 = new javax.swing.JProgressBar();
        tp5 = new javax.swing.JProgressBar();
        tp4 = new javax.swing.JProgressBar();
        tp3 = new javax.swing.JProgressBar();
        tp2 = new javax.swing.JProgressBar();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        res3 = new javax.swing.JLabel();
        res1 = new javax.swing.JLabel();
        res2 = new javax.swing.JLabel();
        res4 = new javax.swing.JLabel();
        res5 = new javax.swing.JLabel();
        pl1 = new javax.swing.JLabel();
        pl2 = new javax.swing.JLabel();
        pl3 = new javax.swing.JLabel();
        pl5 = new javax.swing.JLabel();
        pl4 = new javax.swing.JLabel();
        tm1 = new javax.swing.JLabel();
        tm2 = new javax.swing.JLabel();
        tm3 = new javax.swing.JLabel();
        tm4 = new javax.swing.JLabel();
        tm5 = new javax.swing.JLabel();
        ss1 = new javax.swing.JProgressBar();
        jd1 = new javax.swing.JProgressBar();
        sw6 = new javax.swing.JLabel();
        JudgeStatus2 = new javax.swing.JLabel();
        JudgeLabel1 = new javax.swing.JLabel();
        JudgeStatus1 = new javax.swing.JLabel();
        spec6 = new javax.swing.JLabel();
        spec1 = new javax.swing.JLabel();
        spec2 = new javax.swing.JLabel();
        spec3 = new javax.swing.JLabel();
        spec4 = new javax.swing.JLabel();
        spec5 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simulation");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Swimming Competetion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1010, -1));

        JudgeLabel2.setText("Judge 2");
        getContentPane().add(JudgeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        sw1.setText("Lane 1");
        getContentPane().add(sw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        sw2.setText("Lane 2");
        getContentPane().add(sw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lane5.setMaximum(1000);
        lane5.setValue(0);
        lane5.setName("lane5"); // NOI18N
        getContentPane().add(lane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 590, -1));

        lane1.setMaximum(1000);
        lane1.setValue(0);
        lane1.setName("lane1"); // NOI18N
        getContentPane().add(lane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 590, -1));

        lane2.setMaximum(1000);
        lane2.setValue(0);
        lane2.setName("lane2"); // NOI18N
        getContentPane().add(lane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 590, -1));

        lane3.setMaximum(1000);
        lane3.setValue(0);
        lane3.setName("lane3"); // NOI18N
        getContentPane().add(lane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 590, -1));

        lane4.setMaximum(1000);
        lane4.setValue(0);
        lane4.setName("lane4"); // NOI18N
        getContentPane().add(lane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 590, -1));

        sw3.setText("Lane 3");
        getContentPane().add(sw3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        sw4.setText("Lane 4");
        getContentPane().add(sw4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        getContentPane().add(sp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 20, 20));
        getContentPane().add(sp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 20, 20));
        getContentPane().add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 20, 20));
        getContentPane().add(sp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 20, 20));
        getContentPane().add(sp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 20, 20));
        getContentPane().add(jProgressBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 20, 20));
        getContentPane().add(jProgressBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 20, 20));
        getContentPane().add(jProgressBar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 20, 20));
        getContentPane().add(sp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 20, 20));
        getContentPane().add(jProgressBar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 20, 20));
        getContentPane().add(sp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 20, 20));
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 10, 180));
        getContentPane().add(jd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 20, 20));

        jButton4.setText("Finish");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));
        getContentPane().add(tp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 20, 20));
        getContentPane().add(ss4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 20, 20));
        getContentPane().add(ss3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 20, 20));
        getContentPane().add(ss2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 20, 20));
        getContentPane().add(jProgressBar18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 20, 20));
        getContentPane().add(tp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 20, 20));
        getContentPane().add(tp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 20, 20));
        getContentPane().add(tp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 20, 20));
        getContentPane().add(tp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 20, 20));

        jInternalFrame2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Score Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 24))); // NOI18N
        jInternalFrame2.setVisible(true);

        res3.setText("3rd  place : ");

        res1.setText("1st place : ");

        res2.setText("2nd  place : ");

        res4.setText("4th  place : ");

        res5.setText("5th  place : ");

        pl1.setText("jLabel7");

        pl2.setText("jLabel7");

        pl3.setText("jLabel7");

        pl5.setText("jLabel7");

        pl4.setText("jLabel7");

        tm1.setText("jLabel2");

        tm2.setText("jLabel2");

        tm3.setText("jLabel2");

        tm4.setText("jLabel2");

        tm5.setText("jLabel2");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(res5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pl5))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(res4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pl4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(res3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pl3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(res1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pl1))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(res2)
                        .addGap(18, 18, 18)
                        .addComponent(pl2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tm1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tm2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tm3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tm4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tm5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res1)
                    .addComponent(pl1)
                    .addComponent(tm1))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res2)
                    .addComponent(pl2)
                    .addComponent(tm2))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res3)
                    .addComponent(pl3)
                    .addComponent(tm3))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res4)
                    .addComponent(pl4)
                    .addComponent(tm4))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res5)
                    .addComponent(pl5)
                    .addComponent(tm5))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 270, 300));
        getContentPane().add(ss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 20, 20));
        getContentPane().add(jd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 20, 20));

        sw6.setText("Lane 5");
        getContentPane().add(sw6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        JudgeStatus2.setText("Status1");
        getContentPane().add(JudgeStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 120, -1));

        JudgeLabel1.setText("Judge 1");
        getContentPane().add(JudgeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        JudgeStatus1.setText("Status1");
        getContentPane().add(JudgeStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 120, -1));
        getContentPane().add(spec6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));
        getContentPane().add(spec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));
        getContentPane().add(spec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));
        getContentPane().add(spec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));
        getContentPane().add(spec4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));
        getContentPane().add(spec5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("jLabel2");
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 100, 190, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Support Staff");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 340, 150, -1));

        setSize(new java.awt.Dimension(1029, 485));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Finish button clears all exisiting temperory data in arraylists
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        ThreadMovement.clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Swimming_Simulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swimming_Simulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swimming_Simulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swimming_Simulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Swimming_Simulation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel JudgeLabel1;
    public static javax.swing.JLabel JudgeLabel2;
    public static javax.swing.JLabel JudgeStatus1;
    public static javax.swing.JLabel JudgeStatus2;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar11;
    private javax.swing.JProgressBar jProgressBar18;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JProgressBar jProgressBar7;
    private javax.swing.JProgressBar jProgressBar9;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JProgressBar jd1;
    private static javax.swing.JProgressBar jd2;
    public static javax.swing.JSlider lane1;
    public static javax.swing.JSlider lane2;
    public static javax.swing.JSlider lane3;
    public static javax.swing.JSlider lane4;
    public static javax.swing.JSlider lane5;
    private static javax.swing.JLabel pl1;
    private static javax.swing.JLabel pl2;
    private static javax.swing.JLabel pl3;
    private static javax.swing.JLabel pl4;
    private static javax.swing.JLabel pl5;
    private static javax.swing.JLabel res1;
    private static javax.swing.JLabel res2;
    private static javax.swing.JLabel res3;
    private static javax.swing.JLabel res4;
    private static javax.swing.JLabel res5;
    private static javax.swing.JProgressBar sp1;
    private static javax.swing.JProgressBar sp2;
    private static javax.swing.JProgressBar sp3;
    private static javax.swing.JProgressBar sp4;
    private static javax.swing.JProgressBar sp5;
    private static javax.swing.JProgressBar sp6;
    private static javax.swing.JLabel spec1;
    private static javax.swing.JLabel spec2;
    private static javax.swing.JLabel spec3;
    private static javax.swing.JLabel spec4;
    private static javax.swing.JLabel spec5;
    private static javax.swing.JLabel spec6;
    private static javax.swing.JProgressBar ss1;
    private static javax.swing.JProgressBar ss2;
    private static javax.swing.JProgressBar ss3;
    private static javax.swing.JProgressBar ss4;
    private static javax.swing.JLabel status;
    public static javax.swing.JLabel sw1;
    public static javax.swing.JLabel sw2;
    public static javax.swing.JLabel sw3;
    public static javax.swing.JLabel sw4;
    public static javax.swing.JLabel sw6;
    private static javax.swing.JLabel tm1;
    private static javax.swing.JLabel tm2;
    private static javax.swing.JLabel tm3;
    private static javax.swing.JLabel tm4;
    private static javax.swing.JLabel tm5;
    private static javax.swing.JProgressBar tp1;
    private static javax.swing.JProgressBar tp2;
    private static javax.swing.JProgressBar tp3;
    private static javax.swing.JProgressBar tp4;
    private static javax.swing.JProgressBar tp5;
    // End of variables declaration//GEN-END:variables
}
