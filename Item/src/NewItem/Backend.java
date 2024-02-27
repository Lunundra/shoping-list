package NewItem;

import java.util.*;

//import javax.swing.text.html.HTMLEditorKit.Parser;

public class Backend {

	// Eine Globale ArrayList erstellen
	static List<Item> einkaufsliste = new ArrayList<Item>();
	
	// Erstellen einer ArrayList für die Shopnamen
	static List<String> Shops = new ArrayList<String>();


	// Erstellen von globalen Variablen
	static boolean isKGorPice = false;
	static String weightSize = "";

	public static void main(String[] args) {

		Shops.add("Spar");
		Shops.add("Netto");
		Shops.add("Maximarkt");
		Shops.add("Rewe");
		Shops.add("Billa");
		Shops.add("Hoffer");
		Shops.add("Bippa");
		
		System.out.println("Willkommen in deiner Einkaufsliste.");
		System.out.println();

		if (einkaufsliste.size() == 0) {
			System.out.println("Was möchtest du machen? (Wähle zwischen 1 und 2!)");
			smallMenue();
		} else {
			System.out.println("was möchtest du machen? (Wähle zwischen 1-5!)");
			menue();
		}
	}

	// Stellt ein Menü für die Optionen 1-5 da
	public static void menue() {

		String input;
		String stop = "";
		do {
			System.out.println();
			System.out.println("1. Ein Item hinzufügen");
			System.out.println("2. Ein Item entfernen");
			System.out.println("3. Ein Item bearbeiten");
			System.out.println("4. Liste ausgeben");
			System.out.println("5. Ein Item suchen");
			System.out.println("6. Das Programm beenden");

			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			input = input.replace(" ", "");

			if (input.equals("1")) {
				String menueStripes = "Willkommen in deiner Einkaufsliste.";
				System.out.println(stripes(menueStripes));
			} else {
				System.out.println();
			}
			switch (input) {

			case "1":

				addItemStart();
				stop = "stop";
				break;

			case "2":

//					String output = printItemList();
					boolean remove = false;
					stop = "stop";
					editOrRemoveFindItem(remove);
				
				break;

			case "3":
//					String output = printItemList();
					boolean edit = true;
					stop = "stop";
					editOrRemoveFindItem(edit);
				
				break;

			case "4":
					String output = printItemList();
					String stripes = stripes(output);
//					System.out.println(stripes);
					System.out.println();
					System.out.println("Möchtest du noch etwas machen? (Wähle zwischen 1-5)");
//					stop = "stop";
				

//				System.out.println();
//			menue();
				break;
				
				
			case "5":
				findItem();
				break;

			case "6":
				System.out.println("Ok, dann geh halt!");
				stop = "stop";
				break;

			default:
				System.out.println();
				System.out.println("Bitte wähle zwischen 1 - 5!");
				// System.out.println();
//			menue();
				break;
			}

		} while (!stop.equals("stop"));
//		}while(!input.equals("1") || !input.equals("2") || !input.equals("3") || !input.equals("4") || !input.equals("5"));
	}

	// kleines Menü, falls in der Liste nichts enthalten ist
	public static void smallMenue() {

		String input;
		String stop = "";
		do {
			System.out.println();
			System.out.println("1. Ein Item hinzufügen");
			System.out.println("2. Das Programm beenden");

			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			input = input.replace(" ", "");

			if (input.equals("1")) {
				String menueStripes = "Willkommen in deiner Einkaufsliste.";
				System.out.println(stripes(menueStripes));
			} else {
				System.out.println();
			}

			switch (input) {

			case "1":

				addItemStart();
				stop = "stop";
				break;

			case "2":
				System.out.println("Ok, dann geh halt!");
				stop = "stop";
				break;

			default:
//				System.out.println();
				System.out.println("Bitte wähle zwischen 1 und 2!");
				break;
			}

		} while (!stop.equals("stop"));
	}

