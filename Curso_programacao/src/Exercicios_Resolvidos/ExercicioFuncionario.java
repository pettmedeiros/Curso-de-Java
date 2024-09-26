package Exercicios_Resolvidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.FuncionarioEx;

public class ExercicioFuncionario {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List<FuncionarioEx> list = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println("Emplyoee #" + (i + 1)+ ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			sc.nextLine();
			
			FuncionarioEx emp = new FuncionarioEx(id, name, salary);
			list.add(emp);
		}
		
		System.out.println("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		Integer pos = position(list, idsalary);
		if (pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentage: ");
			int percent = sc.nextInt();
			list.get(pos).increaseSalary(percent);			
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for (FuncionarioEx emp : list) {
			System.out.println(emp);
		}
			
			
		
		
		sc.close();
		}
		
	public static Integer position(List<FuncionarioEx> list, int id) {
		for (int i=0; i< list.size(); i++) {
			if (list.get(i).getId() == id) { // classe alternativa para poder encontrar o funcionario
				return i;
			}
		}
		return null;
	}
		
		
	}


