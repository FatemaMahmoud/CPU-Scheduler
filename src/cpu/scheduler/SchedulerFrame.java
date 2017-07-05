
package cpu.scheduler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class SchedulerFrame extends javax.swing.JFrame {

    private int processNum;
    private ArrayList<ArrayList<JTextField>> allProcesses ;
    private ArrayList<JLabel> cs;
    private ArrayList<Color> clrs;
    private ArrayList<Integer> waitingTime;
    private ArrayList<JLabel> nums;
    private int timeQuantum;
    private int count = 0;
    public SchedulerFrame() {
        initComponents();
        scndInitInitComps();  
        
    }
    public void changeState(boolean b){
        jCheckBox1.setVisible(b);
        jCheckBox2.setVisible(b);
        jCheckBox3.setVisible(b);
        jCheckBox4.setVisible(b);
        jCheckBox5.setVisible(b);
        jCheckBox6.setVisible(b);
        jScrollPane1.setVisible(b);
        jLabel8.setVisible(b);
        jLabel2.setVisible(b);
        jButton1.setVisible(b);
        jButton2.setVisible(b);
        jButton3.setVisible(b);
        chartPanel.setVisible(b);
        jLabel1.setVisible(!b);
        jLabel7.setVisible(!b);
        jButton4.setVisible(!b);
        jButton5.setVisible(!b);
        
    }
    public void scndInitInitComps(){
        changeState(false); 
        this.setTitle("CPU Scheduler");
        ImageIcon icon = new ImageIcon("cpu.png");
        ImageIcon icon1 = new ImageIcon("cpu4.JPG");
        this.setIconImage(icon.getImage());
        jLabel7.setIcon(icon1);
        jCheckBox3.setSelected(false);
        jButton3.setEnabled(false);
        processPanel.setLayout(null);
        processPanel.setAutoscrolls(true);
        this.setLayout(null);
        this.setLocation(540, 0);
        processNum = 1;
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setSize(830,990);
        cs = new ArrayList<JLabel>();
        clrs = new ArrayList<Color>();
        waitingTime = new ArrayList<Integer>();
        nums = new ArrayList<JLabel>();
        allProcesses = new ArrayList<ArrayList<JTextField>>(7);
        allProcesses.add(new ArrayList<JTextField>(4));
        allProcesses.get(0).add(p1);
        allProcesses.get(0).add(p1Arr);
        allProcesses.get(0).add(p1Brust);
        allProcesses.get(0).add(pr1);
        for (int i = 1 ; i < allProcesses.size() ; i++){
            for(int j = 0 ; j < 4 ; j++){
                allProcesses.get(i).get(j).setVisible(false);
            }
        }
        cs.add(c0);
        cs.add(c1);
        cs.add(c2);
        cs.add(c3);
        cs.add(c4);
        cs.add(c5);
        cs.add(c6);
        cs.add(c7);
        cs.add(c8);
        cs.add(c9);
        cs.add(c10);
        cs.add(c11);
        cs.add(jLabel32);
        cs.add(jLabel33);
        cs.add(jLabel34);
        cs.add(jLabel35);
        cs.add(jLabel36);
        cs.add(jLabel37);
        cs.add(jLabel38);
        cs.add(jLabel39);
        cs.add(jLabel40);
        cs.add(jLabel41);
        cs.add(jLabel42);
        cs.add(jLabel17);
        cs.add(jLabel20);
        cs.add(jLabel12);
        cs.add(jLabel9);
        cs.add(jLabel19);
        cs.add(jLabel11);
        cs.add(jLabel15);
        cs.add(jLabel14);
        cs.add(jLabel27);
        cs.add(jLabel28);
        cs.add(jLabel29);
        cs.add(jLabel30);
        cs.add(jLabel16);
        
            
        clrs.add(Color.magenta);
        clrs.add(Color.BLUE);
        clrs.add(Color.DARK_GRAY);
        clrs.add(Color.pink);
        clrs.add(Color.RED);
        clrs.add(Color.GREEN);
        clrs.add(Color.LIGHT_GRAY);
        
        nums.add(jLabel44);
        nums.add(jLabel49);
        nums.add(jLabel46);
        nums.add(jLabel47);
        nums.add(jLabel48);
        nums.add(jLabel43);
        nums.add(jLabel50);
        nums.add(jLabel51);
        nums.add(jLabel52);
        nums.add(jLabel53);
        nums.add(jLabel54);
        nums.add(jLabel55);
        nums.add(jLabel45);
        nums.add(jLabel56);
        nums.add(jLabel57);
        nums.add(jLabel58);
        nums.add(jLabel59);
        nums.add(jLabel60);
        nums.add(jLabel61);
        nums.add(jLabel62);
        nums.add(jLabel63);
        nums.add(jLabel64);
        nums.add(jLabel65);
        nums.add(jLabel66);
        nums.add(jLabel67);
        nums.add(jLabel68);
        nums.add(jLabel69);
        nums.add(jLabel70);
        nums.add(jLabel71);
        nums.add(jLabel72);
        nums.add(jLabel73);
        nums.add(jLabel74);
        nums.add(jLabel75);
        nums.add(jLabel76);
        nums.add(jLabel77);
        nums.add(jLabel78);
        nums.add(jLabel79);
        nums.add(jLabel80);
        nums.add(jLabel81);
        
        for (int i = 0 ; i < nums.size() ; i++){
            nums.get(i).setVisible(false);
        }
        
    }
    public void drawGanttChart (){
        int cpu = 0;
        for (int i = 0 ; i < processNum ; i++){
            if (i == 0)
                {
                    cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                }
            else
                {
                    if (Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu)
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());  
                    
                }  
            for (int j = 0 ; j < Integer.parseInt(allProcesses.get(i).get(2).getText()) ; j++){
                if (cpu <= 35){
                    cs.get(cpu).setBackground(clrs.get(i%7));
                    cs.get(cpu).setText(allProcesses.get(i).get(0).getText());
                }
                cpu++;
            }
            waitingTime.add(cpu);
        }
        int size;
        if (cpu > 12 && cpu < 24)
            size = cpu + 2;
        else if (cpu > 35)
            size = 39;
        else if (cpu > 24)
            size = cpu + 3;
        else 
            size = cpu + 1;
        
        for (int i = 0; i < size ; i++){
            nums.get(i).setVisible(true);
        }
    }

    public void FCFS ()
    {
        for (int i = processNum - 1 ; i >= 0 ; i--){ //sorting 
            
            for (int j = 1 ; j <= i ; j++){
                if (Integer.parseInt(allProcesses.get(j-1).get(1).getText()) > Integer.parseInt(allProcesses.get(j).get(1).getText()))
                    Collections.swap(allProcesses, j-1, j);
            }
        }
        drawGanttChart();
        
    }
    
    public void sjf ()
    {
        for (int i = processNum - 1 ; i >= 0 ; i--){ //sorting 
            
            for (int j = 1 ; j <= i ; j++){
                if (Integer.parseInt(allProcesses.get(j-1).get(1).getText()) > Integer.parseInt(allProcesses.get(j).get(1).getText()))
                    Collections.swap(allProcesses, j-1, j);
            }
        }
        int cpu = 0;
        for (int i = 0; i < processNum - 1; ) { 
            if (i == 0){
            for (int j = i + 1; j < processNum; j++) {
                    if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == Integer.parseInt(allProcesses.get(i).get(1).getText())) {
                        if (Integer.parseInt(allProcesses.get(j).get(2).getText()) < Integer.parseInt(allProcesses.get(i).get(2).getText())) {
                            Collections.swap(allProcesses, i, j);
                        }
                    }
                    else 
                        break;
                }
                cpu = updateSort(i, cpu);
                i++;
            }
            else{
                for (int j = i + 1; j < processNum; j++){
                    if (Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu){
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                        if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == cpu && Integer.parseInt(allProcesses.get(j).get(2).getText()) < Integer.parseInt(allProcesses.get(i).get(2).getText()) )
                            Collections.swap(allProcesses, i, j);
                    }
                    else if (Integer.parseInt(allProcesses.get(j).get(1).getText()) <= cpu && Integer.parseInt(allProcesses.get(i).get(1).getText()) <= cpu ) {
                        if (Integer.parseInt(allProcesses.get(j).get(2).getText()) < Integer.parseInt(allProcesses.get(i).get(2).getText())) {
                            Collections.swap(allProcesses, i, j);
                        }
                    }
                }
                cpu = updateSort(i, cpu);
                i++;    
            }
        }
        drawGanttChart();
    }
   
    public int updateSort (int i, int cpu){
        
        if (Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu || i == 0){
            cpu += Integer.parseInt(allProcesses.get(i).get(1).getText()) + Integer.parseInt(allProcesses.get(i).get(2).getText());
        } else {
            cpu += Integer.parseInt(allProcesses.get(i).get(2).getText());
        }
        return cpu;
    }
    
    public void priorityNon (){
        
        for (int i = processNum - 1 ; i >= 0 ; i--){ //sorting 
            
            for (int j = 1 ; j <= i ; j++){
                if (Integer.parseInt(allProcesses.get(j-1).get(1).getText()) > Integer.parseInt(allProcesses.get(j).get(1).getText()))
                    Collections.swap(allProcesses, j-1, j);
            }
        }
        int cpu = 0;
        for (int i = 0; i < processNum - 1; ) { 
            if (i == 0){
            for (int j = i + 1; j < processNum; j++) {
                    if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == Integer.parseInt(allProcesses.get(i).get(1).getText())) {
                        if (Integer.parseInt(allProcesses.get(j).get(3).getText()) < Integer.parseInt(allProcesses.get(i).get(3).getText())) {
                            Collections.swap(allProcesses, i, j);
                        }
                    }
                    else 
                        break;
                }
                cpu = updateSort(i, cpu);
                i++;
            }
            else{
                for (int j = i + 1; j < processNum; j++){
                    if (Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu){
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                        if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == cpu && Integer.parseInt(allProcesses.get(j).get(3).getText()) < Integer.parseInt(allProcesses.get(i).get(3).getText()) )
                            Collections.swap(allProcesses, i, j);
                    }
                    else if (Integer.parseInt(allProcesses.get(j).get(1).getText()) <= cpu && Integer.parseInt(allProcesses.get(i).get(1).getText()) <= cpu ) {
                        if (Integer.parseInt(allProcesses.get(j).get(3).getText()) < Integer.parseInt(allProcesses.get(i).get(3).getText())) {
                            Collections.swap(allProcesses, i, j);
                        }
                    }
                }
                cpu = updateSort(i, cpu);
                i++;    
            }
        }
        drawGanttChart();
    }
    
    public void rr(){
        for (int i = 0 ; i < processNum ; i++){
            waitingTime.add(0);
        }
        int[] cpus = new int[processNum];
        for (int i = processNum - 1 ; i >= 0 ; i--){ //sorting 
            for (int j = 1 ; j <= i ; j++){
                if (Integer.parseInt(allProcesses.get(j-1).get(1).getText()) > Integer.parseInt(allProcesses.get(j).get(1).getText()))
                    Collections.swap(allProcesses, j-1, j);
            }
            cpus[i] = Integer.parseInt(allProcesses.get(i).get(2).getText());
        }
        
        int cpu = 0;
        int j = 0;
        int i = 0 ;
        
        while(true){
            
            if (i == 0){
                cpu = Integer.parseInt(allProcesses.get(j).get(1).getText());
                i++;
            }
            if (!(Integer.parseInt(allProcesses.get(j).get(1).getText()) > cpu)){
                for (int k = 0 ; k < timeQuantum ; k++){
                    if (cpus[j] > 0){
                        if (cpu <= 35){
                            cs.get(cpu).setBackground(clrs.get(j%7));
                            cs.get(cpu).setText(allProcesses.get(j).get(0).getText());
                        }
                        cpu++;
                        cpus[j]-- ;
                        if (cpus[j] == 0)
                            waitingTime.set(j, cpu);
                    }
                }
            }
            else{
                boolean b = false;
                for (int c = 0 ; c < processNum ; c++){  
                    if (Integer.parseInt(allProcesses.get(c).get(1).getText()) <= cpu ){
                        b = true;
                        if (!(cpus[c] == 0)){
                            cpu--;
                            break;
                        }
                    }
              
                }
                if (b)
                    cpu++;
            }
            j = (j + 1) % processNum;
            boolean stop = true;
            for (int n = 0 ; n < cpus.length ; n++){
                if (cpus[n] > 0)
                    stop = false;
            }
            if (stop)
                break;

        }
        int size;
        if (cpu > 12 && cpu < 24)
            size = cpu + 2;
        else if (cpu > 35)
            size = 39;
        else if (cpu > 24)
            size = cpu + 3;
        
        else 
            size = cpu + 1;
        
        for (int k = 0; k < size ; k++){
            nums.get(k).setVisible(true);
        }
    }
    
    public void shortestRemainingTime (){
        int[] cpus = new int[processNum];
        for (int i = processNum - 1 ; i >= 0 ; i--){ //sorting 
            for (int j = 1 ; j <= i ; j++){
                if (Integer.parseInt(allProcesses.get(j-1).get(1).getText()) > Integer.parseInt(allProcesses.get(j).get(1).getText()))
                    Collections.swap(allProcesses, j-1, j);
            }
            cpus[i] = Integer.parseInt(allProcesses.get(i).get(2).getText());
        }
        int cpu = 0;
        int i = 0;
        int swap;
        int n = 0;
        while(true){
            
            if (n == 0){
                n++;
            for (int j = i + 1; j < processNum; j++) {
                    if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == Integer.parseInt(allProcesses.get(i).get(1).getText())) {
                        if (Integer.parseInt(allProcesses.get(j).get(2).getText()) < cpus[i]) {
                            Collections.swap(allProcesses, i, j);
                            Collections.swap(clrs, i%7, j%7);
                            swap = cpus[j];
                            cpus[j] = cpus[i];
                            cpus[i] = swap;
                        }
                    }
                    else 
                        break;
                }
                cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                if (cpu <= 35){
                    cs.get(cpu).setBackground(clrs.get(i%7));
                    cs.get(cpu).setText(allProcesses.get(i).get(0).getText());
                }
                cpu++;
                cpus[i]-- ;
                if (cpus[i] == 0)
                    waitingTime.add(cpu);
            }
            else{
                for (int j = i + 1; j < processNum; j++){
                    if (Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu){
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                    if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == cpu && cpus[j] < cpus[i]){
                        Collections.swap(allProcesses, i, j);
                        Collections.swap(clrs, i%7, j%7);
                        swap = cpus[j];
                        cpus[j] = cpus[i];
                        cpus[i] = swap;
                    }
                }
                    else if (Integer.parseInt(allProcesses.get(j).get(1).getText()) <= cpu && Integer.parseInt(allProcesses.get(i).get(1).getText()) <= cpu ) {
                        if (cpus[j] < cpus[i]) {
                            Collections.swap(allProcesses, i, j);
                            Collections.swap(clrs, i%7, j%7);
                            swap = cpus[j];
                            cpus[j] = cpus[i];
                            cpus[i] = swap;
                        }
                        else if (cpus[j] == cpus[i] && (Integer.parseInt(allProcesses.get(j).get(1).getText()) < Integer.parseInt(allProcesses.get(i).get(1).getText()))){
                            Collections.swap(allProcesses, i, j);
                            Collections.swap(clrs, i%7, j%7);
                            swap = cpus[j];
                            cpus[j] = cpus[i];
                            cpus[i] = swap;
                        }
                    }
                }
                if (cpus[i] > 0){
                    if (i + 1 == processNum && Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu){
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                    }
                    if (cpu <= 35){
                        cs.get(cpu).setBackground(clrs.get(i%7));
                        cs.get(cpu).setText(allProcesses.get(i).get(0).getText());
                    }
                    cpu++;
                    cpus[i]-- ;
                    if (cpus[i] == 0)
                        waitingTime.add(cpu);
                }
                else
                    i = (i + 1)% processNum;
            }
            boolean stop = true;
            for (int k = 0 ; k < cpus.length ; k++){
                if (cpus[k] > 0)
                    stop = false;
            }
            if (stop)
                break;
        }
        int size;
        if (cpu > 12 && cpu < 24)
            size = cpu + 2;
        else if (cpu > 35)
            size = 39;
        else if (cpu > 24)
            size = cpu + 3;
     
        else 
            size = cpu + 1;
        
        for (int k = 0; k < size ; k++){
            nums.get(k).setVisible(true);
        }
        
    }
    
    public void priorityPreemptive(){
        
        int[] cpus = new int[processNum];
        for (int i = processNum - 1 ; i >= 0 ; i--){ //sorting 
            for (int j = 1 ; j <= i ; j++){
                if (Integer.parseInt(allProcesses.get(j-1).get(1).getText()) > Integer.parseInt(allProcesses.get(j).get(1).getText()))
                    Collections.swap(allProcesses, j-1, j);
            }
            cpus[i] = Integer.parseInt(allProcesses.get(i).get(2).getText());
        }
        int cpu = 0;
        int i = 0;
        int swap;
        int n = 0;
        while(true){
            
            if (n == 0){
                n++;
            for (int j = i + 1; j < processNum; j++) {
                    if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == Integer.parseInt(allProcesses.get(i).get(1).getText())) {
                        if (Integer.parseInt(allProcesses.get(j).get(3).getText()) < Integer.parseInt(allProcesses.get(i).get(3).getText())) {
                            Collections.swap(allProcesses, i, j);
                            Collections.swap(clrs, i%7, j%7);
                            swap = cpus[j];
                            cpus[j] = cpus[i];
                            cpus[i] = swap;
                        }
                    }
                    else 
                        break;
                }
                cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                if (cpu <= 35){
                    cs.get(cpu).setBackground(clrs.get(i%7));
                    cs.get(cpu).setText(allProcesses.get(i).get(0).getText());
                }
                cpu++;
                cpus[i]-- ;
                if (cpus[i] == 0)
                    waitingTime.add(cpu);
            }
            else{
                for (int j = i + 1; j < processNum; j++){
                    if (Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu){
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                    if (Integer.parseInt(allProcesses.get(j).get(1).getText()) == cpu && Integer.parseInt(allProcesses.get(j).get(3).getText()) < Integer.parseInt(allProcesses.get(i).get(3).getText())){
                        Collections.swap(allProcesses, i, j);
                        Collections.swap(clrs, i%7, j%7);
                        swap = cpus[j];
                        cpus[j] = cpus[i];
                        cpus[i] = swap;
                    }
                }
                    else if (Integer.parseInt(allProcesses.get(j).get(1).getText()) <= cpu && Integer.parseInt(allProcesses.get(i).get(1).getText()) <= cpu ) {
                        if (Integer.parseInt(allProcesses.get(j).get(3).getText()) < Integer.parseInt(allProcesses.get(i).get(3).getText())) {
                            Collections.swap(allProcesses, i, j);
                            Collections.swap(clrs, i%7, j%7);
                            swap = cpus[j];
                            cpus[j] = cpus[i];
                            cpus[i] = swap;
                        }
                        else if (Integer.parseInt(allProcesses.get(j).get(3).getText()) == Integer.parseInt(allProcesses.get(i).get(3).getText()) && (Integer.parseInt(allProcesses.get(j).get(1).getText()) < Integer.parseInt(allProcesses.get(i).get(1).getText()))){
                            Collections.swap(allProcesses, i, j);
                            Collections.swap(clrs, i%7, j%7);
                            swap = cpus[j];
                            cpus[j] = cpus[i];
                            cpus[i] = swap;
                        }
                    }
                }
                if (cpus[i] > 0){
                     if (i + 1 == processNum && Integer.parseInt(allProcesses.get(i).get(1).getText()) > cpu){
                        cpu = Integer.parseInt(allProcesses.get(i).get(1).getText());
                    }
                    if (cpu <= 35){ 
                        cs.get(cpu).setBackground(clrs.get(i%7));
                        cs.get(cpu).setText(allProcesses.get(i).get(0).getText());
                    }
                    cpu++;
                    cpus[i]-- ; 
                    if (cpus[i] == 0)
                        waitingTime.add(cpu);
                }
                else
                    i = (i + 1)% processNum;
            }
             boolean stop = true;
            for (int k = 0 ; k < cpus.length ; k++){
                if (cpus[k] > 0)
                    stop = false;
            }
            if (stop)
                break;
        }
        
        int size;
        if (cpu > 12 && cpu < 24)
            size = cpu + 2;
         else if (cpu > 35)
            size = 39;
        else if (cpu > 24)
            size = cpu + 3;
       
        else 
            size = cpu + 1;
        
        for (int k = 0; k < size ; k++){
            nums.get(k).setVisible(true);
        }
        
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        chartPanel = new javax.swing.JPanel();
        c9 = new javax.swing.JLabel();
        c10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        c11 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        c7 = new javax.swing.JLabel();
        c8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        c0 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        processPanel = new javax.swing.JPanel();
        p1Brust = new javax.swing.JTextField();
        p1Arr = new javax.swing.JTextField();
        p1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pr1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(821, 1030));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText(" Scheduling Algorithm:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 293, 39));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 153, 255));
        jCheckBox1.setText("First Come First Surved");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 143, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(0, 153, 255));
        jCheckBox2.setText("Shortest Remaining Time First");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 143, -1, -1));

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(0, 153, 255));
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Priority (non-preemptive)");
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 143, -1, -1));

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(0, 153, 255));
        jCheckBox4.setText("Priority (preemptive)");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 111, -1, -1));

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(0, 153, 255));
        jCheckBox5.setText("Shortest Job First");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 111, -1, -1));

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(0, 153, 255));
        jCheckBox6.setText("Round Robin");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 111, -1, -1));

        chartPanel.setBackground(new java.awt.Color(255, 255, 255));
        chartPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gantt Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        chartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c9.setBackground(new java.awt.Color(255, 255, 255));
        c9.setForeground(new java.awt.Color(255, 255, 255));
        c9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c9.setOpaque(true);
        chartPanel.add(c9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 53, 48));

        c10.setBackground(new java.awt.Color(255, 255, 255));
        c10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        c10.setForeground(new java.awt.Color(255, 255, 255));
        c10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c10.setOpaque(true);
        chartPanel.add(c10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 53, 48));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setAlignmentX(0.5F);
        jLabel9.setOpaque(true);
        chartPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 53, 48));

        c11.setBackground(new java.awt.Color(255, 255, 255));
        c11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        c11.setForeground(new java.awt.Color(255, 255, 255));
        c11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c11.setOpaque(true);
        chartPanel.add(c11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 53, 48));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setAlignmentX(0.5F);
        jLabel11.setOpaque(true);
        chartPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 53, 48));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setAlignmentX(0.5F);
        jLabel12.setOpaque(true);
        chartPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 53, 48));

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setForeground(new java.awt.Color(255, 255, 255));
        c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4.setOpaque(true);
        chartPanel.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 53, 48));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setAlignmentX(0.5F);
        jLabel14.setOpaque(true);
        chartPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 53, 48));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setAlignmentX(0.5F);
        jLabel15.setOpaque(true);
        chartPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 53, 48));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setAlignmentX(0.5F);
        jLabel16.setOpaque(true);
        chartPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 53, 48));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setAlignmentX(0.5F);
        jLabel17.setOpaque(true);
        chartPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 53, 48));

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setForeground(new java.awt.Color(255, 255, 255));
        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setOpaque(true);
        chartPanel.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 53, 48));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setAlignmentX(0.5F);
        jLabel19.setOpaque(true);
        chartPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 53, 48));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setAlignmentX(0.5F);
        jLabel20.setOpaque(true);
        chartPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 53, 48));

        c3.setBackground(new java.awt.Color(255, 255, 255));
        c3.setForeground(new java.awt.Color(255, 255, 255));
        c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3.setOpaque(true);
        chartPanel.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 53, 48));

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setForeground(new java.awt.Color(255, 255, 255));
        c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2.setOpaque(true);
        chartPanel.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 53, 48));

        c5.setBackground(new java.awt.Color(255, 255, 255));
        c5.setForeground(new java.awt.Color(255, 255, 255));
        c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5.setOpaque(true);
        chartPanel.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 53, 48));

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setForeground(new java.awt.Color(255, 255, 255));
        c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c6.setOpaque(true);
        chartPanel.add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 53, 48));

        c7.setBackground(new java.awt.Color(255, 255, 255));
        c7.setForeground(new java.awt.Color(255, 255, 255));
        c7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c7.setOpaque(true);
        chartPanel.add(c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 53, 48));

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setForeground(new java.awt.Color(255, 255, 255));
        c8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c8.setOpaque(true);
        chartPanel.add(c8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 53, 48));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setAlignmentX(0.5F);
        jLabel27.setOpaque(true);
        chartPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 53, 48));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setAlignmentX(0.5F);
        jLabel28.setOpaque(true);
        chartPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 53, 48));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setAlignmentX(0.5F);
        jLabel29.setOpaque(true);
        chartPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 53, 48));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setAlignmentX(0.5F);
        jLabel30.setOpaque(true);
        chartPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 53, 48));

        c0.setBackground(new java.awt.Color(255, 255, 255));
        c0.setForeground(new java.awt.Color(255, 255, 255));
        c0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c0.setOpaque(true);
        chartPanel.add(c0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 53, 48));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setAlignmentX(0.5F);
        jLabel32.setOpaque(true);
        chartPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 53, 48));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setAlignmentX(0.5F);
        jLabel33.setOpaque(true);
        chartPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 53, 48));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setAlignmentX(0.5F);
        jLabel34.setOpaque(true);
        chartPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 53, 48));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setAlignmentX(0.5F);
        jLabel35.setOpaque(true);
        chartPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 53, 48));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setAlignmentX(0.5F);
        jLabel36.setOpaque(true);
        chartPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 53, 48));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setAlignmentX(0.5F);
        jLabel37.setOpaque(true);
        chartPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 53, 48));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setAlignmentX(0.5F);
        jLabel38.setOpaque(true);
        chartPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 53, 48));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setAlignmentX(0.5F);
        jLabel39.setOpaque(true);
        chartPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 53, 48));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setAlignmentX(0.5F);
        jLabel40.setOpaque(true);
        chartPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 53, 48));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setAlignmentX(0.5F);
        jLabel41.setOpaque(true);
        chartPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 53, 48));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setAlignmentX(0.5F);
        jLabel42.setOpaque(true);
        chartPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 53, 48));

        jLabel43.setText(" 5");
        chartPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 30, -1));

        jLabel44.setText("0");
        chartPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 30, -1));

        jLabel45.setText("12");
        chartPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 20, -1));

        jLabel46.setText("2");
        chartPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 30, -1));

        jLabel47.setText(" 3");
        chartPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 30, -1));

        jLabel48.setText(" 4");
        chartPanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 30, -1));

        jLabel49.setText(" 1");
        chartPanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 20, -1));

        jLabel50.setText("6");
        chartPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 20, -1));

        jLabel51.setText("7");
        chartPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 20, -1));

        jLabel52.setText("8");
        chartPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 20, -1));

        jLabel53.setText("  9");
        chartPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 20, -1));

        jLabel54.setText("10");
        chartPanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 20, -1));

        jLabel55.setText("11");
        chartPanel.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 20, -1));

        jLabel56.setText("12");
        chartPanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 30, -1));

        jLabel57.setText("13");
        chartPanel.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 20, -1));

        jLabel58.setText("14");
        chartPanel.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 30, -1));

        jLabel59.setText("15");
        chartPanel.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 30, -1));

        jLabel60.setText("16");
        chartPanel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 30, -1));

        jLabel61.setText("17");
        chartPanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 30, -1));

        jLabel62.setText("18");
        chartPanel.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 20, -1));

        jLabel63.setText("19");
        chartPanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 20, -1));

        jLabel64.setText("20");
        chartPanel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 20, -1));

        jLabel65.setText("21");
        chartPanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 20, -1));

        jLabel66.setText("22");
        chartPanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 20, -1));

        jLabel67.setText("23");
        chartPanel.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 20, -1));

        jLabel68.setText("24");
        chartPanel.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 20, -1));

        jLabel69.setText("24");
        chartPanel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 30, -1));

        jLabel70.setText("25");
        chartPanel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 20, -1));

        jLabel71.setText("26");
        chartPanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 30, -1));

        jLabel72.setText("27");
        chartPanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 30, -1));

        jLabel73.setText("28");
        chartPanel.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 30, -1));

        jLabel74.setText("29");
        chartPanel.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 30, -1));

        jLabel75.setText("30");
        chartPanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 20, -1));

        jLabel76.setText("31");
        chartPanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 20, -1));

        jLabel77.setText("32");
        chartPanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 20, -1));

        jLabel78.setText("33");
        chartPanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 20, -1));

        jLabel79.setText("34");
        chartPanel.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 20, -1));

        jLabel80.setText("35");
        chartPanel.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 20, -1));

        jLabel81.setText("36");
        chartPanel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 20, -1));

        getContentPane().add(chartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 660, 270));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Start Execution");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 930, -1, 40));

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add New Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, -1, 38));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Avg Waiting Time");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 930, -1, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Processes Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        processPanel.setBackground(new java.awt.Color(255, 255, 255));
        processPanel.setMinimumSize(new java.awt.Dimension(621, 900));
        processPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1Brust.setName("p1Brust"); // NOI18N
        p1Brust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1BrustActionPerformed(evt);
            }
        });
        processPanel.add(p1Brust, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 78, 41, 37));

        p1Arr.setName("p1Arr"); // NOI18N
        p1Arr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ArrActionPerformed(evt);
            }
        });
        processPanel.add(p1Arr, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 78, 41, 37));

        p1.setName("p1"); // NOI18N
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });
        processPanel.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 78, 41, 37));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Arrival Time");
        processPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 32, -1, 39));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Priority");
        processPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 30, -1, 39));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Process Name");
        processPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 32, -1, 39));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Burst Time");
        processPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 39, -1, -1));

        pr1.setEditable(false);
        pr1.setName("p1Brust"); // NOI18N
        pr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pr1ActionPerformed(evt);
            }
        });
        processPanel.add(pr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 78, 41, 37));

        jScrollPane1.setViewportView(processPanel);
        processPanel.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 660, 370));
        jScrollPane1.getAccessibleContext().setAccessibleParent(this);

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("CPU Scheduler");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 0, 287, 51));

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("CPU Scheduler");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 590, 100));
        jLabel1.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 630, 400));
        jLabel7.getAccessibleContext().setAccessibleParent(this);

        jButton4.setBackground(new java.awt.Color(0, 102, 255));
        jButton4.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Start");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, 170, 60));

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Quit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 730, 170, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        jCheckBox1.setSelected(true);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        for (int i = 0 ; i < processNum ; i++){
            allProcesses.get(i).get(3).setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(true);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        for (int i = 0 ; i < processNum ; i++){
            allProcesses.get(i).get(3).setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(true);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        for (int i = 0 ; i < processNum ; i++){
            allProcesses.get(i).get(3).setEditable(true);
        }

    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(true);
        jCheckBox6.setSelected(false);
        for (int i = 0 ; i < processNum ; i++){
            allProcesses.get(i).get(3).setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(true);
        timeQuantum = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the time quantum: ", "Time Quantum", JOptionPane.INFORMATION_MESSAGE));
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        allProcesses.add(new ArrayList<JTextField>(4));
        if (processNum > 5)
            processPanel.setPreferredSize(new Dimension(processPanel.getSize().width, processPanel.getSize().height + 45));
        for (int i = 0 ; i < 4 ; i++){
            //allProcesses.get(processNum - 1).get(i).setVisible(true);
            allProcesses.get(processNum).add(new JTextField());
            allProcesses.get(processNum).get(i).setBounds(52 + 41*i + 133*i , 78 + 7*processNum + 37*processNum , 41, 37);
            if (i == 3 && (!jCheckBox4.isSelected() && !jCheckBox3.isSelected()))
                allProcesses.get(processNum).get(i).setEditable(false);
            processPanel.add(allProcesses.get(processNum).get(i));
            
        }
        processPanel.setSize(processPanel.getSize().width , processPanel.getSize().height+50);
        //processPanel.repaint();
        processNum++;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(true);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        for (int i = 0 ; i < processNum ; i++){
            allProcesses.get(i).get(3).setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        count++;
        jButton3.setEnabled(true);
        if (count > 1){
            for (int i = 0 ; i < cs.size() ; i++){
                cs.get(i).setBackground(Color.WHITE);
            }
            waitingTime.clear();
        }
        if (jCheckBox1.isSelected())
            FCFS();
        else if (jCheckBox2.isSelected())
            shortestRemainingTime();
        else if (jCheckBox3.isSelected())
            priorityNon();
        else if (jCheckBox4.isSelected())
            priorityPreemptive();
        else if (jCheckBox5.isSelected())
            sjf();
        else if (jCheckBox6.isSelected())
            rr();
        else 
            JOptionPane.showMessageDialog(null, "Please choose an algorithm");
            
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        float sum = 0;
        float avg;
        for (int i = 0 ; i < waitingTime.size() ; i++){
            sum += waitingTime.get(i) - Integer.parseInt(allProcesses.get(i).get(1).getText()) - Integer.parseInt(allProcesses.get(i).get(2).getText());
        }
        avg = sum / waitingTime.size();
        JOptionPane.showMessageDialog(null, "Average waiting time = " + avg);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pr1ActionPerformed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p1ActionPerformed

    private void p1ArrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ArrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p1ArrActionPerformed

    private void p1BrustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1BrustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p1BrustActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here
        changeState(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(SchedulerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedulerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedulerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedulerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchedulerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel c0;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c10;
    private javax.swing.JLabel c11;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JLabel c8;
    private javax.swing.JLabel c9;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField p1;
    private javax.swing.JTextField p1Arr;
    private javax.swing.JTextField p1Brust;
    private javax.swing.JTextField pr1;
    private javax.swing.JPanel processPanel;
    // End of variables declaration//GEN-END:variables
}
