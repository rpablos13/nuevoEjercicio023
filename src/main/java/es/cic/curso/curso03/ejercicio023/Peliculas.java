package es.cic.curso.curso03;

import com.vaadin.ui.TextField;

public class Peliculas {
	private String firstName;
	private String lastName;
	
	public Peliculas() {
		super();
	}

	public Peliculas(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