	// Für den Start von AddItem
	public static void addItemStart() {

		int index = addItemIndex();
		String name = addItemName();
		isKGorPice = addItemIsKGorPice();
		String weightUnit = weitghtMenue();
		double mass = addItemMass(isKGorPice);
		String brand = addItemBrand();
		String shop = addItemShop();
		String information = addItemInformations();
		String specialPrice = addItemSpezialPrice();
		float price = addItemPrice();

		Item baum = new Item(index, name, isKGorPice, mass, weightUnit, brand, shop, information, specialPrice, price);
		addItemToList(baum);

		String stripes = "Bitte gib zusätzliche Informationen ein, wenn welche nötig sind!";

		if (stripes.length() < name.length()) {
			stripes = name;
		} else if (stripes.length() < brand.length()) {
			stripes = brand;
		} else if (stripes.length() < information.length()) {
			stripes = information;
		}

//		output = buildString(name, index, isKGorPice, mass, brand, information, price);

//		String output = printItemList();
//		stripes = stripes(stripes);
//		System.out.println(stripes);
		printItemList();

		System.out.println();
		if (einkaufsliste.size() == 0) {
			System.out.println("Was möchtest du machen? (Wähle zwischen 1 und 2!)");
			smallMenue();
		} else {
			System.out.println("was möchtest du machen? (Wähle zwischen 1-5!)");
			menue();
		}
//		System.out.println();
	}

	// Erstellt einen Strich, der so lange wie der mitgegebene String ist
	public static String stripes(String output) {
		String stripes = "";
		for (int i = 0; i <= output.length(); i++) {
			stripes = stripes + "_";
		}
		return stripes;
	}

	// Überprüft die Korektheit der Indexe und erstellt einen, wenn nötig
	public static int addItemIndex() {
//		System.out.println("Index wird durchgeführt");
		int index = 1;
		for (int i = 0; i < einkaufsliste.size(); i++) {
			index++;
		}

		int random = 0;
		int zaeler = 1;
		for (int i = 0; i < einkaufsliste.size(); i++) {
			Item baum = einkaufsliste.get(i);

			if (baum.getIndex() == i + 1) {
//			System.out.println(baum);	

//				System.out.println("Yup");
			} else {
				baum.setIndex(i + 1);
//				System.out.println("Nop");
			}
		}

		return index;
	}

	// Fragt nach dem Namen des Items
	public static String addItemName() {
		String name;
		do {
			System.out.println("Wie heißt das Produkt?");
//			System.out.println();

			Scanner scanner = new Scanner(System.in);
			name = scanner.nextLine();
			System.out.println();
			if (name.equals("")) {
				System.out.println("Bitte gib einen Namen ein!");
				System.out.println();
//			addItemName();
			}
		} while (name.equals(""));
//		System.out.println();
		return name;
	}

	// Fragt, ob das Item in KG oder in Stück gezählt wird
	public static boolean addItemIsKGorPice() {
		isKGorPice = false;
		String input;
		do {
			// Ausgabe und einlesen der Eingabe
			System.out.println("Wird das Produkt in Stück gemessen? (Ja/Nein)");
			// Konsolen Eingabe auslesen
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			System.out.println();

			input = input.toLowerCase();
			isKGorPice = false;

			// Überprüft, ob die Eingabe nicht Ja oder Nein ist
			if (!input.equals("ja") && (!input.equals("nein"))) {
				System.out.println();
//				System.out.println();
				System.out.println("Bitte gib Ja oder Nein ein!");
				System.out.println();
//				addItemIsKGorPice();
			}
			// Wenn der input nicht Ja oder Nein ist wird alles wiederholt
		} while (!input.equals("ja") && (!input.equals("nein")));

		// Setzt eine Variable auf einen Wert, je nachdem ob die Eingabe Ja oder Nein
		// ist
		if (input.equals("ja")) {
			isKGorPice = true;
		} else if (input.equals("nein")) {
			isKGorPice = false;
		}

//		System.out.println();
		return isKGorPice;
	}

