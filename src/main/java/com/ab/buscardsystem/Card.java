package com.ab.buscardsystem;

public class Card extends ParentObject {

    private String name;
    private String surname;
    private double balance;
    private String tip;
    private Boolean situation = true;

    public Card(int id){
        this.setId(id);
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public String getTip() {
        return tip;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Boolean getSituation() {
        return situation;
    }
    public void setSituation(Boolean situation) {
        this.situation = situation;
    }
}
