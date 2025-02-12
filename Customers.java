package com.onlinemovieticketbookingsystem.utility.user.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "Customers")
public class Customers extends User
{
	/*------------------------------------------------Member Variables---------------------------------------------------*/
	@Column
	private String address;
	/*------------------------------------------------------Full constructor with Parametrers--------------------------------------------------------------*/
	public Customers(String userName, String roleName, String userMobileNumber, String userE_Mail, String userPassword, String address)
	{
	    super(userName, roleName, userMobileNumber, userE_Mail, userPassword);
	    this.address = address;  // Ensure address is not null when passed here
	}
	/*--------------------------------------Default and Parameterized Constructor------------------------------------------------*/
	public Customers() 
	{
		super();
	}
	public Customers(String userName, String roleName, String userMobileNumber, String userE_Mail,String userPassword) 
	{
		super(userName, roleName, userMobileNumber, userE_Mail, userPassword);
	}
	/*-----------------------------------------Getter and Setters---------------------------------------------*/
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	/*---------------------------------------------To String---------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Customers [address=" + address +", getUserId()="
				+ getUserId() + ", getUserName()=" + getUserName() + ", getUserMobileNumber()=" + getUserMobileNumber()
				+ ", getUserE_Mail()=" + getUserE_Mail() + ", getUserPassword()=" + getUserPassword()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt();
	}	
}
