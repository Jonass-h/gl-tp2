package org.emp.gl.core.launcher;


import org.emp.gl.action.RobotAction;
import org.emp.gl.core.lookup.Lookup;
//import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.heure.Labyrinthe;
import org.emp.gl.heure.LabyrintheGui;
import org.emp.gl.model.Robot;
import org.emp.gl.reglage.Commande;

/**
 * HAMZA Younes
 *
 */
public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
       // Lookup.getInstance().register(TimerService.class, new DummyTimeServiceImpl());
       //Lookup.getInstance().register(TimerService.class, new TimerServiceImplWithDelegation());
       Robot r=new Robot();
       Lookup.getInstance().register(TimerService.class, r);
       Lookup.getInstance().register(RobotAction.class, r);
    }

    public static void main(String[] args) {
        testDuTimeService();
    }
    private static void testDuTimeService() {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        
        Labyrinthe lt = new Labyrinthe();
        ts.addTimeChangeListener(lt);
        //
         Commande cmd = new Commande();
         
        System.out.println(" ready to command !!  ");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            cmd.setVisible(true);
        }
        });
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
