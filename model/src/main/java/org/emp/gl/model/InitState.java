/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;
import org.emp.gl.timer.service.TimerService;
/**
 *
 * @author oussama
 */
public class InitState implements WatchState  {
    
     public String toString(){
        return "initstate State";
     }
  
    @Override
    public void increment(Watch watch) {
    
    }

    @Override
    public void config(Watch watch) {
      
        watch.setState(new SecondSelected());
        
    }

    @Override
    public void mode(Watch watch) {
       
    }
    
    
    
}
