package fr.al_cc2.application.tradesman.create;

import fr.al_cc2.domain.model.Certificates;
import fr.al_cc2.kernel.command.Command;

public final class CreateTradesman implements Command {

    public final String firstName;
    public final String lastName;
    public final String mail;
    public String password;
    public final String qualification;
    public final String skills;
    public final String geographicalArea;
    public final String dailyRate;
    public final String bankingInfo;
    public final Certificates certificates;

    public CreateTradesman(String firstName, String lastName, String mail, String password, String qualification, String skills, String geographicalArea, String dailyRate, String bankingInfo, Certificates certificates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.qualification = qualification;
        this.skills = skills;
        this.geographicalArea = geographicalArea;
        this.dailyRate = dailyRate;
        this.bankingInfo = bankingInfo;
        this.certificates = certificates;
    }
}
