package put.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import put.jpa.Liga;


public interface LigaRepository extends JpaRepository <Liga, Integer>{
	Collection<Liga> findByNazivContainingIgnoreCase(String naziv);
}
