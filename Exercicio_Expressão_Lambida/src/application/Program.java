/*Fazer um programa para ler um conjunto de produtos a partir de um
arquivo em formato .csv (suponha que exista pelo menos um produto).
Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
nomes, em ordem decrescente, dos produtos que possuem preço
inferior ao preço médio.*/


package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter full file path: ");
		String path = sc.next();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Product> list = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(","); 
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();				
			}
			
			double avg = list.stream() 
					.map(p -> p.getPrice()) //Isso converte a lista de objetos em uma lista de preços (que são valores do tipo double).
					.reduce(0.0, (x,y) -> x + y) / list.size();//O método reduce é usado para somar os preços.
			
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			// A lista (list.stream) é transformada em um Stream.
			//Um stream permite processar elementos de uma coleção de forma sequencial ou paralela.
			// O método map transforma cada elemento do stream.
			
			//O objetivo desse comparador é comparar duas strings (s1 e s2) de forma insensível a maiúsculas/minúsculas.
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream()
					.filter(p -> p.getPrice() < avg) //filtra os elementos da lista, mantendo apenas os objetos cujo preço (p.getPrice()) seja menor que a média (avg).
					.map(p -> p.getName()).sorted(comp.reversed()) //Após o filtro, o método map transforma o stream de objetos em um stream de strings, extraindo o nome de cada objeto com p.getName().
					.collect(Collectors.toList()); //sorted = Ordena a lista de nomes. reversed = de forma decrescente
												   // collectors = Converte o stream filtrado e ordenado em uma lista de strings (List<String>).
			names.forEach(System.out::println);
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		sc.close();

	}

}
