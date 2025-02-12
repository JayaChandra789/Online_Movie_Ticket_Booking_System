package com.onlinemovieticketbookingsystem.utility.show.entities;

import com.onlinemovieticketbookingsystem.utility.movies.entities.Movies;
import com.onlinemovieticketbookingsystem.utility.seats.entities.Seats;
import com.onlinemovieticketbookingsystem.utility.theatre.entities.Theatres;
import com.onlinemovieticketbookingsystem.utility.user.entities.AdminUser;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Shows")
public class Shows 
{
	@Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generate unique IDs
    private String showId; // UUID for unique show identification
	
	@Column(nullable = false)
	private String showName;
	
	@Column(nullable = false)
	private String showTime;
	
	@Column(nullable = false)
	private String userShowBookingDate;
	/*-------------------------Shows Movies Relation----------------------------*/
	@ManyToOne  // 
    private Movies movies;  // Owning side (No mappedBy needed)
	/*-----------------------------Shows Theatre Relation------------------------*/
	@ManyToOne // FK to Theatres 
    private Theatres theatres; //Theatre_ID relation
	/*-----------------------------Shows Admin M:1 Relation------------------------*/
	@ManyToOne
	private AdminUser adminUser;  // Owning side (No mappedBy needed)
	/*-----------------------------Shows Seats M:1 Relation------------------------*/
	@OneToMany(mappedBy = "shows")
	private List<Seats> seats = new ArrayList<>();
	/*-----------------------------------------------------------------------------*/
	public Shows(String showId, String showName, String showTime, String userShowBookingDate, Movies movies,
			Theatres theatres, AdminUser adminUser, List<Seats> seats) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.showTime = showTime;
		this.userShowBookingDate = userShowBookingDate;
		this.movies = movies;
		this.theatres = theatres;
		this.adminUser = adminUser;
		this.seats = seats;
	}
	public Shows() 
	{
		super();
	}
	/*----------------------------------------------------------------------------------------*/
	public String getShowId() {return showId;}
	public void setShowId(String showId) {this.showId = showId;}
	
	public String getShowName() {return showName;}
	public void setShowName(String showName) {this.showName = showName;}
	
	public String getShowTime() {return showTime;}
	public void setShowTime(String showTime) {this.showTime = showTime;}
	
	public String getUserShowBookingDate() {return userShowBookingDate;}
	public void setUserShowBookingDate(String userShowBookingDate) {this.userShowBookingDate = userShowBookingDate;}
	
	public Movies getMovies() {return movies;}
	public void setMovies(Movies movies) {this.movies = movies;}
	
	public Theatres getTheatres() {return theatres;}
	public void setTheatres(Theatres theatres) {this.theatres = theatres;}
	
	public AdminUser getAdminUser() {return adminUser;}
	public void setAdminUser(AdminUser adminUser) {this.adminUser = adminUser;}
	
	public List<Seats> getSeats() {return seats;}
	public void setSeats(List<Seats> seats) {this.seats = seats;}
	/*-------------------------------------------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Shows [showId=" + showId + ", showName=" + showName + ", showTime=" + showTime
				+ ", userShowBookingDate=" + userShowBookingDate + ", movies=" + movies + ", theatres=" + theatres
				+ ", adminUser=" + adminUser + ", seats=" + seats + "]";
	}		
}
