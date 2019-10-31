package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

public class BusConsole extends ParentObject {

    private Card card;
    private HashMap<Integer, LocalTime> invalidList = new HashMap<>();
    private TappingCard tappingCard;
    private DriverLogIn driverLogIn;
    private DBFacade dbFacade;
    private Driver driver;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();

    public BusConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public BusConsole(){}

    public void enterCardId(int cardId, boolean tamBasılmışMı){

        System.out.println(tamBasılmışMı);
        if(tamBasılmışMı == true) {
            tappingCard = new TappingCard(getId(), 3.25);
        }else {
            if(invalidList.containsKey(cardId) == true &&
                    (localTime.getMinute() - invalidList.get(cardId).getMinute()) < 90 ){
                System.out.println("Gösterilmiş Kart!");
                return;
            }
            tappingCard = new TappingCard(getId());
        }
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null)
            return;
        tappingCard.set(card);
        if(tappingCard.getAmount() > tappingCard.getCurrentBalance())
            return;
        tappingCard.setCardId(card.getId());
        setId(tappingCard.getBusConsoleId());
        dbFacade.update(card);
        dbFacade.put(tappingCard);
        invalidList.put(cardId, localTime);
    }

    public void enterDriverId(){
        driverLogIn = new DriverLogIn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("LogIn olacağınız Otobüsün Id'sini giriniz: ");
        int busConsoleId = scanner.nextInt();
        driverLogIn.setBusConsoleId(busConsoleId);
        setId(busConsoleId);
        System.out.println("LogIn olmak için ID giriniz: ");
        int driverId = scanner.nextInt();
        driver = (Driver) dbFacade.get(driverId, Driver.class);
        driverLogIn.setLogin(driver);
        dbFacade.put(driverLogIn);
    }

   /* public void getAndEquals(){
        BusConsole busConsoleWithDB = BusConsole.this;
        BusConsole busConsoleWithoutDB = dbFacade.get();

    }*/

    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public void setTappingCard(TappingCard tappingCard) {
        this.tappingCard = tappingCard;
    }
    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }
    public Card getCard() {
        return card;
    }
    public TappingCard getTappingCard() {
        return tappingCard;
    }
    public DBFacade getDbFacade() {
        return dbFacade;
    }
    public HashMap<Integer, LocalTime> getInvalidList() {
        return invalidList;
    }
    public void setInvalidList(HashMap<Integer, LocalTime> invalidList) {
        this.invalidList = invalidList;
    }
    public DriverLogIn getDriverLogIn() {
        return driverLogIn;
    }
    public void setDriverLogIn(DriverLogIn driverLogIn) {
        this.driverLogIn = driverLogIn;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
