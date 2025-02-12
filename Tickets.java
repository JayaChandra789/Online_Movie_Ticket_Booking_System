package com.onlinemovieticketbookingsystem.utility.ticket.entities;

import com.onlinemovieticketbookingsystem.utility.payments.entities.Payments;
import com.onlinemovieticketbookingsystem.utility.show.entities.Shows;
import com.onlinemovieticketbookingsystem.utility.user.entities.Customers;

import jakarta.persistence.*;

@Entity
@Table(name = "Tickets")
public class Tickets 
{	/*---------------------------------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int ticketId;
	@Column(nullable = false)
	private String movieName;
	@Column(nullable = false)
	private String movieId; 
	@Column(nullable = false)
	private String UserId; 
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String seatId ;
	/*---------------------------------------------------*/
	@OneToOne
	private Payments payments;
	/*-----------------------------Tickets Customers 1:1 Relation------------------------*/
	@OneToOne
	private Customers customers;
	/*-----------------------------Tickets shows 1 : 1 Relation------------------------*/
	@OneToOne
	private Shows shows;
	/*---------------------------------------------------*/

	public Tickets(int ticketId, String movieName, String movieId, String userId, String userName, String seatId,
			Payments payments, Customers customers, Shows shows) {
		super();
		this.ticketId = ticketId;
		this.movieName = movieName;
		this.movieId = movieId;
		UserId = userId;
		this.userName = userName;
		this.seatId = seatId;
		this.payments = payments;
		this.customers = customers;
		this.shows = shows;
	}
	/*-----------------------------------------------------------------------------------------------------*/
	public Tickets() 
	{
		super();
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public Payments getPayments() {return payments;}
	public void setPayments(Payments payments) {this.payments = payments;}
	
	public Customers getCustomers() {return customers;}
	public void setCustomers(Customers customers) {this.customers = customers;}
	
	public Shows getShows() {return shows;}
	public void setShows(Shows shows) {this.shows = shows;}
	
	public int getTicketId() {return ticketId;}
	public void setTicketId(int ticketId) {this.ticketId = ticketId;}
	
	public String getMovieName() {return movieName;}
	public void setMovieName(String movieName) {this.movieName = movieName;}
	
	public String getMovieId() {return movieId;}
	public void setMovieId(String movieId) {this.movieId = movieId;}
	
	public String getUserId() {return UserId;}
	public void setUserId(String userId) {UserId = userId;}
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getSeatId() {return seatId;}
	public void setSeatId(String seatId) {this.seatId = seatId;}
	/*---------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Tickets [ticketId=" + ticketId + ", movieName=" + movieName + ", movieId=" + movieId + ", UserId="
				+ UserId + ", userName=" + userName + ", seatId=" + seatId + ", payments=" + payments + ", customers="
				+ customers + ", shows=" + shows + "]";
	}
}