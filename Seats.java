package com.onlinemovieticketbookingsystem.utility.seats.entities;

import com.onlinemovieticketbookingsystem.utility.show.entities.Shows;
import com.onlinemovieticketbookingsystem.utility.theatre.entities.Theatres;

import jakarta.persistence.*;

@Entity
@Table(name = "Seats")
public class Seats 
{	/*---------------------------------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) //Starting from 1 to 200...
	private int seatID ;
	
	@Column(nullable = false)
    private String seatNumber; // Example: A1, A2, etc.

    @Column(nullable = false)
    private boolean isBooked = false;
    /*-----------------------------Seats Theatre Relation------------------------*/
    @ManyToOne
    private Theatres theatres;
    /*-----------------------------Seats Shows Relation------------------------*/
    @ManyToOne
    private Shows shows;
    /*---------------------------------------------------*/

	public Seats(int seatID, String seatNumber, boolean isBooked, Theatres theatres, Shows shows) {
		super();
		this.seatID = seatID;
		this.seatNumber = seatNumber;
		this.isBooked = isBooked;
		this.theatres = theatres;
		this.shows = shows;
	}
    /*---------------------------------------------------*/
	public Seats() 
	{
		super();
	}
    /*---------------------------------------------------*/
	public int getSeatID() {return seatID;}
	public void setSeatID(int seatID) {this.seatID = seatID;}

	public String getSeatNumber() {return seatNumber;}
	public void setSeatNumber(String seatNumber) {this.seatNumber = seatNumber;}

	public boolean isBooked() {return isBooked;}
	public void setBooked(boolean isBooked) {this.isBooked = isBooked;}
	
	public Theatres getTheatres() {return theatres;}
	public void setTheatres(Theatres theatres) {this.theatres = theatres;}
	
	public Shows getShows() {return shows;}
	public void setShows(Shows shows) {this.shows = shows;}
	/*---------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Seats [seatID=" + seatID + ", seatNumber=" + seatNumber + ", isBooked=" + isBooked + ", theatres="
				+ theatres + ", shows=" + shows + "]";
	}
	
}
