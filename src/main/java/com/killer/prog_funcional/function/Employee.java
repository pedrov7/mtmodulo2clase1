package com.killer.prog_funcional.function;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Employee {

	@ToString.Include
	private Integer idEmployee;
	@ToString.Include
	private String name;
	@ToString.Include
	private String job;
	private LocalDate birthDate;
	private double salary;
	@ToString.Include
	private String department;
}
