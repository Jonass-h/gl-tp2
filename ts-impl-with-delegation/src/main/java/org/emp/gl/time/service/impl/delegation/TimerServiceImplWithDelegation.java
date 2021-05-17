package org.emp.gl.time.service.impl.delegation;


import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author tina
 */
public class TimerServiceImplWithDelegation
        extends TimerTask
        implements TimerService {

    int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;

    /**
     * Constructeur du DummyTimeServiceImpl Ici, nnous avons hérité de la classe
     * TimerTask, et nous nous avons utilisé un objet Timer, qui permet de
     * réaliser des tocs à chaque N millisecondes
     */
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

   // List<TimerChangeListener> listeners = new LinkedList<>();
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
       // listeners.add(pl);
       pcs.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        //listeners.remove(pl);
        pcs.removePropertyChangeListener(pl);
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    private void timeChanged() {
        updateDixiemeDeSeconde();
    }

    private void updateDixiemeDeSeconde() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;

        // informer les listeners !
       /* for (PropertyChangeSupport l : pce) {
            l.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP,
                    oldValue, dixiemeDeSeconde);
        }*/

        //il faut faire des "set" pour  
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP,oldValue,dixiemeDeSeconde);

        if (dixiemeDeSeconde == 0) {
            updateSeconde();
        }
    }
    @Override
    public void updateSeconde() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;

       /* for (PropertyChangeSupport l : pce )
            l.firePropertyChange(TimerChangeListener.SECONDE_PROP,
                    oldValue, secondes);*/

        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP,oldValue,secondes);
        
        if (secondes == 0) {
            updateMinutes();
        }
    }
      @Override
    public void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;

      /*  for (PropertyChangeSupport l : pce)
            l.firePropertyChange(TimerChangeListener.MINUTE_PROP,
                    oldValue, minutes);*/
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP,oldValue,minutes);


        if (minutes == 0) {
            updateHeures();
        }
    }
    @Override
    public void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;

   /*     for (PropertyChangeSupport l : pce)
            l.firePropertyChange(TimerChangeListener.HEURE_PROP,
                    oldValue, heures);*/
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP,oldValue,heures);

    }}