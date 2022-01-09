package fr.al_cc2.web.contractor;

import java.util.List;

public class ContractorsResponse {
    public final List<ContractorResponse> contractors;

    public ContractorsResponse(List<ContractorResponse> contractors) {
        this.contractors = contractors;
    }
}
