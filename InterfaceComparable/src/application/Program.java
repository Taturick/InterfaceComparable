package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String path = "C:\\Users\\55169\\Documents\\in.txt";
		String path2 = "C:\\Users\\55169\\Documents\\in2.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String name = br.readLine();
			while (name != null) {
				list.add(name);
				name = br.readLine();
			}
			Collections.sort(list);
			for (String s : list) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println();

		List<Employee> list2 = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path2))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list2.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}

			// Ordenar por nome em ordem crescente
			Collections.sort(list2, new Comparator<Employee>() {
				@Override
				public int compare(Employee emp1, Employee emp2) {
					return emp1.getName().compareTo(emp2.getName());
				}
			});

			System.out.println("Lista ordenada por nome:");
			for (Employee emp : list2) {
				System.out.println(emp.getName() + "," + emp.getSalary());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println();

		List<Employee> list3 = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path2))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list3.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}

			// Ordenar por salário em ordem crescente
			Collections.sort(list3, new Comparator<Employee>() {
				@Override
				public int compare(Employee emp1, Employee emp2) {
					return emp1.getSalary().compareTo(emp2.getSalary());
				}
			});

			System.out.println("Lista ordenada por salário:");
			for (Employee emp : list3) {
				System.out.println(emp.getName() + "," + emp.getSalary());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
