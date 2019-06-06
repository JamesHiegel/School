public class TestComputer {

	public static void main(String[] args) {

		Computer comp1 = new Computer("Hewlett-Packard", "Spectre", "x2 Extreme", 2, 4096, 500, false);
		Laptop laptop1 = new Laptop("Sony", "VAIO", "VA9200xl", 4, 8192, 1000, false, false, true, 15.6);
		Desktop desktop1 = new Desktop("Dell", "XPS 700", "X700t", 8, 16384, 1000, true, "Full Tower", false, true, true, 27);

		System.out.println(comp1.toString());
		System.out.println(laptop1.toString());
		System.out.println(desktop1.toString());
		
	}

}