package fr.al_cc2.domain.model;

public class Certificates {
    private final String name;
    private final String date;


    public Certificates(String name, String date) {
        this.name = name;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
