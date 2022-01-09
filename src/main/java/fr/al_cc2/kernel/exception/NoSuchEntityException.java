package fr.al_cc2.kernel.exception;

import fr.al_cc2.domain.model.ContractorId;
import fr.al_cc2.domain.model.TradesmanId;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withTradesmanId(TradesmanId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withContractorId(ContractorId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }

}
