package model;

public class Company{
	private String nit;
	private String name;


	/**
	* @param nit, this is the tributary code of the company
	* @param name, this is the name of the company
	*/
	public Company (String nit, String name){
		this.nit = nit;
		this.name = name;
	}

	/**
	* Gets the nit of the company
	* @return nit, String, this is the tributary code of the company
	*/
	public String getNit (){
		return nit;
	}

	/**
	* Sets the nit of the company
	* @param nit, String, this is the tributary code of the company
	*/
	public void setNit (String nit){
		this.nit = nit;
	}

	/**
	* Gets the name of the company
	* @return name, String, name of the company
	*/
	public String getName (){
		return name;
	}

	/**
	* Sets the name of the company
	* @param name, String, name of the company
	*/
	public void setName (String name){
		this.name = name;
	}

	/**
	* Creates a String with the information of a company
	* @return company, String, variable that contains the information of the company
	*/
	public String toString() {
		String company = "   Name of the company: " + name + "\n"
		 	+ "   NIT of the company: " + nit;
		return company;
	}
}