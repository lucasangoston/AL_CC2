package fr.al_cc2.web.tradesman;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CertificatesRequest {

    @NotNull
    @NotBlank
    public String name;

    @NotNull
    public String date;
}
