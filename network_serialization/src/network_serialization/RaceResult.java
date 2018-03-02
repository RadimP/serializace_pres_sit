/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_serialization;

import java.io.Serializable;

/**
 *
 * @author Director itSTEP
 */
public class RaceResult implements Comparable, Serializable{
    public Car car;
    public Timespan timespan;
    
   public RaceResult(Car car,Timespan timespan) {
       this.car=car;
       this.timespan=timespan;
   
   } 
   @Override
   public int compareTo(Object o){
   
    return timespan.compareTo(
    ((RaceResult) o).timespan
    
    
    );
   }
   
    @Override
    public String toString() {
    return car.getnanufacture() +" " +car.getmodelName() +": " +timespan;
    }
}
