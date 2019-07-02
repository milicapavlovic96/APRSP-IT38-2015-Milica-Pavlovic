package post.reps;


	import java.util.Collection;

	import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Nacionalnost;



	public interface NacionalnostRepository extends JpaRepository<Nacionalnost, Integer>{
		Collection<Nacionalnost> findByNazivContainingIgnoreCase(String naziv);

	}
	  

