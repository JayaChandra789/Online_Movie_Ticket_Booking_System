package com.onlinemovieticketbookingsystem.utility.user.entities;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.onlinemovieticketbookingsystem.utility.TicketBookingSystemUtils;

public class UserDataInsertion 
{
	public static void main(String[] args) 
	{
		/*---------------Creating Session----------------*/
		Session session = TicketBookingSystemUtils.getSessionFactory().openSession();
		/*-----------------Creating Transaction----------------*/
		Transaction transaction = session.beginTransaction();
		/*--------------------------Creating objects for child customer class to enter data into DB---------------------*/
		Customers customer1 = new Customers("Jagan","Customer","7894561231","jagan@123email.com","jaggu123","DilsukhNagar"); // Make sure the address is set
		/*---------------------------------------------------------------------------------*/
		session.save(customer1);
		/*---------------------------------------------------------------------------------*/
	//	session.save(admin1);
		/*---------------------------------------------------------------------------------*/
	//	session.save(owner1);
		/*----------------------------------------------------------------------------------*/
		/*---------------------------Commit Transaction--------------------------------*/
		/*---------------------------Make commit in Data Base--------------------------------*/
		transaction.commit();
		/*---------------------------Closing Session--------------------------------*/
		TicketBookingSystemUtils.getSessionFactory().close();
		/*---------------------------------------------------------------------------*/
		System.out.println("-------------------------------------");
		System.out.println("Customer Data Inserted Succesfully.");
		System.out.println("-------------------------------------");

	}
}

/**/
