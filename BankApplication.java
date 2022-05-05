import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	private static Scanner sc;
	private Bank bank;
	private int sum; 

	public BankApplication() {
		sc = new Scanner(System.in);
		System.out.println("Välkommen till Orre & Svennis Bankapplikation");
		System.out.println("Vad vill ni döpa er bank till?");
		bank = new Bank(sc.nextLine());
		System.out.println("Välkommen till " + bank.toString());
		System.out.println("Vad önskar ni göra?");
		
		int val;
			boolean kor = true;  // Boolean för att köra programmet 
		while (kor) {
			intro();
			val = scanner(8);
			System.out.println("Du valde val: " + val);

			switch (val) {
			case 1:
				getBankAccount();
				break;
			case 2:
				findCustomer();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				transfer();
				break;
			case 6:
				createAccount();
				break;
			case 7:
				removeAccount();
				break;
			case 8:
				System.out.println("Bankprogrammet avslutas."); // Lägg till "sparar" promt här
				kor = false; 
				break;
			}
			System.out.println("-----------------------------------------------------------------");

		}

	}

	public void intro() {
		System.out.println("Tryck 1 för att leta upp ett konto för en viss kontoinnehavare");
		System.out.println("Tryck 2 för att leta upp en kontoinnehavare");
		System.out.println("Tryck 3 för att sätta in pengar på ett nytt konto");
		System.out.println("Tryck 4 för att ta ut pengar från ett konto");
		System.out.println("Tryck 5 för att överföra pengar från ett konto till ett annat");
		System.out.println("Tryck 6 för att skapa ett nytt konto");
		System.out.println("Tryck 7 för att ta bort ett konto");
		System.out.println("Tryck 8 för att för att avsluta programmet");

	}

	public BankAccount getBankAccount() {
		System.out.println("Ange personnummer: ");
		long idNr = scanner(Long.MAX_VALUE);
		ArrayList<BankAccount> accounts = bank.findAccountsForHolder(idNr);
		System.out.println("Välj ett konto: ");
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println("Skriv " + i + 1 + " för konto: " + accounts.get(i));

		}
		return accounts.get(scanner(accounts.size())-1);

	}

	public Customer findCustomer() {
		System.out.println("Mata in vilken person du vill söka efter");
		String person = scanner();
		System.out.println("Vem av dessa personer? " + bank.findByPartofName(person));
		ArrayList<Customer> customers = bank.findByPartofName(person);
		for (Customer customer: customers) {
			sum++;
			System.out.println("val " + sum +" är: " + customer);
		}
		
		return customers.get(scanner(customers.size())-1);

	}

	public void deposit() {
		BankAccount account = getBankAccount();
		System.out.println("Skriv in hur mycket pengar som ni önskar sätta in");
		account.deposit(scanner(Double.MAX_VALUE));
		System.out.println("Detta konto har nu: " + account.getAmount() + " SEK");

	}

	public void withdraw() {
		BankAccount account = getBankAccount();
		System.out.println("Hur mycket pengar önskar ni ta ut?");
		System.out.println("Ni kan som mest ha 1000 SEK i kredit.");
		account.withdraw(scanner(account.getAmount() + 1000.0)); // Max back 1000 kr
		System.out.println("Detta konto har nu: " + account.getAmount() + " SEK");

	}

	public void transfer() {
		BankAccount account = getBankAccount();
		System.out.println("Detta konto har: " + account.getAmount() + " SEK");
		double value = scanner(account.getAmount() + 1000.0);
		account.withdraw(scanner(account.getAmount() + 1000.0));
		BankAccount account2 = getBankAccount(); // Nytt kontoobjekt där man lägger till pengar
		account2.deposit(value);
		System.out.println("Detta konto har: " + account2.getAmount() + " SEK");

	}

	public void createAccount() {
		System.out.println("Ange namn: ");
		String name = scanner();
		System.out.println("Ange Personnummer: ");
		Long idNr = scanner(Long.MAX_VALUE);
		bank.addAccount(name, idNr);
		System.out.println("Konto för " + name + " med personnummer: " + idNr + " har nu skapats");

	}

	public void removeAccount() {

	}

	public int scanner(int goodNumbers) {
		while (true) {
			try {
				int val = 0;
				val = Integer.parseInt(sc.nextLine());
				if (val >= 0 && val <= goodNumbers) {
					return val;
				} else {
					System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				}

			} catch (NumberFormatException e) {
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				continue;

				// } finally {
				// sc.nextLine(); // För att fånga upp retur-knappen
			}
		}
	}

	public double scanner(double goodNumbers) {
		while (true) {
			try {
				double val = 0;
				val = Double.parseDouble(sc.nextLine());
				if (val >= 0 && val <= goodNumbers) {
					return val;
				} else {
					System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				}

			} catch (NumberFormatException e) {
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				continue;

				// } finally {
				// sc.nextLine(); // För att fånga upp retur-knappen
			}
		}
	}

	public String scanner() {
		while (true) {
			try {
				String val;
				val = sc.nextLine();
				return val;
			}

			catch (NumberFormatException e) {
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				continue;

				// } finally {
				// sc.nextLine(); // För att fånga upp retur-knappen
			}
		}
	}

	public long scanner(long goodNumbers) {
		while (true) {
			try {
				long val = 0;
				val = Long.parseLong(sc.nextLine());
				if (val >= 0 && val <= goodNumbers) {
					return val;
				} else {
					System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				}

			} catch (NumberFormatException e) {
				System.out.println("Detta är dessvärre inte ett giltigt val. Försök igen");
				continue;

				// } finally {
				// sc.nextLine(); // För att fånga upp retur-knappen
			}
		}
	}

}
