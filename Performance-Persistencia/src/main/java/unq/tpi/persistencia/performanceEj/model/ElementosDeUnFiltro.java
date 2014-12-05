package unq.tpi.persistencia.performanceEj.model;

import java.util.ArrayList;
import java.util.List;

public class ElementosDeUnFiltro {	
	
    private  String firstName;
    private  String lastName;
    private List<String> titles = new ArrayList<String>();
    private double amount = 0.0;
    
    public String fullName(){
    	return this.firstName + " " + this.lastName;
    }

    public List<String> getTitles() {
		return titles;
	}

	public void setTitles(String title) {
		this.titles.add(title);
	}

	public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}