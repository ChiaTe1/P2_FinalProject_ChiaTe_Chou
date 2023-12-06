/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 * GitHub:https://github.com/ChiaTe1/P2_FinalProject_ChiaTe_Chou.git 
 * ATM Software with JavaFX login
*/
 
package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author ChiaTe Atm software with javaFX implementation that allows the user
 * to experience real world system log in and money withdrawal
 */
public class Project extends Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Client client1 = new Client("Bob", "232323", "123450");
        System.out.println(client1.toString());
        File file = new File("SavedData");
        System.out.println("Path: " + file.getAbsolutePath());

//        launch(args);
    }

    /**
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        //GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Scene
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Controls and allow user to type
        Label accName = new Label("Account Number: ");
        grid.add(accName, 0, 1);

        TextField accNameText = new TextField();
        grid.add(accNameText, 1, 1);

        Label passW = new Label("Password: ");
        grid.add(passW, 0, 2);

        PasswordField passWText = new PasswordField();
        grid.add(passWText, 1, 2);

        Button buttonSign = new Button("Login");
        HBox hbxButton = new HBox(10);
        hbxButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbxButton.getChildren().add(buttonSign);
        grid.add(hbxButton, 1, 4);

        Label statusLabel = new Label();
        grid.add(statusLabel, 1, 6);

        Bank bank = new Bank();
        bank.setTotalDeposit("chequing", 150.0);
        bank.setTotalDeposit("saving", 1150.0);

        ATMSecurity atmSecurity = new ATMSecurity() {
            @Override
            public boolean validateLogin(String accountNumber, String password) {
                String validAccountNumber = "232323";
                String validPassword = "123450";
                return accountNumber.equals(validAccountNumber) && password.equals(validPassword);
            }
//Wanted to implement within ATMSecurity iniatially, however didn't feel necessary
// 
//            @Override
//            public boolean validateWithdrawal(String accountNumber, double amount) {
//                double accountBalance = bank.checkBalance(accountNumber);
//                return accountBalance >= amount;
//            }
        };

        ATMSoftware atmSoftware = new ATMSoftware(bank);

        buttonSign.setOnAction((ActionEvent e) -> {
            String accountNumber = accNameText.getText();
            String password = passWText.getText();

            try {
                if (atmSecurity.validateLogin(accountNumber, password)) {
                    statusLabel.setText("Login Sucesssful");
                    System.out.println("Select account: Chequing or Saving");
                    Scanner userInput = new Scanner(System.in);
                    String selectedAccount = userInput.nextLine();
                    if (selectedAccount.equalsIgnoreCase("chequing") || selectedAccount.equalsIgnoreCase("saving")) {
                        System.out.println("Enter amount to withdrawal: ");
                        double amount = userInput.nextDouble();
                        System.out.println("The amount selected is: " + amount);
                        if (atmSoftware.withdraw(selectedAccount, amount)) {
                            double remainingBalance = atmSoftware.checkBalance(selectedAccount);
                            System.out.println("Withdrawn amount: " + amount);
                            System.out.println("Remaining balance in " + selectedAccount + " account: " + remainingBalance);
                        } else {
                            System.out.println("Total deposit unsuffisant, please re-enter amount");
                        }
                    }
                }
            } catch (InputMismatchException a) {
                statusLabel.setText("Login unsucessful, please try again" + a.getMessage());
            }
        });

    }

    public class save {

        public static void saveData(String accountNumber, String password) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("SavedData"))) {
                writer.write(accountNumber + ',' + password);
                writer.newLine();
            } catch (IOException a) {
                System.out.println("Error" + a.getMessage());
            }
        }
    }
}
