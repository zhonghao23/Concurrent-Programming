package FruitFactory;

import java.util.concurrent.Semaphore;

public class MainClass {
    
    public static void main(String[] args) {
       
        Semaphore s1=new Semaphore(1);
        Semaphore s2=new Semaphore(4);
        Semaphore s3=new Semaphore(4);
        Semaphore s4=new Semaphore(1);
        Semaphore s5=new Semaphore(12);
        Semaphore s6=new Semaphore(1);
        Semaphore s7=new Semaphore(1);
        Semaphore s8=new Semaphore(1);
        Semaphore s9=new Semaphore(6);
        Semaphore s10=new Semaphore(12);
        Semaphore s11=new Semaphore(1);
        
        Entry entry=new Entry (s1);
        DentScanner dentscanner=new DentScanner (entry,s1,s2);
        Steriliser steriliser=new Steriliser (s2,s3);
        Filling filling=new Filling (s3,s4);
        FillScanner fillscanner=new FillScanner(s4,s5);
        Sealing sealing=new Sealing(s5,s6);
        SealScanner sealscanner=new SealScanner(s6,s7);
        Label label=new Label(s7,s8);
        LabelScanner labelscanner=new LabelScanner(s8,s9);
        Pack pack=new Pack (s9,s10);
        Loading load=new Loading (s10,s11);
        Forklift forklift=new Forklift (s11,load);
        
        entry.start();
        dentscanner.start();
        steriliser.start();
        filling.start();
        fillscanner.start();
        sealing.start();
        sealscanner.start();
        label.start();
        labelscanner.start();
        pack.start();
        load.start();
        forklift.start();
    }  
}
