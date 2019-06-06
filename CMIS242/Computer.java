public class Computer {

	private String manufacturer, modelNum, modelName;
	private int ramSize = 0, coreCount = 0, hddSize = 0;
	private boolean hasDiscreteGpu;

	public Computer(String manufacturer, String modelName, String modelNum, int coreCount, int ramSize, 
		        int hddSize, boolean hasDiscreteGpu) {

		this.manufacturer = manufacturer;
		this.modelName = modelName;
		this.modelNum = modelNum;
		this.coreCount = coreCount;
		this.ramSize = ramSize;
		this.hddSize = hddSize;
		this.hasDiscreteGpu = hasDiscreteGpu;
	
	}

	public String toString(){

		return  "\nManufacturer: " + manufacturer + "\nModel: " + modelName + "\nModel Number: " + modelNum +
			"\nNumber of Processor Cores: " + coreCount + "\nMemory: " + ramSize + " MB" + "\nHard Drive: " +
			hddSize + " GB" + "\nDiscrete Graphics Processing Unit: " + hasDiscreteGpu;

	}
}