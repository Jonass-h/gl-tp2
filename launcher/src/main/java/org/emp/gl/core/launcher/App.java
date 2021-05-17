package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.heure.Heure;
import org.emp.gl.model.Watch;
import org.emp.gl.reglage.Reglage;
// import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.action.WatchAction;

/**
 * Hello world!
 *
 */
public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
       // Lookup.getInstance().register(TimerService.class, new DummyTimeServiceImpl());
       //Lookup.getInstance().register(TimerService.class, new TimerServiceImplWithDelegation());
       
       Lookup.getInstance().register(TimerService.class, new Watch());
       Lookup.getInstance().register(WatchAction.class, new Watch());

       
    }

    public static void main(String[] args) {
        testDuTimeService();
    }


    private static void testDuTimeService() {

       TimerService ts = Lookup.getInstance().getService(TimerService.class);

        //ts.addTimeChangeListener(new AfficheurHeureSurConsole());
        //ts.addTimeChangeListener(new CompteARebour(5 + (int)(Math.random() * 10)));
        
        Heure hGui = new Heure();
        
        ts.addTimeChangeListener(hGui);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            hGui.setVisible(true);
        }
        });
        
//        
        
        Reglage rGui = new Reglage();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            rGui.setVisible(true);
        }
        });

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
