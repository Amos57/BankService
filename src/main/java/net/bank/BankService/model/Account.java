package net.bank.BankService.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;



@ToString
@Entity
@Table(name="account")
public class Account{
	
	@Id
    @Column(name="numberAccount")
	private int numberAccaunt;
    
    @Column(name="sum")
	private BigDecimal sum;
	
	
	
	
	
/*	public Account( int numberAccaunt, BigDecimal sum) {

		this.numberAccaunt = numberAccaunt;
		this.sum = sum;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public int getNumberAccaunt() {
		return numberAccaunt;
	}
	public void setNumberAccaunt(int numberAccaunt) {
		this.numberAccaunt = numberAccaunt;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}


	
}
