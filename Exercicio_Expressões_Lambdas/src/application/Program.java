/*Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.
Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.
Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'.
Veja exemplo na próxima página.*/

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre full path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			List<Employee> list = new ArrayList<>(); 
			
			String line = br.readLine();
			
			while(line != null) {
				String fields[] = line.split(","); //ler a linha e separar por virgulas
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine(); 
			}
			
			System.out.print("Enter the salary: ");
			double salaryComp = sc.nextDouble();
			
			System.out.printf("Email of people whose salary is more than %.2f:\n", salaryComp);
			
			
			// fitrei, comparei os salarios, ordenei e transformei de volta em lista de strings
			List<String> emails = list.stream()
							.filter(x -> x.getSalary() > salaryComp)
							.map(x -> x.getEmail())
							.sorted()
							.collect(Collectors.toList());
			emails.forEach(System.out:: println);
			
			List<Double> salary = list.stream()
							.filter(y -> y.getName().charAt(0) == 'M') //filtra os nomes
							.map(y -> y.getSalary()) //mapeia os salarios
							.collect(Collectors.toList()); //coleta os salários em uma lista
			
			double sumSalary = salary.stream()
							.reduce(0.0, (x,y) -> x+y);
			
			System.out.printf("Sum of salary of people whose name starts with 'M': %.2f\n", sumSalary );
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
