package unit_test_assignment;

import java.util.Random;

public class TestDemo {
	private Random random = new Random();

	int addPositive(int a, int b) {
		
		if(a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
		return a + b;
	}
	
	public int randomNumberSquared() {
		 int s = getRandomInt();
		System.out.println(s * s);
		return s * s;
		
	}

	int getRandomInt() {
		return random.nextInt(10) + 1;
	
	}
	public static void main(String[] args) {
		new TestDemo().randomNumberSquared();
	}
	
}
