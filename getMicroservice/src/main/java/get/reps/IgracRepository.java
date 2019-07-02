package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import get.jpa.Igrac;
import get.jpa.Tim;






public interface IgracRepository extends JpaRepository<Igrac, Integer>{

	Collection <Igrac> findByTim(Tim p);
	
}