	// Fragt nach der Gewichtsart
	public static String weitghtMenue() {
		String weightUnit = "";
		String input = "";
		String weight = "";
		boolean start = false;

		if (isKGorPice == false) {
			do {

				System.out.println("Welche Größe hat das Produkt?");
				System.out.println();
				System.out.println("1. Gramm");
				System.out.println("2. Kilogramm");
				System.out.println("3. Tonne");

				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();

				switch (input) {

				case "1":
					weightUnit = "g";
					weightSize = "g";
					start = true;
					break;

				case "2":
					weightUnit = "Kg";
					weightSize = "Kg";
					start = true;
					break;

				case "3":
					weightUnit = "t";
					weightSize = "t";
					start = true;
					break;

				default:
					System.out.println();
					System.out.println();
					System.out.println("Bitte gib nur 1, 2 oder 3 ein!");

				}
			} while (start == false);
			System.out.println();
		}
		return weightUnit;
	}

	// Fragt nach dem Gewicht des Items
	public static double addItemMass(Boolean isKGorPice) {

		double mass = 0;
		String input;
		Boolean onlyNumbers = false;
//		Item baum = einkaufsliste.get(0);

		do {
			String checkedInput = "";
			if (isKGorPice == true) {
				System.out.println("Wie viel Stück hat das Produkt?");
			} else if (isKGorPice == false) {
				System.out.println("Wie viel wiegt das Produkt? (in " + weightSize + ")");
			}

			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			System.out.println();
			input = input.replace(',', '.');

			if (input.length() == 1) {
				input = input.replace('.', ' ');
				input = input.stripLeading();
			}

			for (int i = 1; i < input.length(); i++) {

				if (input.charAt(i) == '.') {
					checkedInput = checkedInput + input.charAt(i);
				}
			}

			if (!input.contains(",") && !input.contains(".")) {
				checkedInput = "";
			}

			if (!input.equals("")) {
				onlyNumbers = checkLetters(input);

				if (checkedInput.length() > 1) {
					onlyNumbers = false;
				}

				if (onlyNumbers == true) {
					mass = Double.parseDouble(input);
				} else {
					System.out.println();
					System.out.println("Bitte gib nur Zahlen und maximal ein , ein!");
					System.out.println();
//					addItemMass(KGorPice);
				}
			} else {
				System.out.println();
				System.out.println("Bitte gib nur Zahlen und maximal ein , ein!");
				System.out.println();
//				addItemMass(KGorPice);
			}
		} while (input.equals("") || (!onlyNumbers == true));

//		System.out.println();

		return mass;
	}

	// Diese Methode liefert einen Boolean zurück, ob ein String ausschließlich
	// Zahlen enthält (true) oder auch andere Zeichen (false).
	public static boolean checkLetters(String input) {
		char isKommaOrNot;
		for (int i = 0; i < input.length(); i++) {
			isKommaOrNot = input.charAt(i);
			if (!Character.isDigit(input.charAt(i)) && !(isKommaOrNot == ',') && !(isKommaOrNot == '.')) {
				return false;
			}
		}
		return true;
	}

	// Fragt nach der Marke des Produkts. Wenn keine Marke eingegeben wird, wird "Of
	// Brand" gespeichert
	public static String addItemBrand() {
		String brand;
		System.out.println("Von welcher Marke ist das Produkt?");
		Scanner scanner = new Scanner(System.in);
		brand = scanner.nextLine();
		System.out.println();

		if (brand.equals("")) {
			brand = "Of brand";
		}
//		System.out.println();
		return brand;
	}

