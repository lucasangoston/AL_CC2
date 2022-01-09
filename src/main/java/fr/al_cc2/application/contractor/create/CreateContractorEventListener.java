package fr.al_cc2.application.contractor.create;

import fr.al_cc2.kernel.event.EventListener;

public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    @Override
    public void listenTo(CreateContractorEvent event) { System.out.println("listening CreateContractorEvent."); }
}
