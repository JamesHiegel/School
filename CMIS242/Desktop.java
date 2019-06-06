public class Desktop extends Computer {


	private boolean hasDvd, hasBluray, includesMonitor;
	private String towerType;
	private double monitorSize;

	public Desktop(String manufacturer, String modelName, String modelNum, int coreCount, int ramSize,
			 int hddSize, boolean hasDiscreteGpu, String towerType, boolean hasDvd, boolean hasBluray,
			 boolean includesMonitor, double monitorSize) {

		super(manufacturer, modelName, modelNum, coreCount, ramSize, hddSize, hasDiscreteGpu);
		this.towerType = towerType;
		this.hasDvd = hasDvd;
		this.hasBluray = hasBluray;
		this.includesMonitor = includesMonitor;
		this.monitorSize = monitorSize;
	
	}	

	@Override
	public String toString(){

		return super.toString() + "\nTower Type: " + towerType + "\nDVD Player: " + hasDvd + "\nBluray Player: " + hasBluray +
			"\nIncludes Monitor: " + includesMonitor + "\nMonitor Size: " + monitorSize + " inches";

	}

}