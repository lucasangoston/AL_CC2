package fr.al_cc2.web.tradesman;

import java.util.List;

public class TradesmansResponse {
    public final List<TradesmanResponse> tradesmans;

    public TradesmansResponse(List<TradesmanResponse> tradesmans) {
        this.tradesmans = tradesmans;
    }
}
