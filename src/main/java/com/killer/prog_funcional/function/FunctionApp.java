package com.killer.prog_funcional.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionApp {

	private void m1apply() {
		Function<String, Integer> fx = x -> x.length();
		Integer answer = fx.apply("mitocode");
		System.out.println(answer);
	}

	private void m2AndThen() {
		Function<String, Integer> fx1 = x -> x.length();
		Function<Integer, Integer> fx2 = x -> x + 10;

		Integer answerInteger = fx1.andThen(fx2).apply("mitocode");
		System.out.println(answerInteger);

	}

	private void m2AndThenV2() {
		Function<Integer, Integer> fx1 = x -> x * 2;
		Function<Integer, Integer> fx2 = x -> x + 10;

		Integer answerInteger = fx1.andThen(fx2).apply(5);
		System.out.println(answerInteger);

	}

	private void m3Compose() {
		Function<Integer, Integer> fx1 = x -> x * 2;
		Function<Integer, Integer> fx2 = x -> x + 10;

		Integer answer = fx1.compose(fx2).apply(5);
		System.out.println(answer);
	}

	private void m4Identity() {
		// f(x) = x;
		Function<Employee, Employee> fx = Function.identity();
		System.out.println(fx.apply(new Employee()));
	}

	private void m5Identity() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Pedro", "teacher", LocalDate.now(), 999.99, "TI"));
		list.add(new Employee(2, "Killer", "developer", LocalDate.now(), 509.00, "DevOps"));
		list.add(new Employee(3, "Esteban", "engineer", LocalDate.now(), 1000.00, "QA"));

//		Map<Integer, Employee> map = list.stream()
//				.collect(Collectors.toMap(e -> e.getIdEmployee(), Function.identity())); //t -> t

//		↓↓↓↓ esto se puede escribir de la siguiente manera usando metodos de referencia [ :: ]
//														↓↓↓↓
		Map<Integer, Employee> map = list.stream()
				.collect(Collectors.toMap(Employee::getIdEmployee, Function.identity())); // t -> t

		System.out.println(map);
	}

	private void m6Identity() {
		Function<Integer, Integer> f1 = Function.identity();
		Function<Integer, Integer> f2 = Function.identity();
		Function<Integer, Integer> f3 = Function.identity();

		Function<Integer, Integer> f4 = t -> t;
		Function<Integer, Integer> f5 = t -> t;
		Function<Integer, Integer> f6 = t -> t;
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println("-----------------------------------------------------");
		System.out.println(f4);
		System.out.println(f5);
		System.out.println(f6);
		
	}

	public static void main(String[] args) {
		FunctionApp functionApp = new FunctionApp();

		functionApp.m6Identity();
	}

}
