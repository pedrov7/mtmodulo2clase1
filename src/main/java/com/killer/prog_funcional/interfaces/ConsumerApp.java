package com.killer.prog_funcional.interfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerApp {

	private void method1() {
		Consumer<String> fx = x -> System.out.println(x);

		fx.accept("Hola mundo, test Pedro");

		Consumer<Integer> fx1 = x -> {
			x = x + 10;
			System.out.println(x);
		};

		fx1.accept(10);
	}

	private void method2() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Consumer<Integer> consumer = x -> {
			x++;
			System.out.println(x);
		};

//		list.forEach(consumer);

		listAll(list, consumer);
	}

	private void listAll(List<Integer> list, Consumer<Integer> fx) {
		list.forEach(fx);
	}

	public static void main(String[] args) {
		ConsumerApp app = new ConsumerApp();
		app.method2();

	}

}
