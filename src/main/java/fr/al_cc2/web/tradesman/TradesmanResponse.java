package fr.al_cc2.web.tradesman;

@SuppressWarnings("all")
public class TradesmanResponse {

    public String id;
    public String firstname;
    public String lastname;
    public String mail;
    public String password;
    public String qualification;
    public String skills;
    public String geographicalArea;
    public String dailyRate;
    public String bankingInfo;
    public CertificatesResponse certificates;

    public TradesmanResponse(String id, String firstname, String lastname, String mail, String password, String qualification, String skills, String geographicalArea, String dailyRate, String bankingInfo, CertificatesResponse certificates) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.qualification = qualification;
        this.skills = skills;
        this.geographicalArea = geographicalArea;
        this.dailyRate = dailyRate;
        this.bankingInfo = bankingInfo;
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "TradesmanResponse{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", qualification='" + qualification + '\'' +
                ", skills='" + skills + '\'' +
                ", geographicalArea='" + geographicalArea + '\'' +
                ", dailyRate='" + dailyRate + '\'' +
                ", bankingInfo='" + bankingInfo + '\'' +
                ", certificates=" + certificates +
                '}';
    }
}
