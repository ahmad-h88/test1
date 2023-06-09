package com.techelevator;

public interface Printable {
    String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    String MAIN_MENU_OPTION_EXIT = "Exit";
    String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
    String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
}
