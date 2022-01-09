package fr.al_cc2.application.tradesman.retrieve.qualification;

import fr.al_cc2.kernel.query.Query;

public class RetrieveTradesmansByQualification implements Query {
    public final String qualification;

    public RetrieveTradesmansByQualification(String qualification) { this.qualification = qualification; }
}
