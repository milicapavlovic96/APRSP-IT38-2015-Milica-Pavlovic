package put.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import put.jpa.Igrac;
import put.jpa.Liga;
import put.jpa.Nacionalnost;
import put.jpa.Tim;
import put.reps.IgracRepository;
import put.reps.LigaRepository;
import put.reps.NacionalnostRepository;
import put.reps.TimRepository;

@RestController
public class PUTRestController {
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@Autowired
	private TimRepository timRepository;

	@CrossOrigin
	@PutMapping("igrac")
	@ApiOperation(value = "Modifikuje postojećeg igraca iz baze podataka")

	public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac igrac){
		if(!igracRepository.existsById(igrac.getId()))
			return new ResponseEntity<Igrac>(HttpStatus.NO_CONTENT);
		igracRepository.save(igrac);
		return new ResponseEntity<Igrac>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("liga")
	public ResponseEntity<Liga> updateDobavljac(@RequestBody Liga liga){
		if(!ligaRepository.existsById(liga.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		ligaRepository.save(liga);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("nacionalnost")
	public ResponseEntity<Nacionalnost> updatenacionalnost(@RequestBody Nacionalnost nacionalnost){
		if(!nacionalnostRepository.existsById(nacionalnost.getId()))
			return new ResponseEntity<Nacionalnost>(HttpStatus.NO_CONTENT);
		nacionalnostRepository.save(nacionalnost);
		return new ResponseEntity<Nacionalnost>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("tim")
	public ResponseEntity<Tim> updateTim(@RequestBody Tim tim){
		if(!timRepository.existsById(tim.getId()))
			return new ResponseEntity<Tim>(HttpStatus.NO_CONTENT);
		timRepository.save(tim);
		return new ResponseEntity<Tim>(HttpStatus.OK);
	}
	
	
	
}
	