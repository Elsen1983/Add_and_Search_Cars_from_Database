package main.java;


public class Buyer {

    public Buyer(String buyer_fName, String buyer_lName, int buyer_phoneNumber) {
        this.buyer_fName = buyer_fName;
        this.buyer_lName = buyer_lName;
        this.buyer_phoneNumber = buyer_phoneNumber;
    }

    public String getBuyer_fName() {
        return buyer_fName;
    }

    public void setBuyer_fName(String buyer_fName) {
        this.buyer_fName = buyer_fName;
    }

    public String getBuyer_lName() {
        return buyer_lName;
    }

    public void setBuyer_lName(String buyer_lName) {
        this.buyer_lName = buyer_lName;
    }

    public int getBuyer_phoneNumber() {
        return buyer_phoneNumber;
    }

    public void setBuyer_phoneNumber(int buyer_phoneNumber) {
        this.buyer_phoneNumber = buyer_phoneNumber;
    }

    private String buyer_fName, buyer_lName;
    private int buyer_phoneNumber;
}
