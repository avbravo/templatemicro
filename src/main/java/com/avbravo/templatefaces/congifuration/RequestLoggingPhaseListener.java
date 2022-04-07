package com.avbravo.templatefaces.congifuration;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestLoggingPhaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

    @Inject
    Logger LOG;

    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.log(Level.INFO, "after phase:{0}", event.getPhaseId());
        //System.out.println("after phase:{0}"+ event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        LOG.log(Level.INFO, "before phase:{0}", event.getPhaseId());
          //      System.out.println("before phase:{0}"+ event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
