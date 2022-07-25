package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<product, Long> {

	@Query("SELECT u FROM product u WHERE u.Name=?1")
	public product findByName(String Name);

}
