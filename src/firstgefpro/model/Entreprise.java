package firstgefpro.model;

/**
 * Entreprise.java
 * @author Shashwat Anand
 * @version $Id: $
 * @since Feb 26, 2014
 */
public class Entreprise extends Node {
	private String address;
	
	private int capital;

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
