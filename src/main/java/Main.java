package main.java;
  /////////////////////
 //  I.M.P.O.R.T.S  //
/////////////////////
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
      //////////////////////////
     //  V.A.R.I.A.B.L.E.S.  //
    //////////////////////////



      ///////////////////////////////////////
     //  G.E.T.T.E.R.S. + S.E.T.T.E.R.S.  //
    ///////////////////////////////////////

      ////////////////////////////////
     //  C.O.N.S.T.R.U.C.T.O.R.S.  //
    ////////////////////////////////

      //////////////////////
     //  M.E.T.H.O.D.S.  //
    //////////////////////
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Ordering Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //show the message
        //object.showMessage();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
