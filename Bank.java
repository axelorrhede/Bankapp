import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> BankAccounts;

	public Bank() {
		BankAccounts = new ArrayList<BankAccount>();
	}

	public int addAccount(String holderName, long idNr) {
		for (BankAccount account : BankAccounts) {
			if (account.isHolder(idNr)) {
				return account.getAccountNumber();
			}
		}
		BankAccount newAccount = new BankAccount(holderName, idNr);
		BankAccounts.add(newAccount);
		return newAccount.getAccountNumber();
		
	}

	public Customer findHolder(long idNr) {
		for (BankAccount account : BankAccounts) {
			if (account.isHolder(idNr)) {
				return account.getHolder();
			}
		}
		return null;
	}

	public boolean removeAccount(int number) {
		for (BankAccount account : BankAccounts) {
			if (account.getAccountNumber() == number) {
				BankAccounts.remove(account);
				return true;
			}
		}
		return false;

	}

	ArrayList<BankAccount> getAllAccounts() {
		BankAccount account;
		for (int i = 0; i < BankAccounts.size(); i++) {
			for (int k = i; k < BankAccounts.size(); k++) { // sus
				if (compareStrings(BankAccounts.get(k).getHolder().getString(),
						BankAccounts.get(i).getHolder().getString())) {
					account = BankAccounts.get(k);
					BankAccounts.remove(k);
					BankAccounts.add(i, account);
				}
			}
		}
		return BankAccounts;
	}

	private boolean compareStrings(String p1, String p2) {
		int min = Math.min(p1.length() , p2.length())
		for (int i = 0; i < min; i++) {
			if (p1.charAt(i) < p2.charAt(i)) {
				return true;
			}
			if (p1.charAt(i) > p2.charAt(i)) {
				return false;

			}
		}
		return p1.length() < p2.length()
	}

	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount account : BankAccounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	ArrayList<BankAccount> findAccountsForHolder(long idNr){
		ArrayList<BankAccount> sameCustomer= new ArrayList<BankAccount>();
		for (BankAccount account : BankAccounts) {
			if (account.isHolder(idNr)) {
				sameCustomer.add(account);
			}
		}
		return sameCustomer;
	}

}
