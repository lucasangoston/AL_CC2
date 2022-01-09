package fr.al_cc2.application.tradesman.update;

import fr.al_cc2.kernel.command.Command;

public class UpdateTradesmanQualification implements Command {
    public final int tradesmanId;
    public final String qualification;

    public UpdateTradesmanQualification(int tradesmanId, String qualification) {
        this.tradesmanId = tradesmanId;
        this.qualification = qualification;
    }
}
