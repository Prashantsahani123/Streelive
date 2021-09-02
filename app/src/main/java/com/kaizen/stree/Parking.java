package com.kaizen.stree;

import java.io.Serializable;

public class Parking implements Serializable {

    String name;
    String distr;
    String cityy;
    String website;
    String facebook;
    String youtube;
    String Businessbrief;

    public String getBusinessbrief() {
        return Businessbrief;
    }

    public void setBusinessbrief(String Businessbrief) {
        this.Businessbrief = Businessbrief;
    }


    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }


    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyN() {
        return companyN;
    }

    public void setCompanyN(String companyN) {
        this.companyN = companyN;
    }

    String companyN;


    public String getDistr() {
        return distr;
    }

    public void setDistr(String distr) {
        this.distr = distr;
    }

    public String getCityy() {
        return cityy;
    }

    public void setCityy(String cityy) {
        this.cityy = cityy;
    }

    public String getClubname() {
        return Clubname;
    }

    public void setClubname(String clubname) {
        Clubname = clubname;
    }

    String Clubname;

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    String Mobile;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public String getClasification() {
        return clasification;
    }

    public void setClasification(String clasification) {
        this.clasification = clasification;
    }

    String clasification ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
