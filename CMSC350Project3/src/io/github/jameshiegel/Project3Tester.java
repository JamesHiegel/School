package io.github.jameshiegel;

import static org.junit.Assert.*;

import org.junit.Test;

public class Project3Tester {

	@Test
	public void IntegerNodeValueTestWithString() {
		IntegerNode integerTestNode = new IntegerNode("12");
		assertEquals("12", integerTestNode.inOrderWalk());
	}

	@Test
	public void IntegerNodeValueTestWithInteger() {
		IntegerNode integerTestNode = new IntegerNode(12);
		assertEquals("12", integerTestNode.inOrderWalk());
	}
	
	@Test
	public void IntegerNodeGetDoubleTest() {
		IntegerNode integerTestNode = new IntegerNode(12);
		assertEquals((double) 12, integerTestNode.getDoubleValue(), 0.001);
	}
	
	@Test
	public void FractionNodeValueTest() {
		FractionNode fractionTestNode = new FractionNode("1/2");
		assertEquals("1/2", fractionTestNode.inOrderWalk());
	}
	
	@Test
	public void FractionNodeGetDoubleSmallFractionTest() {
		FractionNode fractionTestNode = new FractionNode("1/2");
		assertEquals(0.5, fractionTestNode.getDoubleValue(), 0.001);
	}
	
	@Test
	public void FractionNodeGetDoubleLargeFractionTest() {
		FractionNode fractionTestNode = new FractionNode("31/32");
		assertEquals((double) 31 / 32, fractionTestNode.getDoubleValue(), 0.001);
	}
}
