package delete.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import delete.jpa.Igrac;
import delete.jpa.Liga;
import delete.jpa.Nacionalnost;
import delete.jpa.Tim;
import delete.reps.IgracRepository;
import delete.reps.LigaRepository;
import delete.reps.NacionalnostRepository;
import delete.reps.TimRepository;

@RestController
public class DELETERestController {
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@Autowired
	private TimRepository timRepository;

	@CrossOrigin
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Briše igraca iz baze podataka čiji je id vrednost prosleđena kao path varijabla")

	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id){
		if(!igracRepository.existsById(id))
			return new ResponseEntity<Igrac>(HttpStatus.NO_CONTENT);
		igracRepository.deleteById(id);
		return new ResponseEntity<Igrac>(HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "liga/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Liga> deleteliga(@PathVariable("id") Integer id){
		if(!ligaRepository.existsById(id))
			return new ResponseEntity<Liga>(HttpStatus.NO_CONTENT);
		ligaRepository.deleteById(id);
		return new ResponseEntity<Liga>(HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "nacionalnost/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Nacionalnost> deleteNacionalnost(@PathVariable("id") Integer id){
		if(!nacionalnostRepository.existsById(id))
			return new ResponseEntity<Nacionalnost>(HttpStatus.NO_CONTENT);
		nacionalnostRepository.deleteById(id);
		return new ResponseEntity<Nacionalnost>(HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "tim/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Tim> deleteTim(@PathVariable("id") Integer id){
		if(!timRepository.existsById(id))
			return new ResponseEntity<Tim>(HttpStatus.NO_CONTENT);
		timRepository.deleteById(id);
		return new ResponseEntity<Tim>(HttpStatus.OK);
	}
	
}