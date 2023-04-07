package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Objects;

public class VendingMachineCLI implements Printable{

	private Menu menu;
	private App app;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.app = new App(menu);
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				app.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				app.purchase();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				exit();
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	private void exit(){
		System.exit(-1);
	}
}
