package fonetbt.com.estateAgent.service;

import java.util.List;

import fonetbt.com.estateAgent.Dao.Request.EstateAgentCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.EstateAgentUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentUpdateResponse;
import fonetbt.com.estateAgent.model.EstateAgent;

public interface EstateAgentService {

	EstateAgentCreateResponse Create(EstateAgentCreateRequest request);

	List<EstateAgent> getAllEstateAgents();

	EstateAgent getEstateAgentById(long id);

	EstateAgentUpdateResponse updateEstateAgent(long id, EstateAgentUpdateRequest request);

	void deleteEstateAgent(long id);
}
