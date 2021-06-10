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
public class InitState extends RobotState{



    InitState(int dir, int pos[], Robot r) {
        System.out.println("init state");
        robot=r;
        direction=dir;
        position[0]=pos[0];
        position[1]=pos[1];  
    }

    @Override
    public void moveUp() {
        int temp[]=new int [2];
        temp[0]=position[0];
        temp[1]=position[1]+1;
        
        robot.setState(new Up(3,temp,this.robot));
    }
    @Override
    public void moveRight() {
        int temp[]=new int [2];
        temp[0]=position[0]+1;
        temp[1]=position[1];
        
        robot.setState(new Up(0,temp,this.robot));
    }
    @Override
    public void moveLeft() {
        int temp[]=new int [2];
        temp[0]=position[0]-1;
        temp[1]=position[1];
        
        robot.setState(new Up(2,temp,this.robot));
    }

    @Override
    public void moveDown() {
        int temp[]=new int [2];
        temp[0]=position[0];
        temp[1]=position[1]-1;
        
        robot.setState(new Up(1,temp,this.robot));
    }
    
}