	// Fragt nach dem Laden, in dem das Produkt gekauft wurde
	public static String addItemShop() {
		// Erstellen einer Liste für die Shopnamen
//		List <String> Shops = new ArrayList <String>();	

		// Hinzufügen der Shopnamen zu der Liste
//		Shops.add("Spar");
//		Shops.add("Netto");
//		Shops.add("Rewe");
//		Shops.add("Billa");
//		Shops.add("Hoffer");
//		Shops.add("Bippa");



		// Variablen initialisieren und deklarieren
		String input = "";
		String shop = "";
		boolean stop = false;
		Integer shopCount = 0;
		boolean checkedImput = false;
		int ListSize = 0;

		do {

			// Ausgeben von dem Text
			System.out.println("Von welchem Shop ist das Produkt?");
			System.out.println();

			// Ausgeben von dem Array
			for (int i = 0; i < Shops.size(); i++) {
				System.out.println(i + 1 + ". " + Shops.get(i));

			}

			System.out.println(Shops.size() + 1 + ". Ein anderer Shop");

			// Eingabe einlesen
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			System.out.println();

			checkedImput = checkLetters(input);
			input = input.replace('.', ' ');
			input = input.replace(',', ' ');
			input = input.strip();

			if (checkedImput == true) {

				shopCount = Integer.parseInt(input);

				if (shopCount - 1 <= Shops.size()) {

					if (shopCount <= Shops.size()) {
						// Shopname "herraus finden" und übergeben
						shop = Shops.get(shopCount - 1);
						stop = true;
					} else {
						System.out.println("Wie heißt der Shop?");
						input = scanner.nextLine();
						System.out.println();

						Shops.add(input);
						shop = input;
						stop = true;
					}
				} else {
					ListSize = Shops.size() + 1;
					System.out.println("Bitte gib nur Zahlen zwischen 1 und " + ListSize + " ein!");
				}

			} else {
				ListSize = Shops.size() + 1;
				System.out.println("Bitte gib nur Zahlen zwischen 1 und " + ListSize + " ein!");
			}

		} while (!stop == true);
		return shop;
	}

	// Fragt nach zusätzlichen Informationen über das Produkt
	public static String addItemInformations() {
		String infos;
		System.out.println("Gibt es zusätzliche Informationen?");
		Scanner scanner = new Scanner(System.in);
		infos = scanner.nextLine();
		System.out.println();

		return infos;
	}

	// Fragt nach, ob es sich bei dem Preis um einen Sonderpreis handelt oder nicht
	public static String addItemSpezialPrice() {
		String spezialPrice = "";
		String input;
		boolean stop = false;

		do {

			System.out.println("War der Preis ein Sonderpreis? (Ja/Nein)");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			input = input.toLowerCase();
			System.out.println();

			if (input.equals("ja") || input.equals("nein")) {

				if (input.equals("ja")) {
					spezialPrice = "Spezial Preis";
				}
				
				if (input.equals("nein")) {
					spezialPrice = "Kein Spezial Preis";
				}
				stop = true;
			}
			else {
				System.out.println();
				System.out.println("Bitte gib nur Ja oder Nein ein!");
				System.out.println();
				stop = false;
			}
			
		} while (stop == false);
		return spezialPrice;
	}

	// Fragt nach dem Preis des Items
	public static float addItemPrice() {
		float price = 0;
		String input;
		boolean onlyNumbers;
		int charPosition = 0;

		do {

			// Überprüft die Eingabe auf
			System.out.println("Wie viel kostet das Produkt?");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			System.out.println();
			onlyNumbers = checkLetters(input);
			input = input.replace(',', '.');
			String checkedInput = "";

			if (input.length() == 1) {
				input = input.replace('.', ' ');
				input = input.stripLeading();
			}

			for (int i = 1; i < input.length(); i++) {

				if (input.charAt(i) == '.') {
					checkedInput = checkedInput + input.charAt(i);
					charPosition = i;
				}
			}

//			input.length() - 3 == charPosition || input.length() - 2 == charPosition
//			input.charAt(input.length() - 2) == '.' || input.charAt(input.length() - 1) == '.'

			if (input.length() - 3 == charPosition || input.length() - 2 == charPosition || !(input.contains("."))) {

				if (checkedInput.length() > 1) {
					onlyNumbers = false;
				}

				if (!input.equals("")) {
					if (onlyNumbers == true) {
						price = Float.parseFloat(input);
					} else {
						System.out.println();
						System.out.println("Bitte gib nur Zahlen und maximal ein , ein!");
						System.out.println();
//				addItemPrice();
					}
				} else {
					System.out.println();
					System.out.println("Bitte gib nur Zahlen und maximal ein , ein!");
					System.out.println();
//			addItemPrice();
				}
//		System.out.println();	
			} else {
				System.out.println();
				System.out.println("Bitte gib nur maximal 2 Nachkommastellen ein!");
				System.out.println();
				onlyNumbers = false;
			}
		} while (input.equals("") || (!onlyNumbers == true));
		return price;
	}

