package fr.al_cc2.application.tradesman.create;

import fr.al_cc2.kernel.event.EventListener;

public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    @Override
    public void listenTo(CreateTradesmanEvent event) { System.out.println("listening CreateTrandesmanEvent."); }
}
