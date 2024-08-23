import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.MayTinh;

class TestMayTinh {

	@Test
	void testphepCong() {
		assertEquals(15, MayTinh.cong(10, 5),0.01);
	}
	
	@Test
	void testphepTru() {
		/**
		 * aaaaaaaaa
		 */
		assertEquals(15, MayTinh.tru(20, 5),0.01);
	}

}
