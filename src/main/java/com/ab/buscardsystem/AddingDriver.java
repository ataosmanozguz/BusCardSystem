package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddingDriver extends ParentObject {

    private LocalTime localTime = LocalTime.now();
    private LocalDate localDate = LocalDate.now();
    private String name;
    private String surname;
    private int driverId;
    private Driver driver;
    private int isCorrect;
    private FactoryInput factoryInput = new FactoryInput();

    public Driver setDriverInfo(Driver driver){
        if(driver == null)
            throw new NullPointerException("Driver is null");
        isCorrect = 1;
        takeName();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeSurname();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeId();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        driver.setId(driverId);
        driver.setName(name);
        driver.setSurname(surname);
        this.driver = driver;
        return driver;
    }

    public void takeName(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter name: ");
            name = factoryInput.inputStringName();
            if (name.length() < 15 && !name.equals("") && !name.startsWith(" ")) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Incorrect name, please try again!");
            }
        }
    }

    public void takeSurname(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter surname: ");
            surname = factoryInput.inputStringSurname();
            if (surname.length() < 15 & !surname.equals("") && !surname.startsWith(" ")) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Incorrect surname, please try again!");
            }
        }
    }

    public void takeId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter Driver ID: ");
            driverId = factoryInput.inputIntegerId();
            if (driverId > 0 && driverId < 10000) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Driver ID is wrong, please try again!");
            }
        }
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
    public LocalDate getLocalDate() {
        return localDate;
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
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public int getIsCorrect() {
        return isCorrect;
    }
    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public FactoryInput getFactoryInput() {
        return factoryInput;
    }
    public void setFactoryInput(FactoryInput factoryInput) {
        this.factoryInput = factoryInput;
    }

}
