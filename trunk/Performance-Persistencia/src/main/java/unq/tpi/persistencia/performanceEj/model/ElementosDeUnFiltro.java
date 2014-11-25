package unq.tpi.persistencia.performanceEj.model;

public class ElementosDeUnFiltro {
	
    private String firstName;
    private String titles;
    private int salary;


    public String getTitles() {
		return titles;
	}

	public void setTitles(String title) {
		this.titles = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
}