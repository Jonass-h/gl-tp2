/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.action;

/**
 *
 * @author younes
 */
public interface RobotAction {
    public void moveUp();
    public void moveRight();
    public void moveLeft();
    public void moveDown();
    int[] getNewPosition();
    int getDirection();
    
    // pour les butons nous attendons pas la prochaine seconde
    // oon ecoute un evt de click avant une seconde et on applique le
    // mouvement necessaire
    public void addTimeChangeListener(ActionListener pl) ;
    public void removeTimeChangeListener(ActionListener pl);
    public void updateListener();
}
