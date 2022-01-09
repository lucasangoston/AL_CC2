package fr.al_cc2.application.tradesman.update;

import fr.al_cc2.kernel.event.EventListener;

public class UpdateTrandesmanQualificationEventListener implements EventListener<UpdateTrandesmanQualificationEvent> {
    @Override
    public void listenTo(UpdateTrandesmanQualificationEvent event) { System.out.println("Listening UpdateTrandesmanQualificationEvent"); }
}
