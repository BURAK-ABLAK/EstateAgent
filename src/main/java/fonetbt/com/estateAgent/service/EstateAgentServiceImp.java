package fonetbt.com.estateAgent.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.Dao.Request.EstateAgentCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.EstateAgentUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.EstateAgentUpdateResponse;
import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.EstateAgent;
import fonetbt.com.estateAgent.repository.EstateAgentRepository;

@Service
public class EstateAgentServiceImp implements EstateAgentService {

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
		estateAgent.setOfficerId(request.getOfficerId());
		estateAgent.setActive(true);
		estateAgent.setCreatedDate(Calendar.getInstance().getTime());

		EstateAgent createResult = estateAgentRepository.save(estateAgent);

		response.Id = createResult.getId();
		return response;
	}

	@Override
	public List<EstateAgent> getAllEstateAgents() {

		return estateAgentRepository.findAll();
	}

	@Override
	public EstateAgent getEstateAgentById(long id) {

		return estateAgentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("EstateAgent", "Id", id));

	}

	@Override
	public EstateAgentUpdateResponse updateEstateAgent(long id, EstateAgentUpdateRequest request) {

		EstateAgentUpdateResponse response = new EstateAgentUpdateResponse();

		EstateAgent existingEstateAgent = estateAgentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("EstateAgent", "Id", id));

		existingEstateAgent.setName(request.getName());
		existingEstateAgent.setAdress(request.getAdress());
		existingEstateAgent.setPhone(request.getPhone());
		existingEstateAgent.setFax(request.getFax());

		existingEstateAgent.setActive(true);
		existingEstateAgent.setUpdatedDate(Calendar.getInstance().getTime());

		EstateAgent updateResult = estateAgentRepository.save(existingEstateAgent);

		response.Id = updateResult.getId();
		response.Name = updateResult.getName();
		response.Adress = updateResult.getAdress();
		response.Phone = updateResult.getPhone();
		response.Fax = updateResult.getFax();

		return response;
	}

	@Override
	public void deleteEstateAgent(long id) {

		estateAgentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("EstateAgent", "id", id));

		estateAgentRepository.deleteById(id);

	}

}
