package fr.al_cc2.application.tradesman.update;

import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.kernel.ApplicationEvent;

public class UpdateTrandesmanQualificationEvent implements ApplicationEvent {
    private final TradesmanId tradesmanId;

    public UpdateTrandesmanQualificationEvent(TradesmanId tradesmanId) {
        this.tradesmanId = tradesmanId;
    }
}
