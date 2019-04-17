package application;

import java.util.Locale;
import java.util.Scanner;

import models.entities.Accont;
import models.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta: ");
		System.out.print("Número da conta: ");
		Integer number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Accont acc =new Accont(number, holder, balance, withdrawLimit);
		
		System.out.println("Entre com o valor do saque: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.print("Saldo atual: R$ " + String.format("%.2f", acc.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Erro no saque: " + e.getMessage());
		}
				
		sc.close();
	}
}