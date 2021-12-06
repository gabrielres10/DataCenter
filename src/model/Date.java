package model;

public class Date {
	private int day;
	private int month;
	private int year;


	/**
	* Constructor method that creates an instance of dates class
	* @param day, int, it is the day of the date (For example: 4)
	* @param month, int, it is the month of the date (For example: 9)
	* @param year, int, it is the year of the date (For example: 2003)
	*/
	public Date(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	* Gets the day
	* @return day, int, day of the date
	*/
	public int getDay() {
		return day;
	}

	/**
	* Sets the day
	* @param day, int, day of the date
	*/
	public void setDay(int day) {
		this.day = day;
	}

	/**
	* Gets the month
	* @return month, int, month of the date
	*/
	public int getMonth() {
		return month;
	}

	/**
	* Sets the month
	* @param month, int, month of the date
	*/
	public void setMonth(int month) {
		this.month = month;
	}


	/**
	* Gets the year
	* @return year, int, year of the date
	*/
	public int getYear() {
		return year;
	}

	/**
	* Sets the year
	* @param year, int, year of the date
	*/
	public void setYear(int year){
		this.year = year;
	}
	
	public String toString(){
		String date = "(MM/dd/Y) " + month + "/" + day + "/" + year;
		return date;
	}
}