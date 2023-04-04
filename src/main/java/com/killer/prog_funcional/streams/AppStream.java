package com.killer.prog_funcional.streams;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.killer.prog_funcional.function.Employee;

public class AppStream {

	private void m1getDevelopers(List<Employee> list, String searchText) {

		Predicate<Employee> fxPredicate = e -> e.getJob().toLowerCase().contains(searchText);

		List<Employee> newList = list.stream().filter(fxPredicate).collect(Collectors.toList());

		newList.forEach(e -> System.out.println(e));
	}

	private void m2getInverseList(List<Employee> list) {
		Comparator<Employee> inverso = (x1, x2) -> x2.getIdEmployee() - x1.getIdEmployee();

		list.stream().sorted(inverso).forEach(System.out::println);
	}
	
	private void m3getAdults(List<Employee> list) {
		Predicate<Employee> isAdult = e-> Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;
		list.stream()
			.filter(isAdult)
			.forEach(System.out::println);
	}
	
	private void m4getOldestAdult(List<Employee> list) {
		list.stream()
				.sorted(Comparator.comparing(Employee::getBirthDate))  //e -> e.getBirthDate()
				.limit(1)
				.forEach(System.out::println);
	}
	
	private void m5getMaxMinSalary(List<Employee> list) {
		double max = list.stream()
			.mapToDouble(e->e.getSalary())
			.max()
			.orElse(0);
		System.out.println("Max salary ->" + max);
		
		double min = list.stream()
				.mapToDouble(e->e.getSalary())
				.min()
				.orElse(0);
			System.out.println("Min salary -> " + min);
	}

	public static void main(String[] args) {
		AppStream app = new AppStream();

		Employee e1 = new Employee(1, "John Smith", "Senior Java Developer", LocalDate.of(1990, 4, 15), 100.00, "fe");
		Employee e2 = new Employee(2, "Sarah Lee", "Java Developer", LocalDate.of(2011, 12, 31), 80.00, "BE");
		Employee e3 = new Employee(3, "Michael Johnson", "Java Architect", LocalDate.of(2004, 7, 1), 120.00,
				"Full Stack");
		Employee e4 = new Employee(4, "Emily Wong", "Java Software Engineer", LocalDate.of(2000, 2, 14), 85.00,
				"Mobile");
		Employee e5 = new Employee(5, "David Chen", "Junior Java Developer", LocalDate.of(2026, 9, 3), 60.00, "Web");
		Employee e6 = new Employee(6, "Jennifer Kim", "Senior Java Software Engineer", LocalDate.of(2010, 5, 22),
				110.00, "Game");
		Employee e7 = new Employee(7, "Andrew Davis", "Java Team Lead", LocalDate.of(2028, 11, 11), 130.00, "DevOps");
		Employee e8 = new Employee(8, "Stephanie Lee", "Java Developer", LocalDate.of(2015, 8, 8), 75.00,
				"Cloud Computing");
		Employee e9 = new Employee(9, "Jason Kim", "Java Full Stack Developer", LocalDate.of(1993, 1, 1), 95.00,
				"Cybersecurity");
		Employee e10 = new Employee(10, "Rebecca Lee", "Senior Java Developer", LocalDate.of(2003, 6, 20), 105.00,
				"SQA");

		List<Employee> list = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

//		app.m1getDevelopers(list, "java developer");
//		app.m2getInverseList(list);
//		app.m3getAdults(list);
//		app.m4getOldestAdult(list);
		app.m5getMaxMinSalary(list);

	}

}
