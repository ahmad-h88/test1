package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Objects;

public class App implements Printable{

    private VendingMachine vendingMachine;
    private double balance;
    private Menu menu;

    public App(Menu menu) {
        this.vendingMachine = new VendingMachine();
        this.balance = 0;
        this.menu = menu;
    }

    public void displayItems(){
        vendingMachine.displayItems();
    }

    public void purchase(){
        do {
            System.out.println(System.lineSeparator()+"Current Money Provided: $"+String.format("%.2f", balance));
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            switch (choice){
                case PURCHASE_MENU_OPTION_FEED_MONEY:
                    feedMoney();
                    break;
                case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                    selectProduct();
                    break;
                case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
                    finishTransaction();
                    break;
            }
        }while (true);
    }

    private void feedMoney() {
        double moneyProvided = Double.parseDouble((String) menu.getUserInput("Please enter amount"));
        if (moneyProvided>0){
            balance += moneyProvided;
        }else {
            System.out.println("Can't add 0 or negative number");
        }
    }

    private void selectProduct() {
        vendingMachine.displayItems();
        String selectedProduct = (String) menu.getUserInput(System.lineSeparator()+"Please enter slot number");
        Product product = vendingMachine.findProductByName(selectedProduct);
        if (Objects.isNull(product)){
            System.out.println("Wrong selection!");
            return;
        }
        if (balance >= product.getPrice()){
            try {
                vendingMachine.purchase(product);
                balance -= product.getPrice();
                System.out.println("Disposing "+product.getProductName());
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Insufficient balance");
        }
    }

    private void finishTransaction() {
        System.out.println("Thank you for your purchase! Please collect your change");
        System.out.println("change here");
        System.out.println("Your balance is 0");
        System.exit(-1);
    }
}
