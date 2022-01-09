package fr.al_cc2.domain.model;

import fr.al_cc2.kernel.Entity;

import java.util.Objects;

public final class Contractor implements Entity<ContractorId> {
    private final ContractorId id;
    private final String firstName;
    private final String lastName;
    private final String mail;
    private String password;
    private String service;
    private final String bankingInfos;

    private Contractor(ContractorId id, String firstName, String lastName, String mail, String password, String service, String bankingInfos) {
        this.id = Objects.requireNonNull(id);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.mail = Objects.requireNonNull(mail);
        this.password = Objects.requireNonNull(password);
        this.service = Objects.requireNonNull(service);
        this.bankingInfos = Objects.requireNonNull(bankingInfos);
    }

    public static Contractor of(ContractorId contractorId, String firstName, String lastName, String mail, String password, String service, String bankingInfo) {
        return new Contractor(contractorId, firstName, lastName, mail, password, service, bankingInfo);
    }

    public ContractorId getId() { return id; }

    @Override
    public ContractorId id() { return null; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getService() { return service; }

    public String getBankingInfos() {
        return bankingInfos;
    }
}
