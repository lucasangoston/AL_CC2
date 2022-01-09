package fr.al_cc2.web.contractor;

import java.util.ArrayList;

@SuppressWarnings("all")
public class ContractorResponse {

    public String id;
    public String firstname;
    public String lastname;
    public String mail;
    public String password;
    public String bankingInfo;

    public ContractorResponse(String id, String firstname, String lastname, String mail, String password, String bankingInfo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.bankingInfo = bankingInfo;
    }

    @Override
    public String toString() {
        return "ContractorResponse{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", bankingInfo='" + bankingInfo + '\'' +
                '}';
    }
}
