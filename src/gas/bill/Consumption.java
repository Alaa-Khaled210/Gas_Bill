/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas.bill;

/**
 *
 * @author AlAA KHALED
 */
import java.util.Scanner;

public class Consumption {
    
   Scanner s = new Scanner(System.in);
   private float scan = s.nextFloat();
   private float consum ;

    public Consumption() {
    }

    public float getScan() {
        return scan;
    }

    public void setScan(float scan) {
        this.scan = scan;
    }

    public float getConsum() {
        return consum;
    }

    public void setConsum(float consum) {
        this.consum = consum;
    }
}
  

   
   
    



 

   
    
    

