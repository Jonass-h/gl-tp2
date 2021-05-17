/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import org.emp.gl.action.WatchAction;
import org.emp.gl.core.lookup.Lookup;

import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author oussama
 */

public class Watch extends TimerServiceImplWithDelegation implements WatchAction{
    
    
    
   
    private WatchState state;
    public TimerService ts;
   
    public Watch(){
         super();
        ts = Lookup.getInstance().getService(TimerService.class);
       
        
        state=new InitState();
    }
    public void setState(WatchState state){
        this.state=state;
        
    }
    public WatchState getState(){
        return this.state;
    }
    public void doIncrement(){
        
        this.state.increment(this);
          
    }
    public void doConfig(){
         this.state.config(this);
        
    }
     public void doMode(){
         
        this.state.mode(this);
         
     }
    public Object getValue(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    


    
}
