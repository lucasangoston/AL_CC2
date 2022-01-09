package fr.al_cc2.application.contractor.create;

import fr.al_cc2.kernel.command.Command;

public final class CreateContractor implements Command {

    public final String firstName;
    public final String lastName;
    public final String mail;
    public String password;
    public String service;
    public final String bankingInfos;

    public CreateContractor(String firstName, String lastName, String mail,String password, String service, String bankingInfos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.service = service;
        this.bankingInfos = bankingInfos;
    }
}