	// Fügt das Item der ArrayList hinzu
	public static void addItemToList(Item baum) {

		einkaufsliste.add(baum);
//		Item ast = einkaufsliste.get(0);
	}

	// Gibt die Liste aus
	public static String printItemList() {

		addItemIndex();
		int counter = 0;
		int oneTime = 0;
		String lineSeter = "";
		String blume = "";

		if (einkaufsliste.size() > 0) {
			// Iterriert durch die Liste und sucht das längste Item
			for (Item baum : einkaufsliste) {

				if (baum.isKGorPice == true) {
					blume = "Index:	" + baum.getIndex() + "   Name: " + baum.getName() + "   Stück: " + baum.getMass()
							+ "   Marke: " + baum.getBrand() + "   Shop: " + baum.getShop() + "   Informations: "
							+ baum.getInformation() + "   Sonderpreis: " + baum.getSonderpreis() + "   Preis: " + baum.getPrice() + " €";

				} else {
					blume = "Index: " + baum.getIndex() + "   Name: " + baum.getName() + "   Gewicht: " + baum.getMass()
							+ " " + baum.getWeightUnit() + "   Marke: " + baum.getBrand() + "   Shop: " + baum.getShop()
							+ "   Informations: " + baum.getInformation() + "   Sonderpreis: " + baum.getSonderpreis() + "   Preis: " + baum.getPrice() + " €";
				}

				if (blume.length() > lineSeter.length()) {
					lineSeter = blume;
				}
			}

			System.out.println(stripes(lineSeter));

			// Iteriere durch die Liste und gib jedes Item aus
			for (Item baum : einkaufsliste) {

				if (baum.isKGorPice == true) {
					blume = "Index: " + baum.getIndex() + "   Name: " + baum.getName() + "   Stück: " + baum.getMass()
							+ "   Marke: " + baum.getBrand() + "   Shop: " + baum.getShop() + "   Informations: "
							+ baum.getInformation() + "   Sonderpreis: " + baum.getSonderpreis() + "   Preis: " + baum.getPrice() + " €";
				} else {
					blume = "Index: " + baum.getIndex() + "   Name: " + baum.getName() + "   Gewicht: " + baum.getMass()
							+ " " + baum.getWeightUnit() + "   Marke: " + baum.getBrand() + "   Shop: " + baum.getShop()
							+ "   Informations: " + baum.getInformation() + "   Sonderpreis: " + baum.getSonderpreis() + "   Preis: " + baum.getPrice() + " €";
				}

				System.out.println(blume);
				if (counter < einkaufsliste.size() - 1) {
					String strichlierteLinie = "";
					if (einkaufsliste.size() > 1) {
						for (int i = 0; i < lineSeter.length() + 1; i++) {
							strichlierteLinie = strichlierteLinie + "-";
						}
						System.out.println(strichlierteLinie);
					}
					counter++;
				}
			}
			System.out.println(stripes(lineSeter));
		} else {
			String keinItem = "Es ist kein Item mehr in der Liste!";
			System.out.println(stripes(keinItem));
			System.out.println(keinItem);
			System.out.println(stripes(keinItem));
		}
		System.out.println();
		return lineSeter;
	}

	// Löscht das ausgewählte Item
	public static void deleteItem(int index) {
		einkaufsliste.remove(index);
		System.out.println();
		String output = printItemList();
		String stripes = stripes(output);
//		System.out.println(stripes);

		System.out.println();
		if (einkaufsliste.size() == 0) {
			System.out.println("Was möchtest du machen? (Wähle zwischen 1 und 2!)");
			smallMenue();
		} else {
			System.out.println("was möchtest du machen? (Wähle zwischen 1-5!)");
			menue();
		}
	}

	// Startet das bearbeiten von einem Item, Sucht das zu bearbeitende/ zu
	// löschende Item

