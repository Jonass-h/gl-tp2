/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.model;

/**
 *
 * @author oussama
 */
public interface WatchState {
    public void increment(Watch watch);
    public void config(Watch watch);
    public void mode(Watch watch);
     
    
}
