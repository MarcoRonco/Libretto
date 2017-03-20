package it.polito.tdp.libretto.model;

import java.time.LocalDate;
/*
 * separo test e classe perchè cosi posso usare solo i metodi pubblici
 * marco è bello!!!!!
 */
public class TestEsame {

	public static void main(String[] args) {
		Esame tdp = new Esame("nadgf", "tecn", "fulvio");
		System.out.println(tdp);
		Esame ami = new Esame("guaeibg", "aisfon", "culo");
		System.out.println(ami.equals(tdp));
		tdp.Supera(30, LocalDate.now());
		System.out.println(tdp);
	}

}
