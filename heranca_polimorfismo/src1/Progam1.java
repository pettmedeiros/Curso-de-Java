//Uma empresa possui funcionários próprios e terceirizados.
//Para cada funcionário, deseja-se registrar nome, horas
//trabalhadas e valor por hora. Funcionários terceirizado
//possuem ainda uma despesa adicional.
//O pagamento dos funcionários corresponde ao valor da hora
//multiplicado pelas horas trabalhadas, sendo que os
//funcionários terceirizados ainda recebem um bônus
//correspondente a 110% de sua despesa adicional.
//Fazer um programa para ler os dados de N funcionários (N
//fornecido pelo usuário) e armazená-los em uma lista. Depois
//de ler todos os dados, mostrar nome e pagamento de cada
//funcionario na mesma ordem em que foram digitados.

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Progam1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n =sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if (ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge); // instanciei o empregador
				list.add(emp); // criei um lista e add emp na lista 
			}
			else {
			Employee emp = new Employee(name, hours, valuePerHour);
			list.add(emp);
			}
		}
			System.out.println();
			System.out.println("PAYMENTS:");
			for (Employee emp : list) { // para todo empregador emp na lista fazer algo a baixo
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
			
			}
			
			sc.close();
	}		
	
	}


