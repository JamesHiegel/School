package github.io.jameshiegel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VirtualMemorySimulatorTest {

	@Test
	public void commandLineArgumentTwoArguments()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () ->
		VirtualMemorySimulator.main(new String[] { "1 2" }));	}
	
	@Test
	public void commandLineArgumentNonInteger()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () ->
				VirtualMemorySimulator.main(new String[] { "x" }));
	}
	
	@Test
	public void commandLineArgumentLessThanOne()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () ->
		VirtualMemorySimulator.main(new String[] { "0" }));
	}
	
	@Test
	public void commandLineArgumentGreaterThanSeven()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () ->
		VirtualMemorySimulator.main(new String[] { "8" }));
	}
	
	@Test
	public void commandLineArgumentValid()
	{
		VirtualMemorySimulator.main(new String[] { "4" });
	}
	
}
