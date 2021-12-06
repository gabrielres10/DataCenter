package model;

public class Server{
	private double amountOfCacheMemory;
	private int amountOfProcessors;
	private double amountOfRamMemory;
	private int amountOfDisks;
	private double disksCapacity;
	private Brand processorsBrand;

	/**
	* This is the constructor method of the Server class
	* @param amountOfCacheMemory, double, this value can be a decimal number and its unit of measurement is GB (GygaByte)
	* @param amountOfProcessors, int, this is the number of processors that the server has
	* @param amountOfRamMemory, double, this is the amount of ram memory which the server works with
	* @param amountOfDisks, int, this is the amount of disks the server works with and it's an integer number
	* @param disksCapacity, double, this is the capacity of the disks. All disks work with the same capacity
	* @param processorsBrand, Brand, this is the brand of the disks. All disks are from the same brand
	*/
	public Server (double amountOfCacheMemory, int amountOfProcessors, double amountOfRamMemory, int amountOfDisks, double disksCapacity, Brand processorsBrand){
		this.amountOfCacheMemory = amountOfCacheMemory;
		this.amountOfProcessors = amountOfProcessors;
		this.amountOfRamMemory = amountOfRamMemory;
		this.disksCapacity = disksCapacity;
		this.processorsBrand = processorsBrand;
	}

	/**
	* Gets the amount of cache memory value
	* @return amountOfCacheMemory, double, this is the cache memory in GB
	*/
	public double getAmountOfCacheMemory (){
		return amountOfCacheMemory;
	}

	/**
	* Sets the amount of cache memory
	* @param amountOfCacheMemory, double, this is the cache memory in GB
	*/
	public void setAmountOfCacheMemory (double amountOfCacheMemory){
		this.amountOfCacheMemory = amountOfCacheMemory;
	}

	/**
	* Gets the amount if processors
	* @return amountOfProcessors, int, this is the amount processors that the server has
	*/
	public int getAmountOfProcessors (){
		return amountOfProcessors;
	}

	/**
	* Sets the amount of processors
	* @param amountOfProcessors, int, this is the amount processors that the server has
	*/
	public void setAmountOfProcessors (int amountOfProcessors){
		this.amountOfProcessors = amountOfProcessors;
	}

	/**
	* Gets the amount of ram memory
	* @return amountOfRamMemory, double, this is the amount of ram memory in GB
	*/
	public double getAmountOfRamMemory (){
		return amountOfRamMemory;
	}

	/**
	* Sets the amount of ram memory
	* @param amountOfRamMemory, double, this is the amount of ram memory in GB
	*/
	public void setAmountOfRamMemory (double amountOfRamMemory){
		this.amountOfRamMemory = amountOfRamMemory;
	}

	/**
	* Gets the amount of disks the server works with
	* @return amountOfDisks, int, this is the amount of disks of the server
	*/
	public int getAmountOfDisks (){
		return amountOfDisks;
	}

	/**
	* Sets the amount of disks the server works with
	* @param amountOfDisks, int, this is the amount of disks of the server
	*/

	public void setAmountOfDisks (int amountOfDisks){
		this.amountOfDisks = amountOfDisks;
	}

	/**
	* Gets the disks capacity
	* @return disksCapacity, double, this is the disks capacity
	*/
	public double getDisksCapacity (){
		return disksCapacity;
	}

	/**
	* Sets the disks capacity
	* @param disksCapacity, double, this is the disks capacity
	*/
	public void setDisksCapacity (double disksCapacity){
		this.disksCapacity = disksCapacity;
	}

	/**
	* Gets the brand of the processors
	* @return processorsBrand, Brand, this is the brand of the processors and it can pnly be AMD or INTEL
	*/
	public Brand getProcessorsBrand (){
		return processorsBrand;
	}

	/**
	* Sets the brand of the processors
	* @param processorsBrand, Brand, this is the brand of the processors and it can pnly be AMD or INTEL
	*/
	public void setProcessorsBrand (Brand processorsBrand){
		this.processorsBrand = processorsBrand;
	}
}