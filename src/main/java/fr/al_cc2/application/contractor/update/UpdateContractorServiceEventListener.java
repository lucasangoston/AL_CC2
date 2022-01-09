package fr.al_cc2.application.contractor.update;

import fr.al_cc2.kernel.event.EventListener;

public class UpdateContractorServiceEventListener implements EventListener<UpdateContractorServiceEvent> {
    @Override
    public void listenTo(UpdateContractorServiceEvent event) { System.out.println("Listening UpdateContractorServiceEvent"); }
}
