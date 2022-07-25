package net.codejava;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


 
@Controller
public  class AppController {
	
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;    

	
	@GetMapping("")
    public String viewHomePage() {
		
        return "index";
    }

    @GetMapping("/register")
	 public String showRegistrationForm(Model model) {
    
		 model.addAttribute("user", new user());
		return "signup_form";
		 
	 }
	 
    @PostMapping("/process_register")
   	 public String processRegistration(user user) {
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
       String encodedPassword=encoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
   	 return "register_success";
   	 
    }
    @GetMapping("/products")
    public String viewProductPage(Model model,@ModelAttribute("productName") product productName) {
    	 model.addAttribute("newProduct",new product());
		List<product> listProduct=productRepository.findAll();
		model.addAttribute("listProduct", listProduct);
		  if(productName.getName()!=null) {
			   System.out.print(productName.getName());
		   }

        return "products";
    }
  
    
    @GetMapping("/profile")
    public String viewProfilePage(Model model, @ModelAttribute("newUser2") user newUser2) {
    
    	user oldUser=new user();
    	user newUser =new user();
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    	    Object principal = authentication.getPrincipal();
    	String email= (principal instanceof UserDetails
    			            ? ((UserDetails) principal).getUsername()
    			            : principal.toString());
    	newUser=userRepository.findByEmail(email);
    	 oldUser=userRepository.findByEmail(email);
    	
    	 model.addAttribute("newUser",newUser);
    
   if (!(oldUser.getFull_Name().equalsIgnoreCase(newUser2.getFull_Name())) &&newUser2.getFull_Name()!=null)
   {
	   oldUser.setFull_Name(newUser2.getFull_Name());
   
   }  
   if (!(oldUser.getTitle().equalsIgnoreCase(newUser2.getTitle()))&&newUser2.getTitle()!=null)
   {
	   oldUser.setTitle(newUser2.getTitle());
   
   } 
   
   user save=userRepository.save(oldUser);
 
   return "profile";
    	 }
    


@GetMapping("/products01/{id}")
public String viewProduct01Page(@PathVariable("id") Long id,Model model, @ModelAttribute("newProductDetails") product newProductDetails) {
	System.out.print(id);
	product ProductDetail=null;
	List<product> listProduct = productRepository.findAll();
 for (int i=0; i<listProduct.size();i++) {
	 if(listProduct.get(i).getId()==id){
		 ProductDetail=listProduct.get(i);
	model.addAttribute("ProductDetails", ProductDetail); 
	 }
 }
 if (!(ProductDetail.getName().equalsIgnoreCase(newProductDetails.getName())) &&newProductDetails.getName()!=null)
 {
	 ProductDetail.setName(newProductDetails.getName());
 
 }  
 if (!(ProductDetail.getPrice()==newProductDetails.getPrice())&&newProductDetails.getPrice()!=null)
 {
	 ProductDetail.setPrice(newProductDetails.getPrice());
 
 }  if (!(ProductDetail.getAvailable()==newProductDetails.getAvailable())&&newProductDetails.getAvailable()!=null)
 {
	 ProductDetail.setAvailable(newProductDetails.getAvailable());
 
 }  if (!(ProductDetail.getDescription().equalsIgnoreCase(newProductDetails.getDescription()))
		 &&newProductDetails.getDescription()!=null)
 {
	 ProductDetail.setDescription(newProductDetails.getDescription());
 
 } 
 
 product save=productRepository.save(ProductDetail);

 
return "products01";
	 }
}