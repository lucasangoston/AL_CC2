package fr.al_cc2.web.contractor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractorRequest {
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
    public String service;

    @NotNull
    @NotBlank
    public String bankingInfo;

}