	public static void editOrRemoveFindItem(boolean removeOrEdit) {

		String choosenItem;
		boolean onlyNumbers;
		int checkLength = 0;
		do {

			System.out.println();

			if (removeOrEdit == true) {
				System.out.println("Welches Item möchtest du bearbeiten? (Gib den Index ein)");
			} else {
				System.out.println("Welches Item möchtest du löschen? (Gib den Index ein)");
			}

			printItemList();
//			String stripes = stripes(output);
//			System.out.println(stripes);

			Scanner scanner = new Scanner(System.in);
			choosenItem = scanner.nextLine();
			onlyNumbers = checkLetters(choosenItem);
			System.out.println();

			if (!choosenItem.equals("") && onlyNumbers == true && !choosenItem.equals("0")) {

				Integer choosenItemIndex = Integer.parseInt(choosenItem);

				if (choosenItemIndex <= einkaufsliste.size()) {
					if (removeOrEdit == true) {
						editItemChoose(choosenItemIndex - 1);
						break;
					} else {
						deleteItem(choosenItemIndex - 1);
						break;
					}
				} else {
					System.out.println("Bitte gib nur Zahlen zwischen 1 und " + einkaufsliste.size() + " ein!");
				}
				checkLength = Integer.parseInt(choosenItem);
			} else {
				System.out.println("Bitte gib nur die Indexnummer an!");
			}

		} while (!onlyNumbers == true || !(checkLength <= einkaufsliste.size()) || !(checkLength == 0)
				|| (choosenItem.equals("")) || (choosenItem.equals("0")));
	}

	// Wählt, was bearbeitet werden soll
	public static void editItemChoose(int itemIndex) {
//		editItemChoose();
		String changeInput;
		Scanner scanner = new Scanner(System.in);
		do {
			do {
				Item baum = einkaufsliste.get(itemIndex);
				System.out.println();
				System.out.println("Was Möchtest du ändern?");
				System.out.println("1. Name");
				System.out.println("2. Gewicht/Stück");
				System.out.println("3. Marke");
				System.out.println("4. Shop");
				System.out.println("5. Informationen");
				System.out.println("6. Sonderpreis");
				System.out.println("7. Preis");
				System.out.println();

				changeInput = scanner.nextLine();
				changeInput = changeInput.toLowerCase();

				switch (changeInput) {
				case "1":
					baum.setName(addItemName());
					break;

				case "2":
					isKGorPice = addItemIsKGorPice();
					baum.setWeightUnit(weitghtMenue());
					baum.setMass(addItemMass(isKGorPice));
					break;

				case "3":
					baum.setBrand(addItemBrand());
					break;

				case "4":
					baum.setShop(addItemShop());
					break;
					
				case "5":
					baum.setInformation(addItemInformations());
					break;
					
				case "6":
					baum.setSonderpreis(addItemSpezialPrice());
					break;

				case "7":

					baum.setPrice(addItemPrice());
					break;

				default:
					System.out.println();
					System.out.println("Bitte gib eine Zahl zwischen 1 und 7 ein!");
//				editItemChoose(itemIndex);
					break;
				}
			} while (!changeInput.equals("1") && !changeInput.equals("2") && !changeInput.equals("3")
					&& !changeInput.equals("4") && !changeInput.equals("5") && !changeInput.equals("6") && !changeInput.equals("7"));

			String output = printItemList();
			String stripes = stripes(output);
//			System.out.println(stripes);

			do {

				System.out.println("Möchtest du noch etwas anders ändern? (Ja/Nein)");
				changeInput = scanner.nextLine();
				changeInput = changeInput.toLowerCase();
				System.out.println();

				if (changeInput.equals("ja")) {

					/*
					 * System.out.println("Bei diesem Item? (Ja/Nein)"); changeInput =
					 * scanner.nextLine(); changeInput.toLowerCase();
					 * 
					 * if (changeInput.equals("ja")) { editItemChoose(itemIndex); break; } else {
					 */
					editOrRemoveFindItem(true);
					break;
//					}
				} else if (changeInput.equals("nein")) {

					if (einkaufsliste.size() == 0) {
						System.out.println("Was möchtest du machen? (Wähle zwischen 1 und 2!)");
						smallMenue();
					} else {
						System.out.println("was möchtest du machen? (Wähle zwischen 1-5!)");
						menue();
					}
					break;
				} else {
					System.out.println();
					System.out.println("Bitte gib Ja oder Nein ein!");
					System.out.println();
				}
			} while (!changeInput.equals("ja") || !changeInput.equals("nein"));

		} while (!changeInput.equals("ja") && !changeInput.equals("nein"));
	}
	
	
	
