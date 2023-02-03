package exps.utils.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthUtilsTest {

	@Test
	void testJwtDecoder() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserId() {
		AuthUtils authUtils = new AuthUtils();
		assertEquals(5,authUtils.getUserId("JWT","TEST"));
	}

}
