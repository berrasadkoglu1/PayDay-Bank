package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    

	@Autowired
	private UserRepository repo;
	


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
   		user user=repo.findByEmail(email);
   		
   		if(user==null) {
   			throw new UsernameNotFoundException("User not found");
   		}
   		
		// TODO Auto-generated method stub
   	
   		System.out.print("aa");
   	return  new CustomUserDetails(user);
   	
		
	}

}