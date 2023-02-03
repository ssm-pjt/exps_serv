package exps.utils.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AES256UtilTest {

	@Test
	void testEncrypt() {
		AES256Util aesutil = new AES256Util();
		assertEquals("Pi7jgd4TDhozG7hIk/RejA==",aesutil.encrypt("TEST"));
	}

	@Test
	void testDecrypt() {
		AES256Util aesutil = new AES256Util();
		assertEquals("TEST",aesutil.decrypt("Pi7jgd4TDhozG7hIk/RejA=="));
	}

}
