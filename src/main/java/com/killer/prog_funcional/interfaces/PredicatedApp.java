package com.killer.prog_funcional.interfaces;

import java.util.function.Predicate;

public class PredicatedApp {

	private void method1() {
		// recibes un tipo y devuelve un booleano
		Predicate<Integer> checkAgeNumber = x -> x >= 18;
		boolean answer = checkAgeNumber.test(32);
		System.out.println(answer);
	}

	private void method2() {
		Predicate<Integer> mayorQue = x -> x > 10;
		Predicate<Integer> menorQue = x -> x < 10;

		boolean answer = mayorQue.and(menorQue).test(32);

		System.out.println(answer);
	}

	private void method3(int num, Predicate<Integer> fx) {
		boolean answer = fx.test(num);

		System.out.println(answer);
	}

	
	
	public static void main(String[] args) {
		PredicatedApp app = new PredicatedApp();
		Predicate<Integer> fx1 = x -> x > 95;
		app.method3(15, fx1);
	}

}
