
package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 45)
    private String Email_Address;
     
    @Column(nullable = false, length = 64)
    private String Password;
     
  
private String Full_Name;
private String Title;
public String getFull_Name() {
	return Full_Name;
}
public void setFull_Name(String full_Name) {
	Full_Name = full_Name;
	
}
public String getEmail_Address() {
	return Email_Address;
}
public void setEmail_Address(String email_Address) {
	Email_Address = email_Address;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}

}
