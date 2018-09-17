package main.java;

import java.sql.*;

//following singleton patterns
public class DBConnection {

      //////////////////////////
     //  V.A.R.I.A.B.L.E.S.  //
    //////////////////////////
    private static Connection con = null;

    private Connection connection = null;
    private PreparedStatement insert = null;
    private PreparedStatement retrieve = null;
    private ResultSet rs;
    private String retrieveData = "";


      ///////////////////////////////////////
     //  G.E.T.T.E.R.S. + S.E.T.T.E.R.S.  //
    ///////////////////////////////////////


      ////////////////////////////////
     //  C.O.N.S.T.R.U.C.T.O.R.S.  //
    ////////////////////////////////
    //make the constructor private so that this class cannot be instantiated
    private DBConnection(){

    }

      //////////////////////
     //  M.E.T.H.O.D.S.  //
    //////////////////////
    //Get the only object available
    public static Connection getDBConnection(){
        try {
            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost/myDatabase_system", "root","");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static Connection insertSeller(Seller seller) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getDBConnection();
            ps = conn.prepareStatement("INSERT INTO seller "
                                        + "(fName, lname, address, email, phone_number) "
                                        + "VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, seller.getSeller_fName());
            ps.setString(2, seller.getSeller_lName());
            ps.setString(3, seller.getSeller_address());
            ps.setString(4, seller.getSeller_email());
            ps.setString(5, String.valueOf(seller.getSeller_phoneNumber()));

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in insertSeller");
        }
        return conn;
    }

    public static Connection insertBuyer(Buyer buyer) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("insertBuyer called");
        try {
            conn = DBConnection.getDBConnection();
            ps = conn.prepareStatement("INSERT INTO buyer "
                                        + "(fName, lname, phoneNumber) "
                                        + "VALUE (?, ?, ?)");
            ps.setString(1, buyer.getBuyer_fName());
            ps.setString(2, buyer.getBuyer_lName());
            ps.setString(3, String.valueOf(buyer.getBuyer_phoneNumber()));

            ps.executeUpdate();

            System.out.println(
                    buyer.getBuyer_fName() + " "
                            + buyer.getBuyer_lName() + " - "
                            + buyer.getBuyer_phoneNumber()
            );

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in insertBuyer");
        }

        return conn;
    }

    public static Connection insertCar(Car car) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("insertCar called");
        try {
            conn = DBConnection.getDBConnection();
            ps = conn.prepareStatement("INSERT INTO car "
                    + "(make, model, regNumber, releaseYear, price, sellerPhoneNUmber ) "
                    + "VALUE (?, ?, ?, ?, ?, ?)");
            ps.setString(1, car.getCar_make());
            ps.setString(2, car.getCar_model());
            ps.setString(3, car.getCar_regNumber());
            ps.setString(4, String.valueOf(car.getCar_releaseYear()));
            ps.setString(5, String.valueOf(car.getCar_price()));
            ps.setString(6, String.valueOf(car.getSeller_PhoneNumber()));

            ps.executeUpdate();

//            System.out.println(
//                    buyer.getBuyer_fName() + " "
//                            + buyer.getBuyer_lName() + " - "
//                            + buyer.getBuyer_phoneNumber()
//            );

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in insertCar");
        }

        return conn;
    }



}
