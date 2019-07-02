package delete.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import delete.jpa.Igrac;
import delete.jpa.Tim;






public interface IgracRepository extends JpaRepository<Igrac, Integer>{

	Collection <Igrac> findByTim(Tim p);
	
}