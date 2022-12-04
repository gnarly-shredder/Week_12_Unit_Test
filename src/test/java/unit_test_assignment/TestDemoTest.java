package unit_test_assignment;

import static org.assertj.core.api.Assertions.assertThat;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)

class TestDemoTest {
	
	private TestDemo testDemo = new TestDemo();

	@BeforeEach
	void init() {
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	@MethodSource("unit_test_assignment.TestDemoTest#parmsForAddedCorrectly")
	void assertThatTwoPositiveNumbersAreAddedCorrectly (int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			int actual = testDemo.addPositive(a, b);
			  assertThat(actual).isEqualTo(expected);
			}
		else {
		assertThatThrownBy(() -> 
	    testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> parmsForAddedCorrectly() {
		return Stream.of(
		arguments(5, 5, 10, false),
		arguments(5, 0, 5, true),
		arguments(1, 1, 2, false),
		arguments(0, -12, -12, true)
		);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo testDem = spy(testDemo);
		
		int a = 5;
		int expected = a * a;
		
		doReturn(a).when(testDem).getRandomInt();
		
		int actual = testDem.randomNumberSquared();
		
		assertThat(actual).isEqualTo(expected);
		
	}

}


















