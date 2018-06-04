package com.example.somesh.martyrkin;

import android.content.Intent;

public class Martyr {

    private String name;
    private Long mobile;
    private Integer serviceNo;
    private Integer dateofmartyred;
    private String galantoryawards;
    private Long accountnunber;
    private String ifsccode;
    private String bankname;

    public Martyr(String name, Long mobile, Integer serviceNo, Integer dateofmartyred, String galantoryawards, Long accountnunber, String ifsccode, String bankname) {
        this.name = name;
        this.mobile = mobile;
        this.serviceNo = serviceNo;
        this.dateofmartyred = dateofmartyred;
        this.galantoryawards = galantoryawards;
        this.accountnunber = accountnunber;
        this.ifsccode = ifsccode;
        this.bankname = bankname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Integer serviceNo) {
        this.serviceNo = serviceNo;
    }

    public Integer getDateofmartyred() {
        return dateofmartyred;
    }

    public void setDateofmartyred(Integer dateofmartyred) {
        this.dateofmartyred = dateofmartyred;
    }

    public String getGalantoryawards() {
        return galantoryawards;
    }

    public void setGalantoryawards(String galantoryawards) {
        this.galantoryawards = galantoryawards;
    }

    public Long getAccountnunber() {
        return accountnunber;
    }

    public void setAccountnunber(Long accountnunber) {
        this.accountnunber = accountnunber;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}
