package com.citi.sanction_transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class User {


@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Column(columnDefinition = "varchar(35) default 'NULL'")
    private String username;
    
	@Column(columnDefinition = "varchar(35) default 'NULL'")
	private String password;
 
   
    public User() {

    }
 
    public User(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
    }
   
    public int getId() {
    return id;
    }
   
    public void setId(int id) {
    this.id = id;
    }
   
    public String getUsername() {
    return username;
    }
   
    public void setUsername(String username) {
    this.username = username;
    }
   
    public String getPassword() {
    return password;
    }
   
    public void setPassword(String password) {
    this.password = password;
    }

}
