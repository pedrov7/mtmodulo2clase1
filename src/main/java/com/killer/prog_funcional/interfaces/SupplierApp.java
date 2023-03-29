package com.killer.prog_funcional.interfaces;

import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierApp {

	private void method1() {
		Supplier<LocalDate> fx = () -> {
			
			return LocalDate.now().minusDays(2);
		};
		
		System.out.println(fx.get());
	}
	

	public static void main(String[] args) {
		SupplierApp app = new SupplierApp();
		
		app.method1();

	}

}
