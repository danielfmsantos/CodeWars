package kyu8;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ToBinaryTests {
	
	private int toBinary(int n) {
		return ToBinary.toBinary(n);
	}
	
    @Test
    public void testToBinary() {
  		assertEquals(1, toBinary(1));
  		assertEquals(10, toBinary(2));
  		assertEquals(11, toBinary(3));
  		assertEquals(101, toBinary(5));
    }
}