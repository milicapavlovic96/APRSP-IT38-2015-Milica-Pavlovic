package post.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import post.jpa.Igrac;
import post.jpa.Liga;
import post.jpa.Nacionalnost;
import post.jpa.Tim;
import post.reps.IgracRepository;
import post.reps.LigaRepository;
import post.reps.NacionalnostRepository;
import post.reps.TimRepository;

@RestController
public class POSTRestController {
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@Autowired
	private NacionalnostRepository nacionalnostRepository;
	
	@Autowired
	private TimRepository timRepository;
	
	@CrossOrigin
	@RequestMapping(value = "igrac", method = RequestMethod.POST)
	@ApiOperation(value = "Upisuje igraca u bazu podataka")

	public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac igrac){
		if(igracRepository.existsById(igrac.getId()))
			return new ResponseEntity<Igrac>(HttpStatus.CONFLICT);
		igracRepository.save(igrac);
		return new ResponseEntity<Igrac>(HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "liga", method = RequestMethod.POST)
	public ResponseEntity<Void> insertliga(@RequestBody Liga liga){
		if(ligaRepository.existsById(liga.getId()))
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		ligaRepository.save(liga);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "nacionalnost", method = RequestMethod.POST)
	public ResponseEntity<Nacionalnost> insertnacionalnost(@RequestBody Nacionalnost nacionalnost){
		if(nacionalnostRepository.existsById(nacionalnost.getId()))
			return new ResponseEntity<Nacionalnost>(HttpStatus.CONFLICT);
		nacionalnostRepository.save(nacionalnost);
		return new ResponseEntity<Nacionalnost>(HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(value = "tim", method = RequestMethod.POST)
	public ResponseEntity<Tim> insertTim(@RequestBody Tim tim){
		if(timRepository.existsById(tim.getId()))
			return new ResponseEntity<Tim>(HttpStatus.CONFLICT);
		timRepository.save(tim);
		return new ResponseEntity<Tim>(HttpStatus.OK);
	}
	
	
	
}
