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
			int val = sc.nextInt();

			try {

				if (val > 8 || val < 1) {
					System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				}

				if (val == 1) {
					getBankAccount();
				}
				if (val == 2) {
					findCustomer();
				}
				
				if (val == 3) {
					deposit();				
				}
				
				if (val == 4) {
					withdraw();
				}
				
				if (val == 5) {
					transfer();
				}
				
				if (val == 6) {
					createAccount();
					
				}
				
				if (val == 7) {
					removeAccount();
					
				}
				
				if (val == 8) {
					System.out.println("Bankprogrammet avslutas.");     //Lägg till "sparar" promt här 
					break; 
					
				}

			} catch (Exception e) {
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				continue; 
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
		System.out.println("Namnet på er bank är nu" + bank.toString());
		System.out.println("Find Holder " + bank.findHolder(7474783));
		
	}
	
	public static Customer findCustomer() {
		
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
