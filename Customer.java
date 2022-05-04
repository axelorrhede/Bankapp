import java.util.ArrayList;

public class Customer {
	private String name;
	private Long idNr;
	private int customerNbr;

	public Customer(String name, Long idNr) {
		this.name = name;
		this.idNr = idNr;
		createCustomer(); 

	}

	public void createCustomer() { // Söker igenom listan och kontrollerar så att användaren inte redan finns. Ger
									// ett fel om användarnen redan finns annars lägger till användaren i listan;
		ArrayList
		

	}

	public String getString() {
		return this.name;
	}

	public Long getidNr() {
		return this.idNr;
	}

	public int getcustomerNbr() {
		return this.customerNbr;
	}

}
