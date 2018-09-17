

package main.java;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;


public class Controller implements Initializable {

    Connection con = DBConnection.getDBConnection();

    public int getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    public void setSellerPhoneNumber(int sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    //private jdbc = DBConnection.getDBConnection();
    //private Car car = new Car();
    private int sellerPhoneNumber;
    private String makeSelected = "";
    private String searchCarMakeSelected ="";
    private String searCarModelSelected ="";
    private String searCarYearSelected="";

    //TABPANE
    @FXML // fx:id="tabPane"
    private TabPane tabPane; // Value injected by FXMLLoader

    //TABS
    @FXML // fx:id="mainTab"
    private Tab mainTab; // Value injected by FXMLLoader
    @FXML // fx:id="sellerTab"
    private Tab sellerTab; // Value injected by FXMLLoader
    @FXML // fx:id="carTab"
    private Tab carTab; // Value injected by FXMLLoader
    @FXML // fx:id="buyerTab"
    private Tab buyerTab; // Value injected by FXMLLoader
    @FXML // fx:id="resultTab"
    private Tab resultTab; // Value injected by FXMLLoader

    //MAIN TAB - ELEMENTS
    @FXML // fx:id="buyCar"
    private Button buyCar; // Value injected by FXMLLoader
    @FXML // fx:id="sellCar"
    private Button sellCar; // Value injected by FXMLLoader

    //SELLER-TAB ELEMENTS
    @FXML // fx:id="seller_FirstNameTextfield"
    private TextField seller_FirstNameTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_LastNameTextfield"
    private TextField seller_LastNameTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_AddressTextfield"
    private TextField seller_AddressTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_EmailPartOneTextfield"
    private TextField seller_EmailPartOneTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_EmailPartTwoTextfield"
    private TextField seller_EmailPartTwoTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_EmailPartThreeTextfield"
    private TextField seller_EmailPartThreeTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_PhoneNumberTextfield"
    private TextField seller_PhoneNumberTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="seller_MeaasgeLabel"
    private Label seller_MessageLabel; // Value injected by FXMLLoader
    @FXML // fx:id="seller_SaveAndSellButton"
    private Button seller_SaveAndSellButton; // Value injected by FXMLLoader

    //CAR-TAB ELEMENTS
    @FXML // fx:id="car_MakeChoiceBox"
    private ChoiceBox<String> car_MakeChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="car_ModelChoiceBox"
    private ChoiceBox<String> car_ModelChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="car_RegistrationNumberTextField"
    private TextField car_RegistrationNumberTextField; // Value injected by FXMLLoader#
    @FXML // fx:id="car_ReleasedYearChoiceBox"
    private ChoiceBox<String> car_ReleasedYearChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="car_PriceTextField"
    private TextField car_PriceTextField; // Value injected by FXMLLoader
    @FXML
    private Slider car_priceSlider;

    @FXML
    private Label addcar_MessageLabel;
    @FXML // fx:id="car_SellCarButton"
    private Button car_SellCarButton; // Value injected by FXMLLoader

    //BUYER-TAB ELEMENTS
    @FXML // fx:id="buyer_FirstNameTextfield"
    private TextField buyer_FirstNameTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_LastNameTextfield"
    private TextField buyer_LastNameTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_PhoneNumberTextfield"
    private TextField buyer_PhoneNumberTextfield; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_SelectCarButton"
    private Button buyer_SelectCarButton; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_MeaasgeLabel"
    private Label buyer_MessageLabel; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_carPane"
    private Pane buyer_carPane; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_MakeChoiceBox"
    private ChoiceBox<String> buyer_MakeChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_ModelChoiceBox"
    private ChoiceBox<String> buyer_ModelChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_YearChoiceBox"
    private ChoiceBox<String> buyer_YearChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="buyer_StartSearchButton"
    private Button buyer_StartSearchButton; // Value injected by FXMLLoader

    //RESULT-TAB ELEMENTS
    @FXML
    private TableView<Car> market_Tableview;
    @FXML // fx:id="market_MakeTableColumn"
    private TableColumn<Car, String> market_MakeTableColumn; // Value injected by FXMLLoader
    @FXML // fx:id="market_ModelTableColumn"
    private TableColumn<Car, String> market_ModelTableColumn; // Value injected by FXMLLoader
    @FXML // fx:id="market_RegNumberTableColumn"
    private TableColumn<Car, String> market_RegNumberTableColumn; // Value injected by FXMLLoader
    @FXML // fx:id="market_YearTableColumn"
    private TableColumn<Car, Integer> market_YearTableColumn; // Value injected by FXMLLoader
    @FXML // fx:id="market_PriceTableColumn"
    private TableColumn<Car, Integer> market_PriceTableColumn; // Value injected by FXMLLoader
    @FXML // fx:id="market_SellerPhoneNumberTableColumn"
    private TableColumn<Car, Integer> market_SellerPhoneNumberTableColumn; // Value injected by FXMLLoader
    @FXML // fx:id="market_refreshButton"
    private Button market_refreshButton; // Value injected by FXMLLoader

    private ObservableList<Car> oblist = FXCollections.observableArrayList();
    private ObservableList<String> carMakeObList = FXCollections.observableArrayList();
    private ObservableList<String> carModelObList = FXCollections.observableArrayList();
    private ObservableList<String> carYearObList = FXCollections.observableArrayList();
    //for buyer search
    private ObservableList<String> buyerCarSearchMakeObList = FXCollections.observableArrayList();
    private ObservableList<String> buyerCarSearchModelObList = FXCollections.observableArrayList();
    private ObservableList<String> buyerCarSearchYearObList = FXCollections.observableArrayList();


    //EVENTS

    @FXML
    void addSeller(ActionEvent event) {
        sellerTab.setDisable(false);
        tabPane.getSelectionModel().select(1);
        sellCar.setDisable(true);
        buyCar.setDisable(true);
        buyerTab.setDisable(true);
    }
    @FXML
    void addBuyer(ActionEvent event) {
        buyerTab.setDisable(false);
        tabPane.getSelectionModel().select(3);
        sellCar.setDisable(true);
        buyCar.setDisable(true);
        sellerTab.setDisable(true);
    }

    @FXML
    void sellerSaveAndSellCar(ActionEvent event) throws SQLException {
        if(seller_FirstNameTextfield.getText().equals("") || seller_LastNameTextfield.getText().equals("")
                || seller_AddressTextfield.getText().equals("") || seller_EmailPartOneTextfield.getText().equals("")
                || seller_EmailPartTwoTextfield.getText().equals("") || seller_EmailPartThreeTextfield.getText().equals("")
                || seller_PhoneNumberTextfield.getText().equals("")){

            System.out.println("Empty field");
            seller_MessageLabel.setText("Please fill out all fields!");

        }else{
            //check phone number for only digit, because must save that as integer into the database
            if(!numberOrNot(seller_PhoneNumberTextfield.getText())){
                seller_MessageLabel.setText("Phone number must be digits only");
            }else{
                //minimum 10 digit for a phone number
                int phoneNumberLength = seller_PhoneNumberTextfield.getText().length();
                if(phoneNumberLength <= 9 || phoneNumberLength >10){
                    seller_MessageLabel.setText("Phone number must be 10 digits!");
                }else{
                    seller_MessageLabel.setText("");
                    System.out.println(phoneNumberLength);

                    //save the seller all details to database
                    String fName = seller_FirstNameTextfield.getText();
                    String lName = seller_LastNameTextfield.getText();
                    String address = seller_AddressTextfield.getText();
                    String email = seller_EmailPartOneTextfield.getText() +"@"
                            + seller_EmailPartTwoTextfield.getText() + "." + seller_EmailPartThreeTextfield.getText();
                    int phoneNumber = 0;
                    try {
                        phoneNumber = parseInt(seller_PhoneNumberTextfield.getText());
                        setSellerPhoneNumber(phoneNumber);
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Problem with parsing on seller phone number.");
                    }
                    //insert seller into database
                    insertSellerIntoDatabase(fName,lName,address,email,phoneNumber);
                    carTab.setDisable(false);
                    sellerTab.setDisable(true);
                    tabPane.getSelectionModel().select(2);
                }

            }
        }
    }

    @FXML
    void carSellCar(ActionEvent event) throws SQLException {
        boolean makeEmpty = car_MakeChoiceBox.getSelectionModel().isEmpty();
        boolean modelEmpty = car_ModelChoiceBox.getSelectionModel().isEmpty();
        boolean yearEmpty = car_ReleasedYearChoiceBox.getSelectionModel().isEmpty();

        if(makeEmpty || modelEmpty || yearEmpty || car_RegistrationNumberTextField.getText().equals("")
                || car_PriceTextField.getText().equals("") || getSellerPhoneNumber() == 0){

            addcar_MessageLabel.setText("Please fill out all fields!");

        }else {
            addcar_MessageLabel.setText("");
            String make = car_MakeChoiceBox.getValue();
            //System.out.println(make);
            String model = car_ModelChoiceBox.getValue();
            String regNumber = car_RegistrationNumberTextField.getText();
            int releaseYear = Integer.parseInt(car_ReleasedYearChoiceBox.getValue());
            int price = 0;
            try {
                price = Integer.parseInt(car_PriceTextField.getText());
            } catch (Exception e) {
                e.printStackTrace();
                addcar_MessageLabel.setText("The price must be a digit!");
            }
            int sellerPhoneNumber = getSellerPhoneNumber();
            if (price >= 1000) {
                insertCarIntoDatabase(make, model, regNumber, releaseYear, price, sellerPhoneNumber);
                sellCar.setDisable(false);
                buyCar.setDisable(false);
            }else{
                addcar_MessageLabel.setText("The price must be minimum 1000!");
            }
        }
    }

    //for CAR SELL CHOICE_BOXES
    @FXML
    private void carMakeSelect(){

        makeSelected = car_MakeChoiceBox.getValue();
        System.out.println("Selected : "+ makeSelected);
        carModelSelect(makeSelected);
        car_ModelChoiceBox.setDisable(false);


    }

    @FXML
    private void carModelSelect(String makeselect){
            setupCarModel(makeselect);
            carYearSelect(makeselect);
    }

    @FXML
    private void carYearSelect(String makeSelected){
        car_ReleasedYearChoiceBox.setDisable(false);
        setupCarReleasedYear(makeSelected);
    }

    @FXML
    void buyerSelectCar(ActionEvent event) throws SQLException {
        if(buyer_FirstNameTextfield.getText().equals("") || buyer_LastNameTextfield.getText().equals("")
                || buyer_PhoneNumberTextfield.getText().equals("")){

            System.out.println("Empty field");
            buyer_MessageLabel.setText("Please fill out all fields!");

        }else{
            //check phone number for only digit, because must save that as integer into the database
            if(!numberOrNot(buyer_PhoneNumberTextfield.getText())){
                buyer_MessageLabel.setText("Phone number must be digits only");
            }else{
                //minimum 10 digit for a phone number
                int phoneNumberLength = buyer_PhoneNumberTextfield.getText().length();
                if(phoneNumberLength <= 9 || phoneNumberLength >10 ){
                    buyer_MessageLabel.setText("Phone number must be 10 digits!");
                }else{
                    buyer_MessageLabel.setText("");

                    //save the buyer all details to database
                    String fName = buyer_FirstNameTextfield.getText();
                    String lName = buyer_LastNameTextfield.getText();
                    int buyerPhoneNumber = 0;
                    try {
                        buyerPhoneNumber = parseInt(buyer_PhoneNumberTextfield.getText());
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Problem with parsing on buyer phone number.");
                    }
                    insertBuyerIntoDatabase(fName,lName,buyerPhoneNumber);

                    //and change the car selection pane to usable
                    carTab.setDisable(true);
                    sellerTab.setDisable(true);

                    buyer_carPane.setDisable(false);
                    buyer_carPane.setEffect(null);

                    buyer_FirstNameTextfield.setEditable(false);
                    buyer_LastNameTextfield.setEditable(false);
                    buyer_PhoneNumberTextfield.setEditable(false);


                }

            }
        }
    }

    @FXML
    void buyerStartSearch(ActionEvent event) {

        boolean makeEmpty = buyer_MakeChoiceBox.getSelectionModel().isEmpty();
        boolean modelEmpty = buyer_ModelChoiceBox.getSelectionModel().isEmpty();

        if(makeEmpty || modelEmpty){
            buyer_MessageLabel.setText("Make and Model must be selected!");
        }else{

            String make = buyer_MakeChoiceBox.getValue();
            String model = buyer_ModelChoiceBox.getValue();
            setupMarketplaceForBuyer(make, model);
            tabPane.getSelectionModel().select(4);
            sellCar.setDisable(false);
            buyCar.setDisable(false);
        }






    }


    @FXML
    void refreshMarket(ActionEvent event) throws Exception {
        setupMarketplace();

    }

    private void insertSellerIntoDatabase(String fName, String lName, String address, String email, int phoneNumber) throws SQLException{

        Seller seller = new Seller(fName,lName,address,email,phoneNumber);
        con=DBConnection.insertSeller(seller);

    }

    private void insertBuyerIntoDatabase(String fName, String lName, int phoneNumber) throws SQLException{

        Buyer buyer = new Buyer(fName,lName,phoneNumber);
        con=DBConnection.insertBuyer(buyer);

    }

    private void insertCarIntoDatabase(String make, String model, String regNumber, int releaseYear, int price, int sellerPhoneNumber) throws SQLException{

        Car car = new Car(make, model, regNumber, releaseYear, price, sellerPhoneNumber);
        con=DBConnection.insertCar(car);

    }


    private void setupCarMake(){

        try{
            String query = "Select make from cardb";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //carMakeObList.clear();
                carMakeObList.add( resultSet.getString(1));


                System.out.println(
                        resultSet.getString(1) + " - "
                );
                car_MakeChoiceBox.setItems(carMakeObList);
            }
            //setupCarModal();

        } catch (Exception e) {
            System.out.println("Error during the connection...");
        }


    }

