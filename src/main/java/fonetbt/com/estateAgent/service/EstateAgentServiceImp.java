package fonetbt.com.estateAgent.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.Dao.Request.EstateAgentCreateRequest;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentCreateResponse;
import fonetbt.com.estateAgent.model.EstateAgent;
import fonetbt.com.estateAgent.repository.EstateAgentRepository;

@Service
public class EstateAgentServiceImp implements EstateAgentService{
	
	private EstateAgentRepository estateAgentRepository;
	
	public EstateAgentServiceImp(EstateAgentRepository estateAgentRepository) {
		super();
		this.estateAgentRepository = estateAgentRepository;
	}

	@Override
	public EstateAgentCreateResponse Create(EstateAgentCreateRequest request) {
	
		EstateAgentCreateResponse response = new EstateAgentCreateResponse();
		
		EstateAgent estateAgent = new EstateAgent();
		
		estateAgent.setName(request.getName());
		estateAgent.setAdress(request.getAdress());
		estateAgent.setPhone(request.getPhone());
		estateAgent.setFax(request.getFax());
		
		//TODO officer_id eklenmeli.
		
		estateAgent.setActive(true);
		estateAgent.setCreatedDate(Calendar.getInstance().getTime());
		
		EstateAgent createResult = estateAgentRepository.save(estateAgent);
		
		response.Id = createResult.getId();
		return response;
	}


	
	
}
