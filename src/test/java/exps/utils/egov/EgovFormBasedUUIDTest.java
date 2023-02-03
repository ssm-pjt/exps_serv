/**
 * @Test
 * 		메서드 레벨에 작성하고, 해당 메서드를 테스트하겠다는 뜻입니다. 
 * 		해당 메서드를 독립적으로 테스트하며
 * 
 * @BeforeEach, AfterEach
 * 		BeforeEach, AfterEach는 
 * 		각각 @Test메서드가 실행되기 전, 실행되고 나서 실행하는 메서드입니다
 * 
 * @BeforeAll, AfterAll
 * 		현재 클래스에서 모든 @Test를 실행되기 전, 실행되고 나서 실행됩니다. 
 * 		Each와 All에서 알 수 있듯 만약 클래스 전체를 테스트 run할 경우 XXXEach는 각 테스트가 한번 실행될 때 마다 작동하며, 
 * 		XXXAll은 클래스를 실행하기 전혹은 후 딱 한번만 작동합니다. 
 * 		이 때, 주의해야할 사항은 XXXAll을 사용시에 메서드는 static이어야 합니다.
 * 
 * @Ignore
 * 		@Ignore 어노테이션을 선언하면 테스트를 Skip한다.
 * 
		assertArrayEquals(a, b) :  배열 A와 B가 일치함을 확인한다.
		assertEquals(a, b) : 객체 A와 B가 같은 값을 가지는지 확인한다.
		assertEquals(a, b, c) :  객체 A와 B가 값이 일치함을 확인한다.( a: 예상값, b:결과값, c: 오차범위)
		assertSame(a, b) : 객체 A와 B가 같은 객체임을 확인한다.
		assertTrue(a): 조건 A가 참인지 확인한다.
		assertNotNull(a) : 객채 A가 null이 아님을 확인한다.
	참조
	https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations
 */
package exps.utils.egov;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EgovFormBasedUUIDTest {

	@Test
	void testRandomUUID() {
		log.info("randomUUID ::",EgovFormBasedUUID.randomUUID());
	}

}
