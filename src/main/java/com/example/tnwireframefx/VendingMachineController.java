package com.example.tnwireframefx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineController {
    @FXML
    private final List<Double> prices = new ArrayList<>();
    @FXML
    private final List<String> drinks = new ArrayList<>();

    @FXML
    private Label output;

    @FXML
    private TextField payment;

    @FXML
    protected void onPayBtn() {
        if(!payment.getText().isEmpty()){
            double totalPrice = getTotalPrice();
            double paymentAsDouble = 0;
            try {
                paymentAsDouble = Double.parseDouble(payment.getText());
                if(paymentAsDouble < totalPrice){
                    output.setText("Not enough money!");
                } else if (paymentAsDouble > totalPrice) {
                    output.setText(getDrink() +
                            "- Total: " + totalPrice + "€"+
                            ": Change: " + String.format("%.2f",(paymentAsDouble - totalPrice)) + "€");
                } else {
                    output.setText(getDrink()+ " total price: "+totalPrice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                output.setText("Invalid input!!!!!");
            }
            cleanUP();
        }else{
            output.setText("Please insert money!");
            cleanUP();
        }
    }

    private double getTotalPrice() {
        double totalPrice = 0;
        for(Double d : prices)
            totalPrice += d;
        return totalPrice;
    }

    private void cleanUP() {
        payment.setText("");
        drinks.clear();
        prices.clear();
    }

    private String getDrink() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < drinks.size() ; i++) {
            if(i != drinks.size()-1){
                tmp.append(drinks.get(i)).append(", ");
            }else
                tmp.append(drinks.get(i)).append(". ");
        }
        return tmp.toString();
    }

    @FXML
    private void onColaBtn() {
        drinks.add("Cola");
        prices.add(2.5);
    }
    @FXML
    private void onSpriteBtn() {
        drinks.add("Sprite");
        prices.add(2.5);
    }

    @FXML
    private void onWineBtn() {
        drinks.add("Wine");
        prices.add(9.9);
    }
    @FXML
    private void onIceTeaBtn() {
        drinks.add("Ice Tea");
        prices.add(2.5);
    }

    @FXML
    private void onResetBtn(){
        cleanUP();
        output.setText("Welcome!");
    }
}