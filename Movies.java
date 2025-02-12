package com.onlinemovieticketbookingsystem.utility.movies.entities;

import jakarta.persistence.*;

import java.util.*;
import java.time.*;

import com.onlinemovieticketbookingsystem.utility.review.entities.Reviews;
import com.onlinemovieticketbookingsystem.utility.show.entities.Shows;
import com.onlinemovieticketbookingsystem.utility.theatre.entities.Theatres;

@Entity
@Table(name = "Movies_List")
public class Movies 
{
    @Id
    @Column
    private String movieId;

    @Column(name = "Movie_Name", length = 300, nullable = false)
    private String movieName;

    @Column(nullable = false)
    private String movieLanguage;

    @Column(nullable = false)
    private Duration movieDuration;

    @Column(nullable = false)
    private String movieGenre;

    @Column(nullable = false)
    private String movieReleaseDate; //Automatic date created while adding movie release date

    @Column(nullable = false)
    //
    private String movieCategory;
    /*-----------------------Movie Theatre M:1 Relation------------------------*/
    @ManyToOne
    private Theatres theatres ;
    /*-----------------------Movie Shows 1:M Relation------------------------*/
    @OneToMany(mappedBy = "movies") // Bidirectional
    private List<Shows> shows = new ArrayList<>();
    /*-----------------------Movie Review 1:M Relation------------------------*/
    @OneToMany(mappedBy = "movies") // Bidirectional
    private List<Reviews> reviews = new ArrayList<>();
    /*--------------------------------------------------------------------------------------*/
    public Movies(String movieId, String movieName, String movieLanguage, Duration movieDuration, String movieGenre,
			String movieReleaseDate, String movieCategory, Theatres theatres, List<Shows> shows,
			List<Reviews> reviews) 
    {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieDuration = movieDuration;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.movieCategory = movieCategory;
		this.theatres = theatres;
		this.shows = shows;
		this.reviews = reviews;
	}

	public Movies() 
	{
		super();
	}
    /*--------------------------------------------------------------------------------------*/
	// Getter and Setter method
    public String getMovieId() { return movieId; }
	public void setMovieId(String movieId) { this.movieId = movieId; }
	
	public Theatres getTheatre() {return theatres;}
	public void setTheatre(Theatres theatres) {this.theatres = theatres;} //

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getMovieLanguage() { return movieLanguage; }
    public void setMovieLanguage(String movieLanguage) { this.movieLanguage = movieLanguage; }

    public Duration getMovieDuration() { return movieDuration; }
    public void setMovieDuration(Duration movieDuration) { this.movieDuration = movieDuration; }

    public String getMovieGenre() { return movieGenre; }
    public void setMovieGenre(String movieGenre) { this.movieGenre = movieGenre; }

    public String getMovieReleaseDate() { return movieReleaseDate; }
    public void setMovieReleaseDate(String movieReleaseDate) { this.movieReleaseDate = movieReleaseDate; }

    public String getMovieCategory() { return movieCategory; }
    public void setMovieCategory(String movieCategory) { this.movieCategory = movieCategory; }
    
	public List<Shows> getShows() {return shows;}
	public void setShows(List<Shows> shows) {this.shows = shows;}
	
	public Theatres getTheatres() {return theatres;}
	public void setTheatres(Theatres theatres) {this.theatres = theatres;}
	
	public List<Reviews> getReviews() {return reviews;}
	public void setReviews(List<Reviews> reviews) {this.reviews = reviews;}
	/*-------------------------------------------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieLanguage=" + movieLanguage
				+ ", movieDuration=" + movieDuration + ", movieGenre=" + movieGenre + ", movieReleaseDate="
				+ movieReleaseDate + ", movieCategory=" + movieCategory + ", theatres=" + theatres + ", shows=" + shows
				+ ", reviews=" + reviews + "]";
	}
	
	
}
