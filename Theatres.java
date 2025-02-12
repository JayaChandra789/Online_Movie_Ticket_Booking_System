package com.onlinemovieticketbookingsystem.utility.theatre.entities;

import com.onlinemovieticketbookingsystem.utility.movies.entities.Movies;
import com.onlinemovieticketbookingsystem.utility.seats.entities.Seats;
import com.onlinemovieticketbookingsystem.utility.show.entities.Shows;
import com.onlinemovieticketbookingsystem.utility.user.entities.AdminUser;
import com.onlinemovieticketbookingsystem.utility.user.entities.OwnerUser;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Theatres")
public class Theatres 
{
	@Id
    @Column
    private String theatreId;

    @Column(name = "Theatre_Name", length = 300, nullable = false)
    private String theatreName;

    @Column(nullable = false)
    private int seatingCapacity;

    @Column(nullable = false)
    private String theatreLocation;
    
    @Column(nullable = false)
    private int noOfScreens;
    /*-----------------------Theatre Movies Relation------------------------*/
    @OneToMany(mappedBy = "theatres")  //ownerID fk , here we specifying ref variable name by mappedBy = ; not class name
    private List<Movies> movies = new ArrayList<>();
    /*------------------------Theatre Owner Relation---------------------------------*/
    @OneToOne
    private OwnerUser owner;
    /*------------------------Theatre AdminRelation---------------------------------*/
    @OneToOne
    private AdminUser admin;
    /*------------------------Theatre Shows Relation---------------------------------*/
    @OneToMany(mappedBy = "theatres")
    private List<Shows> shows = new ArrayList<>();
    /*------------------------Theatre Seats Relation---------------------------------*/
    @OneToMany(mappedBy = "theatres")
    private List<Seats> seats = new ArrayList<>();
    /*------------------------------------------------------------------*/
	public Theatres(String theatreId, String theatreName, int seatingCapacity, String theatreLocation, 
			int noOfScreens,List<Movies> movies, OwnerUser owner, AdminUser admin, List<Shows> shows, List<Seats> seats) 
	{
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.seatingCapacity = seatingCapacity;
		this.theatreLocation = theatreLocation;
		this.noOfScreens = noOfScreens;
		this.movies = movies;
		this.owner = owner;
		this.admin = admin;
		this.shows = shows;
		this.seats = seats;
	}
	/*-------------------------------------------------------------------------------------------------------------------------------*/
	public Theatres() 
	{
		super();
	}
	/*--------------------------------------------------------------------------------------------------------------------------------*/
	public List<Seats> getSeats() {return seats;}
	public void setSeats(List<Seats> seats) {this.seats = seats;}
	
	public String getTheatreId() {return theatreId;}
	public void setTheatreId(String theatreId) {this.theatreId = theatreId;}
	
	public List<Movies> getMovies() {return movies;}
	public void setMovies(List<Movies> movies) {this.movies = movies;}
	
	public OwnerUser getOwner() {return owner;}
	public void setOwner(OwnerUser owner) {this.owner = owner;}
	
	public AdminUser getAdmin() {return admin;}
	public void setAdmin(AdminUser admin) {this.admin = admin;}
	
	public String getTheatreName() {return theatreName;}
	public void setTheatreName(String theatreName) {this.theatreName = theatreName;}
	
	public int getSeatingCapacity() {return seatingCapacity;}
	public void setSeatingCapacity(int seatingCapacity) {this.seatingCapacity = seatingCapacity;}
	
	public String getTheatreLocation() {return theatreLocation;}
	public void setTheatreLocation(String theatreLocation) {this.theatreLocation = theatreLocation;}
	
	public int getNoOfScreens() {return noOfScreens;}
	public void setNoOfScreens(int noOfScreens) {this.noOfScreens = noOfScreens;}
	
	public List<Shows> getShows() {return shows;}
	public void setShows(List<Shows> shows) {this.shows = shows;}
	/*---------------------------------------------------------------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Theatres [theatreId=" + theatreId + ", theatreName=" + theatreName + ", seatingCapacity="
				+ seatingCapacity + ", theatreLocation=" + theatreLocation + ", noOfScreens=" + noOfScreens
				+ ", movies=" + movies + ", owner=" + owner + ", admin=" + admin + ", shows=" + shows + ", seats="
				+ seats + "]";
	}		 
}
