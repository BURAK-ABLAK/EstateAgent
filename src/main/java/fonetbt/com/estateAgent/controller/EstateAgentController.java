package fonetbt.com.estateAgent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fonetbt.com.estateAgent.Dao.Request.EstateAgentCreateRequest;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentCreateResponse;
import fonetbt.com.estateAgent.service.EstateAgentService;

@RestController
@RequestMapping("/api/estateagents")
public class EstateAgentController {

	private EstateAgentService estateAgentService;
	
	public EstateAgentController(EstateAgentService estateAgentService) {
		super();
		this.estateAgentService = estateAgentService;
	}
	@PostMapping
	public ResponseEntity<EstateAgentCreateResponse> Create(@RequestBody EstateAgentCreateRequest request){
		return new ResponseEntity<EstateAgentCreateResponse>(estateAgentService.Create(request),HttpStatus.CREATED);
	}
	
	
}
