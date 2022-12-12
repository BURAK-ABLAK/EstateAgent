package fonetbt.com.estateAgent.service;

import fonetbt.com.estateAgent.Dao.Request.EstateAgentCreateRequest;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentCreateResponse;

public interface EstateAgentService {
	EstateAgentCreateResponse Create(EstateAgentCreateRequest request);
	
}
