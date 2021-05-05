package model.entity;

import model.exceptions.ErrorBalanceException;
import model.exceptions.NotEnoughBalance;

public class Account {

	private Integer number;
	private String holder;
	private Double balance = 0.0;
	private Double withDrawLimit = 300.0;

	public Account() {
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	@Override
	public String toString() {
		return "Number: " + number + "\n" + "Holder: " + holder + "\n" + "New Balance: " + balance;

	}

	public void deposit(Double amount) {
		balance += amount;

	}

	public void withDraw(Double amount) {
		balance -= amount;

	}

	public void validateWithDraw(Double amount) {
		if (amount > getWithDrawLimit()) {
			throw new ErrorBalanceException("Withdraw error: The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new NotEnoughBalance("Error: Not Enough Balance");
		}
	}

}