    private void setupCarModel(String selectedMake){

        //System.out.println("setupCarModel called");
        try{
            String query = "Select model from cardb where make='"+selectedMake+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            //System.out.println("in try loop");
            while (resultSet.next()) {
                carModelObList.clear();
                //System.out.println("in while loop");

                String result = resultSet.getString(1).toString();
                ///System.out.println(result);
                String [] models = result.split(",",-1);
                for(int i =0; i< models.length; i++) {
                    //System.out.println("in for loop");

                    String res = models[i];

                    carModelObList.add(res);


                    System.out.println(
                            resultSet.getString(1) + " - "
                    );

                }
                car_ModelChoiceBox.setItems(carModelObList);
            }

        } catch (Exception e) {
            System.out.println("Error during the connection...");
        }


    }

    private void setupCarReleasedYear(String selectedMake){

        //System.out.println("setupCarModel called");
        try{
            String query = "Select yearReleased from cardb where make='"+selectedMake+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                carYearObList.clear();

                String result = resultSet.getString(1).toString();
                String [] years = result.split(",",-1);
                for(int i =0; i< years.length; i++) {

                    String res = years[i];

                    carYearObList.add(res);


                }
                car_ReleasedYearChoiceBox.setItems(carYearObList);
            }

        } catch (Exception e) {
            System.out.println("Error during the connection...");
        }


    }


    //for SEARCH BUY CAR CHOICE_BOXES
    @FXML
    private void searchCarMakeSelect(){

        searchCarMakeSelected = buyer_MakeChoiceBox.getValue();
        System.out.println("Selected : "+ searchCarMakeSelected);
        searchCarModelSelect();
        buyer_ModelChoiceBox.setDisable(false);

    }

    @FXML
    private void searchCarModelSelect(){
        setupSearchCarModel(searchCarMakeSelected);
        searCarModelSelected = buyer_ModelChoiceBox.getValue();
        System.out.println("Selected " + searchCarMakeSelected + " - " + searCarModelSelected);
        searchCarYearSelect(searchCarMakeSelected, searCarModelSelected);

    }

    //not working properly, must fix
    @FXML
    private void searchCarYearSelect(String searchCarMakeSelected, String searCarModelSelect){
        buyer_YearChoiceBox.setDisable(false);
        setupSearchCarReleasedYear(searchCarMakeSelected,searCarModelSelect);
        searCarYearSelected = buyer_YearChoiceBox.getValue();
    }

    private void setupSearchCarMake(){

        try{
            String query = "Select make from cardb";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                buyerCarSearchMakeObList.add( resultSet.getString(1));

                buyer_MakeChoiceBox.setItems(buyerCarSearchMakeObList);
            }

        } catch (Exception e) {
            System.out.println("Error during the connection...");
        }


    }

    private void setupSearchCarModel(String selectedMake){
        buyerCarSearchModelObList.clear();
        try{
            String query = "Select model from car where make='"+selectedMake+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println("");
                String result = resultSet.getString(1);
                String [] models = result.split(",",-1);
                buyerCarSearchModelObList.addAll(Arrays.asList(models));

                buyer_ModelChoiceBox.setItems(buyerCarSearchModelObList);
            }

        } catch (Exception e) {
            System.out.println("Error during the connection in setupSearchCarModel...");
        }


    }

    //not working properly, must fix
    private void setupSearchCarReleasedYear(String makeSelected,String searCarModelSelected){
        buyerCarSearchYearObList.clear();
        System.out.println(makeSelected+ " " + searCarModelSelected);
        try{
            String query = "SELECT releaseYear FROM car WHERE (model='"+searCarModelSelected+"') AND (make='"+makeSelected+"')";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {


                String result = resultSet.getString(1);
                String [] years = result.split(",",-1);
                buyerCarSearchYearObList.addAll(Arrays.asList(years));
                buyer_YearChoiceBox.setItems(buyerCarSearchYearObList);
            }

        } catch (Exception e) {
            System.out.println("Error during the connection in setupSearchCarReleasedYear...");
        }


    }

    private void setupMarketplace(){
        //clear oblist before populate again <-- important because the refresh button
        oblist.clear();
        try{
            String query = "Select * from car";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                oblist.add( new Car(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6)));


                System.out.println(
                        resultSet.getString(1) + " "
                                + resultSet.getString(2) + " - "
                                + resultSet.getString(3) + " - "
                                + resultSet.getString(4) + " - "
                                + resultSet.getString(5) + " - "
                                + resultSet.getString(6)
                );

            }

        } catch (Exception e) {
            System.out.println("Error during the connection...");
        }

        market_Tableview.setItems(oblist);

    }

    private void setupMarketplaceForBuyer(String make, String model){
        //clear oblist before populate again <-- important because the refresh button
        oblist.clear();
        try{
            String query = "SELECT * FROM car WHERE (model='"+model+"') AND (make='"+make+"')";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                oblist.add( new Car(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6)));


                System.out.println(
                        resultSet.getString(1) + " "
                                + resultSet.getString(2) + " - "
                                + resultSet.getString(3) + " - "
                                + resultSet.getString(4) + " - "
                                + resultSet.getString(5) + " - "
                                + resultSet.getString(6)
                );

            }

        } catch (Exception e) {
            System.out.println("Error during the connection...");
        }

        market_Tableview.setItems(oblist);

    }



    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    public void initialize(URL location, ResourceBundle resource){
        assert car_priceSlider != null : "fx:id=\"car_priceSlider\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_MessageLabel != null : "fx:id=\"seller_MessageLabel\" was not injected: check your FXML file 'View.fxml'.";
        assert addcar_MessageLabel != null : "fx:id=\"addcar_MessageLabel\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_MessageLabel != null : "fx:id=\"buyer_MessageLabel\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_FirstNameTextfield != null : "fx:id=\"buyer_FirstNameTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert market_Tableview != null : "fx:id=\"market_Tableview\" was not injected: check your FXML file 'View.fxml'.";
        assert market_RegNumberTableColumn != null : "fx:id=\"market_RegNumberTableColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert market_refreshButton != null : "fx:id=\"market_refreshButton\" was not injected: check your FXML file 'View.fxml'.";
        assert car_ReleasedYearChoiceBox != null : "fx:id=\"car_ReleasedYearChoiceBox\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_YearChoiceBox != null : "fx:id=\"buyer_YearChoiceBox\" was not injected: check your FXML file 'View.fxml'.";
        assert sellCar != null : "fx:id=\"sellCar\" was not injected: check your FXML file 'View.fxml'.";
        assert buyerTab != null : "fx:id=\"buyerTab\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_EmailPartTwoTextfield != null : "fx:id=\"seller_EmailPartTwoTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_SaveAndSellButton != null : "fx:id=\"seller_SaveAndSellButton\" was not injected: check your FXML file 'View.fxml'.";
        assert market_PriceTableColumn != null : "fx:id=\"market_PriceTableColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert market_YearTableColumn != null : "fx:id=\"market_YearTableColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert buyCar != null : "fx:id=\"buyCar\" was not injected: check your FXML file 'View.fxml'.";
        assert market_SellerPhoneNumberTableColumn != null : "fx:id=\"market_SellerPhoneNumberTableColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_EmailPartOneTextfield != null : "fx:id=\"seller_EmailPartOneTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert market_MakeTableColumn != null : "fx:id=\"market_MakeTableColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert sellerTab != null : "fx:id=\"sellerTab\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_LastNameTextfield != null : "fx:id=\"buyer_LastNameTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert mainTab != null : "fx:id=\"mainTab\" was not injected: check your FXML file 'View.fxml'.";
        assert car_MakeChoiceBox != null : "fx:id=\"car_MakeChoiceBox\" was not injected: check your FXML file 'View.fxml'.";
        assert carTab != null : "fx:id=\"carTab\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_FirstNameTextfield != null : "fx:id=\"seller_FirstNameTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_PhoneNumberTextfield != null : "fx:id=\"buyer_PhoneNumberTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert car_ModelChoiceBox != null : "fx:id=\"car_ModelChoiceBox\" was not injected: check your FXML file 'View.fxml'.";
        assert car_PriceTextField != null : "fx:id=\"car_PriceTextField\" was not injected: check your FXML file 'View.fxml'.";
        assert car_SellCarButton != null : "fx:id=\"car_SellCarButton\" was not injected: check your FXML file 'View.fxml'.";
        assert market_ModelTableColumn != null : "fx:id=\"market_ModelTableColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_PhoneNumberTextfield != null : "fx:id=\"seller_PhoneNumberTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_StartSearchButton != null : "fx:id=\"buyer_StartSearchButton\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_AddressTextfield != null : "fx:id=\"seller_AddressTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_LastNameTextfield != null : "fx:id=\"seller_LastNameTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert seller_EmailPartThreeTextfield != null : "fx:id=\"seller_EmailPartThreeTextfield\" was not injected: check your FXML file 'View.fxml'.";
        assert resultTab != null : "fx:id=\"resultTab\" was not injected: check your FXML file 'View.fxml'.";
        assert car_RegistrationNumberTextField != null : "fx:id=\"car_RegistrationNumberTextField\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_SelectCarButton != null : "fx:id=\"buyer_SelectCarButton\" was not injected: check your FXML file 'View.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_MakeChoiceBox != null : "fx:id=\"buyer_MakeChoiceBox\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_carPane != null : "fx:id=\"buyer_carPane\" was not injected: check your FXML file 'View.fxml'.";
        assert buyer_ModelChoiceBox != null : "fx:id=\"buyer_ModelChoiceBox\" was not injected: check your FXML file 'View.fxml'.";

        setupMarketplace();
        setupCarMake();
        setupSearchCarMake();
        market_MakeTableColumn.setCellValueFactory(new PropertyValueFactory<>("car_make"));
        market_ModelTableColumn.setCellValueFactory(new PropertyValueFactory<>("car_model"));
        market_RegNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("car_regNumber"));
        market_YearTableColumn.setCellValueFactory(new PropertyValueFactory<>("car_releaseYear"));
        market_PriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("car_price"));
        market_SellerPhoneNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("seller_PhoneNumber"));

        //String makevalue = car_MakeChoiceBox.getValue();
        car_MakeChoiceBox.getSelectionModel().selectedItemProperty().addListener( (val, oldValue, newValue) -> {carMakeSelect();});
        car_priceSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

                car_PriceTextField.setText(String.valueOf(new_val.intValue()));

            }
        });
        buyer_MakeChoiceBox.getSelectionModel().selectedItemProperty().addListener( (val, oldValue, newValue) -> {searchCarMakeSelect();});

    }

    private boolean numberOrNot(String input)
    {
        try
        {
            parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }


}