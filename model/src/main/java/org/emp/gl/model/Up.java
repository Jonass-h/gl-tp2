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
public class Up extends  RobotState{


   Up(int dir, int pos[], Robot r) {
        System.out.println("right state");
        robot=r;
        direction=dir;
        position[0]=pos[0];
        position[1]=pos[1];  
    }

    @Override
    public void moveUp() {
        position[1]++;
    }
    @Override
    public void moveRight() {
        int temp[]=new int [2];
        temp[0]=this.position[0]+1;
        temp[1]=this.position[1];
        
        robot.setState(new Up(0,temp,this.robot));
    }
    @Override
    public void moveLeft() {
        int temp[]=new int [2];
        temp[0]=this.position[0]-1;
        temp[1]=this.position[1];
        
        robot.setState(new Up(2,temp,this.robot));
    }

    @Override
    public void moveDown() {
        int temp[]=new int [2];
        temp[0]=this.position[0];
        temp[1]=this.position[1]-1;
        
        robot.setState(new Up(1,temp,this.robot));
    }
    
}
