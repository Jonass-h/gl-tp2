/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author oussama
 */
public class HourSelected implements WatchState{
    
    
    public String toString(){
        return "Hour Selected State";
     }

    @Override
    public void increment(Watch watch) {
       
        watch.updateHeures();
        watch.ts.updateHeures();
         System.out.println(watch.getHeures());
    }

    @Override
    public void config(Watch watch) {
         watch.setState(new InitState());
    }

    @Override
    public void mode(Watch watch) {
         watch.setState(new SecondSelected());
    }
    
}
