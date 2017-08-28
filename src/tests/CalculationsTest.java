package tests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.Calculations;
import src.GraphDensity;

public class CalculationsTest {

	/**
	 * Get Random Vertex Test.
	 */

	@Test(expected = InvalidParameterException.class)
	public void testGetRandomVertexIndexNegOneValue() {
		Calculations.getRandomVertexIndex(-1);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testGetRandomVertexIndexZeroValue() {
		Calculations.getRandomVertexIndex(0);
	}
	
	@Test
	public void testGetRandomVertexIndexOneValue() {
		assertEquals(0, Calculations.getRandomVertexIndex(1));
	}

	@Test
	public void testGetRandomVertexIndexTwoValue() {
		int actual = Calculations.getRandomVertexIndex(2);
		assertTrue(0<= actual && actual <= 1);
	}
	
	@Test
	public void testGetRandomVertexIndexThreeValue() {
		int actual = Calculations.getRandomVertexIndex(3);
		assertTrue(0<= actual && actual <= 2);
	}
	
	/**
	 * Get Random Vertex Exclusive Test.
	 */
	
	@Test
	public void testGetRandomVertexIndexExcludingThreeValueExcludeZero() {
		int actual = Calculations.getRandomVertexIndexExcluding(3, 0);
		assertTrue(1<= actual && actual <= 2);
	}
	
	@Test
	public void testGetRandomVertexIndexExcludingThreeValueExcludeOne() {
		int actual = Calculations.getRandomVertexIndexExcluding(3, 1);
		assertTrue(0<= actual && actual <= 0 || 2 <= actual && actual <=2);
	}

	@Test
	public void testGetRandomVertexIndexExcludingThreeValueExcludeTwo() {
		int actual = Calculations.getRandomVertexIndexExcluding(3, 1);
		assertTrue(0<= actual && actual <= 1);
	}
	
	/**
	 * Get Random Weight
	 */

	@Test(expected = InvalidParameterException.class)
	public void testGetRandomWeightMinGreaterThanMax() {
		Calculations.getRandomWeight(1, 0);
	}

	@Test(expected = InvalidParameterException.class)
	public void testGetRandomWeightMinLessThanZero() {
		Calculations.getRandomWeight(-1, 0);
	}

	@Test(expected = InvalidParameterException.class)
	public void testGetRandomWeightMaxLessThanZero() {
		Calculations.getRandomWeight(0, -1);
	}

	@Test(expected = InvalidParameterException.class)
	public void testGetRandomWeightMinAndMaxLessThanZero() {
		Calculations.getRandomWeight(-1, -1);
	}

	@Test
	public void testGetRandomWeightMinEqualToMaxZero() {
		int actual = Calculations.getRandomWeight(0, 0);
		assertEquals(0, actual);
	}

	@Test
	public void testGetRandomWeightMinEqualToMaxOne() {
		int actual = Calculations.getRandomWeight(1, 1);
		assertEquals(1, actual);
	}

	@Test
	public void testGetRandomWeightMinLessThanMax() {
		int actual = Calculations.getRandomWeight(1, 10);
		assertTrue(1 <= actual && actual <= 10);
	}

	/**
	 * Min Tests
	 */

	@Test
	public void testGetMinEdgesNegOneValue() {
		assertEquals(0, Calculations.getMinEdges(-1));
	}

	@Test
	public void testGetMinEdgesZeroValue() {
		assertEquals(0, Calculations.getMinEdges(1));
	}

	@Test
	public void testGetMinEdgesOneValue() {
		assertEquals(0, Calculations.getMinEdges(1));
	}

	@Test
	public void testGetMinEdgesTwoValue() {
		assertEquals(1, Calculations.getMinEdges(2));
	}

	/**
	 * Max Tests
	 */

	@Test
	public void testGetMaxEdgesNegOneValue() {
		assertEquals(0, Calculations.getMaxEdges(-1));
	}

	@Test
	public void testGetMaxEdgesZeroValue() {
		assertEquals(0, Calculations.getMaxEdges(0));
	}

	@Test
	public void testGetMaxEdgesOneValue() {
		assertEquals(0, Calculations.getMaxEdges(1));
	}

	@Test
	public void testGetMaxEdgesTwoValue() {
		assertEquals(1, Calculations.getMaxEdges(2));
	}

	/**
	 * Quartile 1 test.
	 */

	@Test
	public void testgetQuartileOneNumbEdgesNegOneValue() {
		assertEquals(0, Calculations.getQuartileOneNumbEdges(-1));
	}

	@Test
	public void testgetQuartileOneNumbEdgesZeroValue() {
		assertEquals(0, Calculations.getQuartileOneNumbEdges(0));
	}

	@Test
	public void testgetQuartileOneNumbEdgesOneValue() {
		assertEquals(0, Calculations.getQuartileOneNumbEdges(1));
	}

	@Test
	public void testgetQuartileOneNumbEdgesTwoValue() {
		assertEquals(1, Calculations.getQuartileOneNumbEdges(2));
	}

	@Test
	public void testgetQuartileOneNumbEdgesThreeValue() {
		assertEquals(2, Calculations.getQuartileOneNumbEdges(3));
	}

	@Test
	public void testgetQuartileOneNumbEdgesFourValue() {
		assertEquals(4, Calculations.getQuartileOneNumbEdges(4));
	}

	@Test
	public void testgetQuartileOneNumbEdgesFiveValue() {
		assertEquals(5, Calculations.getQuartileOneNumbEdges(5));
	}

	@Test
	public void testgetQuartileOneNumbEdgesSixValue() {
		assertEquals(7, Calculations.getQuartileOneNumbEdges(6));
	}

	/**
	 * Quartile 2 test.
	 */

	@Test
	public void testgetQuartileTwoNumbEdgesNegOneValue() {
		assertEquals(0, Calculations.getQuartileTwoNumbEdges(-1));
	}

	@Test
	public void testgetQuartileTwoNumbEdgesZeroValue() {
		assertEquals(0, Calculations.getQuartileTwoNumbEdges(0));
	}

	@Test
	public void testgetQuartileTwoNumbEdgesOneValue() {
		assertEquals(0, Calculations.getQuartileTwoNumbEdges(1));
	}

	@Test
	public void testgetQuartileTwoNumbEdgesTwoValue() {
		assertEquals(1, Calculations.getQuartileTwoNumbEdges(2));
	}

	@Test
	public void testgetQuartileTwoNumbEdgesThreeValue() {
		assertEquals(3, Calculations.getQuartileTwoNumbEdges(3));
	}

	@Test
	public void testgetQuartileTwoNumbEdgesFourValue() {
		assertEquals(5, Calculations.getQuartileTwoNumbEdges(4));
	}

	@Test
	public void testgetQuartileTwoNumbEdgesFiveValue() {
		assertEquals(7, Calculations.getQuartileTwoNumbEdges(5));
	}

	/**
	 * Quartile 3 test.
	 */

	@Test
	public void testgetQuartileThreeNumbEdgesNegOneValue() {
		assertEquals(0, Calculations.getQuartileThreeNumbEdges(-1));
	}

	@Test
	public void testgetQuartileThreeNumbEdgesZeroValue() {
		assertEquals(0, Calculations.getQuartileThreeNumbEdges(0));
	}

	@Test
	public void testgetQuartileThreeNumbEdgesOneValue() {
		assertEquals(0, Calculations.getQuartileThreeNumbEdges(1));
	}

	@Test
	public void testgetQuartileThreeNumbEdgesTwoValue() {
		assertEquals(1, Calculations.getQuartileThreeNumbEdges(2));
	}

	@Test
	public void testgetQuartileThreeNumbEdgesThreeValue() {
		assertEquals(3, Calculations.getQuartileThreeNumbEdges(3));
	}

	@Test
	public void testgetQuartileThreeNumbEdgesFourValue() {
		assertEquals(5, Calculations.getQuartileThreeNumbEdges(4));
	}

	@Test
	public void testgetQuartileThreeNumbEdgesFiveValue() {
		assertEquals(8, Calculations.getQuartileThreeNumbEdges(5));
	}

	/**
	 * Test Range Generator for Sparce Graph.
	 */

	@Test
	public void testgetRandomEdgeFromRangeSparceVertexOne() {
		int actual = Calculations.getRandomEdgeFromRange(1, GraphDensity.SPARCE);
		assertEquals(0, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeSparceVertexTwo() {
		int actual = Calculations.getRandomEdgeFromRange(2, GraphDensity.SPARCE);
		assertEquals(1, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeSparceVertexThree() {
		int actual = Calculations.getRandomEdgeFromRange(3, GraphDensity.SPARCE);
		assertEquals(2, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeSparceVertexFour() {
		int actual = Calculations.getRandomEdgeFromRange(4, GraphDensity.SPARCE);
		assertEquals(3, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeSparceVertexFive() {
		int actual = Calculations.getRandomEdgeFromRange(5, GraphDensity.SPARCE);
		assertEquals(4, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeSparceVertexTen() {
		int actual = Calculations.getRandomEdgeFromRange(10, GraphDensity.SPARCE);
		assertTrue(9 <= actual && actual <= 17);
	}

	/**
	 * Test Range Generator for Medium Graph.
	 */

	@Test
	public void testgetRandomEdgeFromRangeMediumVertexOne() {
		int actual = Calculations.getRandomEdgeFromRange(1, GraphDensity.MEDIUM);
		assertEquals(0, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeMediumVertexTwo() {
		int actual = Calculations.getRandomEdgeFromRange(2, GraphDensity.MEDIUM);
		assertEquals(1, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeMediumVertexThree() {
		int actual = Calculations.getRandomEdgeFromRange(3, GraphDensity.MEDIUM);
		assertTrue(2 <= actual && actual <= 3);
	}

	@Test
	public void testgetRandomEdgeFromRangeMediumVertexFour() {
		int actual = Calculations.getRandomEdgeFromRange(4, GraphDensity.MEDIUM);
		assertTrue(4 <= actual && actual <= 5);
	}

	@Test
	public void testgetRandomEdgeFromRangeMediumVertexFive() {
		int actual = Calculations.getRandomEdgeFromRange(5, GraphDensity.MEDIUM);
		assertTrue(5 <= actual && actual <= 8);
	}

	@Test
	public void testgetRandomEdgeFromRangeMediumVertexTen() {
		int actual = Calculations.getRandomEdgeFromRange(10, GraphDensity.MEDIUM);
		assertTrue(18 <= actual && actual <= 36);
	}

	/**
	 * Test Range Generator for Dense Graph.
	 */

	@Test
	public void testgetRandomEdgeFromRangeDenseVertexOne() {
		int actual = Calculations.getRandomEdgeFromRange(1, GraphDensity.DENSE);
		assertEquals(0, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeDenseVertexTwo() {
		int actual = Calculations.getRandomEdgeFromRange(2, GraphDensity.DENSE);
		assertEquals(1, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeDenseVertexThree() {
		int actual = Calculations.getRandomEdgeFromRange(3, GraphDensity.DENSE);
		assertEquals(3, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeDenseVertexFour() {
		int actual = Calculations.getRandomEdgeFromRange(4, GraphDensity.DENSE);
		assertEquals(6, actual);
	}

	@Test
	public void testgetRandomEdgeFromRangeDenseVertexFive() {
		int actual = Calculations.getRandomEdgeFromRange(5, GraphDensity.DENSE);
		assertTrue(9 <= actual && actual <= 10);
	}

	@Test
	public void testgetRandomEdgeFromRangeDenseVertexTen() {
		int actual = Calculations.getRandomEdgeFromRange(10, GraphDensity.DENSE);
		assertTrue(37 <= actual && actual <= 45);
	}

}
