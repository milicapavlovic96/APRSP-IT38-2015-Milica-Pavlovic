package post.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import post.jpa.Igrac;
import post.jpa.Tim;






public interface IgracRepository extends JpaRepository<Igrac, Integer>{

	Collection <Igrac> findByTim(Tim p);
	
}