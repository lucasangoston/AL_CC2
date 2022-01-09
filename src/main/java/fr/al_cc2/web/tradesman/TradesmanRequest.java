package fr.al_cc2.web.tradesman;

import fr.al_cc2.domain.model.Certificates;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TradesmanRequest {
    @NotNull
    @NotBlank
    public String firstname;

    @NotNull
    @NotBlank
    public String lastname;

    @NotNull
    @NotBlank
    public String mail;

    @NotNull
    @NotBlank
    public String password;

    @NotNull
    @NotBlank
    public String qualification;

    @NotNull
    @NotBlank
    public String skills;

    @NotNull
    @NotBlank
    public String geographicalArea;

    @NotNull
    @NotBlank
    public String dailyRate;

    @NotNull
    @NotBlank
    public String bankingInfo;

    @NotNull
    public Certificates certificates;
}
