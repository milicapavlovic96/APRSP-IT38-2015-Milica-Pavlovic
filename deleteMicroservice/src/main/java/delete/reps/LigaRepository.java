package delete.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import delete.jpa.Liga;


public interface LigaRepository extends JpaRepository <Liga, Integer>{
	Collection<Liga> findByNazivContainingIgnoreCase(String naziv);
}
