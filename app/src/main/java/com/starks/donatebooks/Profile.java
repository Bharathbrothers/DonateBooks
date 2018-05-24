package com.starks.donatebooks;

/**
 * Created by RCP on 5/23/2018.
 */

public class Profile {
    String username;
    String contact;
    String qualify;

    public Profile() {

    }

    public Profile(String username, String contact, String qualify) {
        this.username = username;
        this.contact = contact;
        this.qualify = qualify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }
}
