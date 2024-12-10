package parallelScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
	@Test
	public void testOne() {
		System.out.println("Test31 in SampleThree...");
	}

	@Test
	public void testTwo() {
		System.out.println("Test32 in SampleThree...");
	}

	@Test(groups="FeatureThree")
	public void testThree() {
		System.out.println("Test33 in SampleThree...");
	}

	@Test(groups="FeatureTwo")
	public void testFour() {
		System.out.println("Test34 in SampleThree...");
	}

}
