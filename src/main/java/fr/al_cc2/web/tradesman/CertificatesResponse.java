package fr.al_cc2.web.tradesman;

public class CertificatesResponse{

    public final String name;
    public final String date;

    public CertificatesResponse(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "CertificatesResponse{" +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
