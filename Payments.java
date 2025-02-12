package com.onlinemovieticketbookingsystem.utility.payments.entities;

import com.onlinemovieticketbookingsystem.utility.ticket.entities.Tickets;

import com.onlinemovieticketbookingsystem.utility.user.entities.Customers;

import jakarta.persistence.*;

@Entity
@Table(name = "Payments")
public class Payments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int paymentId;
	
	@Column(nullable = false)
	private String paymentMode;
	
	@Column(nullable = false)
	private String amountTotal;
	
	@Column(nullable = false)
	private String paymentStatus;
	/*----------------------------Payment Ticket relation-----------------------------*/ 
	@OneToOne
	private Tickets tickets; 
	/*----------------------------Payment Customer relation-----------------------------*/
	@OneToOne //end many contains list for sure
	private Customers customers;
	/*--------------------------------------------------------------------------------------*/
	public Payments(int paymentId, String paymentMode, String amountTotal, String paymentStatus, Tickets tickets,
			Customers customers) 
	{
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.amountTotal = amountTotal;
		this.paymentStatus = paymentStatus;
		this.tickets = tickets;
		this.customers = customers;
	}
	public Payments() 
	{
		super();
	}
	/*--------------------------------------------------------------------------------*/
	public int getPaymentId() {return paymentId;}
	public void setPaymentId(int paymentId) {this.paymentId = paymentId;}
	
	public String getPaymentMode() {return paymentMode;}
	public void setPaymentMode(String paymentMode) {this.paymentMode = paymentMode;}
	
	public String getAmountTotal() {return amountTotal;}
	public void setAmountTotal(String amountTotal) {this.amountTotal = amountTotal;}
	
	public String getPaymentStatus() {return paymentStatus;}
	public void setPaymentStatus(String paymentStatus) {this.paymentStatus = paymentStatus;}
	
	public Tickets getTickets() {return tickets;}
	public void setTickets(Tickets tickets) {this.tickets = tickets;}
	
	public Customers getCustomers() {return customers;}
	public void setCustomers(Customers customers) {this.customers = customers;}
	/*-------------------------------------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Payments [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", amountTotal=" + amountTotal
				+ ", paymentStatus=" + paymentStatus + ", tickets=" + tickets + ", customers=" + customers + "]";
	}
	
}
