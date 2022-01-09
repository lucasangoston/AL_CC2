package fr.al_cc2.domain.model;

import fr.al_cc2.kernel.Entity;

import java.util.Objects;

public final class Tradesman implements Entity<TradesmanId> {
    private final TradesmanId id;
    private final String firstName;
    private final String lastName;
    private final String mail;
    private String password;
    private final String qualification;
    private final String skills;
    private final String geographicalArea;
    private final String dailyRate;
    private final String bankingInfo;
    private final Certificates certificates;

    private Tradesman(TradesmanId id ,String firstName, String lastName, String mail, String password, String qualification, String skills, String geographicalArea, String dailyRate, String bankingInfo, Certificates certificates) {
        this.id = id;
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.mail = Objects.requireNonNull(mail);
        this.password = Objects.requireNonNull(password);
        this.qualification = Objects.requireNonNull(qualification);
        this.skills = Objects.requireNonNull(skills);
        this.geographicalArea = Objects.requireNonNull(geographicalArea);
        this.dailyRate = Objects.requireNonNull(dailyRate);
        this.bankingInfo = Objects.requireNonNull(bankingInfo);
        this.certificates = Objects.requireNonNull(certificates);
    }

    public static Tradesman of(TradesmanId tradesmanId, String firstName, String lastName, String mail, String password, String qualification, String skills, String geographicalArea, String dailyRate, String bankingInfo, Certificates certificates) {
        return new Tradesman(tradesmanId,firstName, lastName, mail, password, qualification, skills, geographicalArea, dailyRate, bankingInfo, certificates);
    }

    public TradesmanId getId() { return id; }

    @Override
    public TradesmanId id() { return id; }

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

    public String getQualification() {
        return qualification;
    }

    public String getSkills() {
        return skills;
    }

    public String getGeographicalArea() { return geographicalArea; }

    public String getDailyRate() {
        return dailyRate;
    }

    public String getBankingInfo() { return bankingInfo; }

    public Certificates getCertificates() {
        return certificates;
    }
}
