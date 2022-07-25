package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
public interface UserRepository extends JpaRepository<user, Long> {
  
	@Query("SELECT u FROM user u WHERE u.Email_Address=?1")
	public user findByEmail(String email);

}