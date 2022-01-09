package fr.al_cc2.application.tradesman.create;

import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.kernel.ApplicationEvent;

public class CreateTradesmanEvent implements ApplicationEvent {
    private final TradesmanId tradesmanId;

    public CreateTradesmanEvent(TradesmanId tradesmanId) {
        this.tradesmanId = tradesmanId;
    }
}