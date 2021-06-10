/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;

import org.emp.gl.action.RobotAction;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author younes
 */
public class Robot extends TimerServiceImplWithDelegation implements RobotAction {
    
    private RobotState state;

    public RobotState getState() {
        return state;
    }

    public void setState(RobotState state) {
        this.state = state;
    }
    
    public TimerService ts;
   
    public Robot(){
        super();
        int pos[]= new int[2];
        pos[0]=0;
        pos[1]=8;
        setState(new InitState(0,pos,this));
    }
    
    @Override
    public void moveRight() {
        System.out.println(" right ");
        state.moveRight();
    }

    @Override
    public void moveLeft() {
        System.out.println(" left ");
        state.moveLeft();
    }


    @Override
    public void moveUp() {
        System.out.println(" up ");
        state.moveUp();
    }

    @Override
    public void moveDown() {
       System.out.println(" down ");
       state.moveDown();
    }
    
}
