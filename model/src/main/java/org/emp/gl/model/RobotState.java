/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;

/**
 *
 * @author younes
 */
public abstract class RobotState {
    Robot robot;
    int position[];
    int direction;

    public abstract void moveUp();
    public abstract void moveRight();
    public abstract void moveLeft();
    public abstract void moveDown();
    
    public boolean verify_boundaries(int a,int b){

      return (a>0 && a<9 && b>0 && b<9);        
    }
}
