package main.java;

public class Seller {

    private String seller_fName;
    private String seller_lName;
    private String seller_address;
    private String seller_email;
    private int seller_phoneNumber;

    public Seller(String seller_fName, String seller_lName, String seller_address, String seller_email, int seller_phoneNumber) {

        this.seller_fName = seller_fName;
        this.seller_lName = seller_lName;
        this.seller_address = seller_address;
        this.seller_email = seller_email;
        this.seller_phoneNumber = seller_phoneNumber;
    }


    public String getSeller_fName() {
        return seller_fName;
    }

    public void setSeller_fName(String seller_fName) {
        this.seller_fName = seller_fName;
    }

    public String getSeller_lName() {
        return seller_lName;
    }

    public void setSeller_lName(String seller_lName) {
        this.seller_lName = seller_lName;
    }

    public String getSeller_address() {
        return seller_address;
    }

    public void setSeller_address(String seller_address) {
        this.seller_address = seller_address;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public int getSeller_phoneNumber() {
        return seller_phoneNumber;
    }

    public void setSeller_phoneNumber(int seller_phoneNumber) {
        this.seller_phoneNumber = seller_phoneNumber;
    }



    public Seller() {
    }
}
