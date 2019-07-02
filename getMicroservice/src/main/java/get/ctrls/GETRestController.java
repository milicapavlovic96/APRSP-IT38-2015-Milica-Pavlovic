package get.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import get.jpa.Igrac;
import get.jpa.Liga;
import get.jpa.Nacionalnost;
import get.jpa.Tim;
import get.reps.IgracRepository;
import get.reps.LigaRepository;
import get.reps.NacionalnostRepository;
import get.reps.TimRepository;

@RestController
public class GETRestController {
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@Autowired
	private TimRepository timRepository;

	@CrossOrigin
	@GetMapping("igrac")
	@ApiOperation(value = "Vraća kolekciju svih igraca iz baze podataka")

	public Collection<Igrac> getIgrac(){
		return igracRepository.findAll();
	}
	

	@CrossOrigin
	@GetMapping(value = "igracId/{id}")
	public Collection<Igrac> igracZaTimId(@PathVariable("id") int id){
		Tim p = timRepository.getOne(id);
		return igracRepository.findByTim(p);
	}
	@CrossOrigin
	@GetMapping("liga")
	public Collection<Liga> getLiga(){
		return ligaRepository.findAll();
	}
	

	@CrossOrigin
	@GetMapping("ligaId/{id}")
	public Liga getLiga(@PathVariable("id") Integer id){
		return ligaRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("nacionalnost")
	public Collection<Nacionalnost> getNacoinalnost(){
		return nacionalnostRepository.findAll();
	}

	@CrossOrigin
	@GetMapping("nacionalnostId/{id}")
	public Nacionalnost getNacionalnost(@PathVariable("id") Integer id){
		return nacionalnostRepository.getOne(id);
	}

	@CrossOrigin
	@GetMapping("tim")
	public Collection<Tim> getTim(){
		return timRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("timId/{id}")
	public Tim getTim(@PathVariable("id") Integer id){
		return timRepository.getOne(id);
	}
	


	
}
