import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {

	private static Scanner sc;
	private static Bank bank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Välkommen till Orre & Svennis Bankapplikation");
		System.out.println("Vad vill ni döpa er bank till?");
		Bank bank = new Bank(sc.next());
		System.out.println("Välkommen till " + bank.toString());
		System.out.println("Vad önskar ni göra?");

		while (true) {
			intro();
			int val = 0; 
			try {
	
				 val = sc.nextInt();
			

				switch (val) {
				case 1:
					getBankAccount();
				case 2:
					findCustomer();
				case 3:
					deposit();
				case 4:
					withdraw();
				case 5:
					transfer();
				case 6:
					createAccount();
				case 7:
					removeAccount();
				case 8:
					System.out.println("Bankprogrammet avslutas."); // Lägg till "sparar" promt här
					break;
				default:
					System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
					continue;
				}

			} catch (InputMismatchException e) {
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen"); 
				continue;
				

			} finally {
				sc.nextLine(); //För att fånga upp retur-knappen
			}
		}

	}

	public static void intro() {
		System.out.println("Tryck 1 för att leta upp ett konto för en viss kontoinnehavare");
		System.out.println("Tryck 2 för att leta upp en kontoinnehavare");
		System.out.println("Tryck 3 för att sätta in pengar på ett nytt konto");
		System.out.println("Tryck 4 för att ta ut pengar från ett konto");
		System.out.println("Tryck 5 för att överföra pengar från ett konto till ett annat");
		System.out.println("Tryck 6 för att skapa ett nytt konto");
		System.out.println("Tryck 7 för att ta bort ett konto");
		System.out.println("Tryck 8 för att för att avsluta programmet");

	}

	public static BankAccount getBankAccount() {
		System.out.println("Vill ni söka på kundnummer eller personnummer?");
		System.out.println("Tryck 1 för kundnummer och 2 för personnummer.");
		int val = sc.nextInt();
		while (true) {
			switch (val) {
			case 1: // Kod för att söka på kundnummer;
				break;
			case 2: // Kod för att söka på personnummer;
				break;
			default:
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				continue;

			}
		}

	}

	public static Customer findCustomer() {

		System.out.println("Mata in vilken person du vill söka efter");
		String person = sc.next();
		System.out.println("Vem av dessa personer? " + bank.findByPartofName(person));

	}

	public static void deposit() {

	}

	public static void withdraw() {

	}

	public static void transfer() {

	}

	public static void createAccount() {

	}

	public static void removeAccount() {

	}

}
