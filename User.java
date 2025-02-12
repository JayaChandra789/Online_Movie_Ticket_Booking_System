package com.onlinemovieticketbookingsystem.utility.user.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //

public class User 
{
    /*--------------------------------------------------------Member Variables--------------------------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generate unique IDs
    private String userId; // UUID for unique user identification

    @Column(nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String roleName; // 
    
    @Column(nullable = false, unique = true, length = 10)
    private String userMobileNumber;
    
    @Column(nullable = false, unique = true, length = 100)
    private String userE_Mail;

    @Column(nullable = false)
    private String userPassword;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; //Cant able to Update

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; //Able to update

    /*--------------------------------------------------------Lifecycle Callbacks--------------------------------------------------------*/
    /*The @PrePersist annotation is used in JPA/Hibernate to define a method that will be 
     * executed before an entity is persisted (saved for the first time) in the database.*/
//    @PrePersist
//    protected void generateUserId() { //Used to generate user ID randomly with unique
//        this.userId = UUID.randomUUID().toString();
//    }
    @PrePersist
    protected void onCreate() { //LocaDateTime.now() used to Show date and date after creation using @PrePersist
        createdAt = LocalDateTime.now();
    }
    /*The @PreUpdate annotation is used in JPA/Hibernate to define a method that will be 
     * executed before an entity is updated in the database.*/
    @PreUpdate
    protected void onUpdate() { //LocaDateTime.now() used to Show date and date after creation using @PrePersist
        updatedAt = LocalDateTime.now();
    }
    /*--------------------------------------------------------Constructors--------------------------------------------------------*/
    public User(String userName,String roleName, String userMobileNumber, String userE_Mail, String userPassword) {
    	this.userId = UUID.randomUUID().toString(); // Ensure UUID is generated
    	this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userE_Mail = userE_Mail;
        this.userPassword = userPassword;
        this.roleName = roleName;
    }
    
    public User() 
    {
        super();
    }
    /*--------------------------------------------------------Getter And Setters--------------------------------------------------------*/
    public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}//
    
    public String getRoleName() {return roleName;}
	public void setRoleName(String roleName) {this.roleName = roleName;}
	
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName; }

    public String getUserMobileNumber() {return userMobileNumber;}
    public void setUserMobileNumber(String userMobileNumber) {this.userMobileNumber = userMobileNumber;}

    public String getUserE_Mail() {return userE_Mail;}
    public void setUserE_Mail(String userE_Mail) {this.userE_Mail = userE_Mail;}

    public String getUserPassword() {return userPassword;}
    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
    /*--------------------No need to set Manaully by user--------------------*/
    public LocalDateTime getCreatedAt() {return createdAt;}
    
    public LocalDateTime getUpdatedAt() {return updatedAt;}
    /*--------------------------------------------------------toString() Method--------------------------------------------------------*/
    @Override
    public String toString() {
        return "\n User Details: "+
        	   "\n User: " + userId +
               "\n userName: " + userName +
               "\n userMobileNumber: " + userMobileNumber +
               "\n userE_Mail: " + userE_Mail +
               "\n createdAt: " + createdAt +
               "\n updatedAt: " + updatedAt;
    }
}