	public static void findItem(){
		// Variablen Initialisieren/Deklarieren
		String input;
		boolean foundIt = false;
		addItemIndex();
		int counter = 0;
		int oneTime = 0;
		String lineSeter = "";
		String blume = "";

		
		for (Item Item : einkaufsliste) {
			System.out.println("Index: " + Item.getIndex() + "    Name: " + Item.getName() + "    KG/Pice: "
					+ Item.getisKGorPice() + "    Gewicht: " + Item.getMass() + "    Gewichtseinheit: "
					+ Item.getWeightUnit() + "    Marke: " + Item.getBrand() + "    Shop: " + Item.getShop()
					+ "    Infos: " + Item.getInformation() + "    Sonderpreis: " + Item.getSonderpreis()
					+ "    Preis: " + Item.getPrice());
			System.out.println();
		}


		do {
			
			// ArrayList für die Indexe, an der sich die zu suchende Elemente befinden
			List<Integer> indexOfTest = new ArrayList<>();

			// Variable Initialisieren 
			foundIt = false;

			// Das zu suchende Element abfragen
			System.out.println("Nach was wird gesucht?");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();


			// Überprüfen, ob sich das gesuchte Element in der Liste befindet
			System.out.println();
			for (Item baum : einkaufsliste) {
					Integer index = baum.getIndex();
					Boolean kgOrPice = baum.getisKGorPice();
					Double mass = baum.getMass();
					Float price = baum.getPrice();
										
			
				if (baum.getName().toLowerCase().contains(input.toLowerCase())
						|| baum.getBrand().toLowerCase().contains(input.toLowerCase())
						|| baum.getInformation().toLowerCase().contains(input.toLowerCase())
						|| baum.getWeightUnit().toLowerCase().contains(input.toLowerCase())
						|| baum.getShop().toLowerCase().contains(input.toLowerCase())
						|| baum.getSonderpreis().toLowerCase().contains(input.toLowerCase()) || index.toString().contains(input) || kgOrPice.toString().contains(input) || mass.toString().contains(input) || price.toString().contains(input)) {
					indexOfTest.add(baum.getIndex());
					if (baum.isKGorPice == true) {
						blume = "Index: " + baum.getIndex() + "   Name: " + baum.getName() + "   Stück: " + baum.getMass()
								+ "   Marke: " + baum.getBrand() + "   Shop: " + baum.getShop() + "   Informations: "
								+ baum.getInformation() + "   Sonderpreis: " + baum.getSonderpreis() + "   Preis: " + baum.getPrice() + " €";
					} else {
						blume = "Index: " + baum.getIndex() + "   Name: " + baum.getName() + "   Gewicht: " + baum.getMass()
								+ " " + baum.getWeightUnit() + "   Marke: " + baum.getBrand() + "   Shop: " + baum.getShop()
								+ "   Informations: " + baum.getInformation() + "   Sonderpreis: " + baum.getSonderpreis() + "   Preis: " + baum.getPrice() + " €";
					}

					System.out.println(blume);
					if (counter < einkaufsliste.size() - 1) {
						String strichlierteLinie = "";
						if (einkaufsliste.size() > 1) {
							for (int i = 0; i < lineSeter.length() + 1; i++) {
								strichlierteLinie = strichlierteLinie + "-";
							}
							System.out.println(strichlierteLinie);
						}
						counter++;
					}
				}
				System.out.println(stripes(lineSeter));
					foundIt = true;
				}
			
			System.out.println();

			
			// Falls das Element nicht gefunden wurde
			if (foundIt == false) {
				System.out.println("Nichts gefunden!");
			}

		} while (!input.equals("end"));
	}
}
