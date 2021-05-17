/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;
import org.emp.gl.timer.service.TimerService;
/*
 *
 * @author oussama
 */
public class   SecondSelected implements WatchState {
   
   
    public String toString(){
        return "Second Selected State";
     }

    @Override
    public void increment(Watch watch) {
        
      
      watch.updateSeconde();
      watch.ts.updateSeconde();
       System.out.println(watch.getSecondes());
    }

    @Override
    public void config(Watch watch) {
          watch.setState(new InitState());
    }

    @Override
    public void mode(Watch watch) {
        watch.setState(new MinuteSelected());
          
        
    }
}
