package models.entities;

import models.exceptions.DomainException;

public class Accont {

	private Integer number;	
	private String holder;
	private Double balance;
	private Double withdrawLimit;
		
		public Accont() {
			
		}
		public Accont(Integer number, String holder, Double balance, Double withdrawLimit) {
			this.number = number;
			this.holder = holder;
			this.balance = balance;
			this.withdrawLimit = withdrawLimit;
		}
		public Integer getNumber() {
			return number;
		}
		public String getHolder() {
			return holder;
		}
		public void setHolder(String holder) {
			this.holder = holder;
		}
		public Double getBalance() {
			return balance;
		}
		
		public Double getWithdrawLimit() {
			return withdrawLimit;
		}
		public void setWithdrawLimit(Double withdrawLimit) {
			this.withdrawLimit = withdrawLimit;
		}
		public void deposit (Double amount) {
			balance += amount;
		}
		public void withdraw (Double amount) {
			if (amount > withdrawLimit) {
				throw new DomainException("O valor excede o limite de saque");
			}
			if (amount > balance) {
				throw new DomainException("Saldo induficiente");
			}
			balance -= amount;
		}
}
