package com.onlinemovieticketbookingsystem.utility.review.entities;

import com.onlinemovieticketbookingsystem.utility.movies.entities.Movies;

import com.onlinemovieticketbookingsystem.utility.user.entities.Customers;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviews")
public class Reviews 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int reviewId;
	
	@Column(nullable = false)
	private String reviewDate;
	
	@Column(nullable = false)
	private String rating;
	
	@Column(nullable = false)
	private String review;
	/*----------------------------Review user M:1 relation-----------------------------*/ 
	@ManyToOne
	private Customers customers;
	/*----------------------------Review Movie M:1 relation-----------------------------*/ 
	@ManyToOne
	private Movies movies;
	public Reviews(int reviewId, String reviewDate, String rating, String review, Customers customers,
			Movies movies) 
	{
		super();
		this.reviewId = reviewId;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.review = review;
		this.customers = customers;
		this.movies = movies;
	}
	
	public Reviews() 
	{
		super();
	}
	
	public int getReviewId() {return reviewId;}
	public void setReviewId(int reviewId) {this.reviewId = reviewId;}
	
	public String getReviewDate() {return reviewDate;}
	public void setReviewDate(String reviewDate) {this.reviewDate = reviewDate;}
	
	public String getRating() {return rating;}
	public void setRating(String rating) {this.rating = rating;}
	
	public String getReview() {return review;}
	public void setReview(String review) {this.review = review;}
	
	public Customers getCustomers() {return customers;}
	public void setCustomers(Customers customers) {this.customers = customers;}
	
	public Movies getMovies() {return movies;}
	public void setMovies(Movies movies) {this.movies = movies;}

	@Override
	public String toString() 
	{
		return "Reviews [reviewId=" + reviewId + ", reviewDate=" + reviewDate + ", rating=" + rating + ", review="
				+ review + ", customers=" + customers + ", movies=" + movies + "]";
	}	
}
