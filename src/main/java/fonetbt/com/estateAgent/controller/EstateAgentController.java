package fonetbt.com.estateAgent.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fonetbt.com.estateAgent.Dao.Request.EstateAgentCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.EstateAgentUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentUpdateResponse;
import fonetbt.com.estateAgent.model.EstateAgent;
import fonetbt.com.estateAgent.service.EstateAgentService;

@RestController
@RequestMapping("/api/estateagents")
public class EstateAgentController {

	private EstateAgentService estateAgentService;

	public EstateAgentController(EstateAgentService estateAgentService) {
		super();
		this.estateAgentService = estateAgentService;
	}

	// build create
	@PostMapping
	public ResponseEntity<EstateAgentCreateResponse> Create(@RequestBody EstateAgentCreateRequest request) {
		return new ResponseEntity<EstateAgentCreateResponse>(estateAgentService.Create(request), HttpStatus.CREATED);
	}

	// build get all
	@GetMapping
	public List<EstateAgent> getAllEstateAgents() {
		return estateAgentService.getAllEstateAgents();
	}

	// build get by id
	// http://localhost:8080/api/estateagents/1-2-3-...etc
	@GetMapping("{id}")
	public ResponseEntity<EstateAgent> getEstateAgentById(@PathVariable("id") long estateAgentId) {
		return new ResponseEntity<EstateAgent>(estateAgentService.getEstateAgentById(estateAgentId), HttpStatus.OK);
	}

	// build update
	// http://localhost:8080/api/estateagents/1-2-3-...etc
	@PutMapping("{id}")
	public ResponseEntity<EstateAgentUpdateResponse> updateEstateAgent(@PathVariable("id") long id,
			@RequestBody EstateAgentUpdateRequest request) {
		return new ResponseEntity<EstateAgentUpdateResponse>(estateAgentService.updateEstateAgent(id, request),
				HttpStatus.OK);
	}

	// build delete
	// http://localhost:8080/api/estateagents/1-2-3-...etc
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEstateAgent(@PathVariable("id") long id) {
		estateAgentService.deleteEstateAgent(id);

		return new ResponseEntity<String>("EstateAgent deleted success!", HttpStatus.OK);
	}

}
