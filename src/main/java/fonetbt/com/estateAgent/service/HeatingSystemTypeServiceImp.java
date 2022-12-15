package fonetbt.com.estateAgent.service;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.HeatingSystemType;
import fonetbt.com.estateAgent.repository.HeatingSystemTypeRepository;

@Service
public class HeatingSystemTypeServiceImp implements HeatingSystemTypeService {
	
	private HeatingSystemTypeRepository heatingSystemTypeRepository;
	
	

	public HeatingSystemTypeServiceImp(HeatingSystemTypeRepository heatingSystemTypeRepository) {
		super();
		this.heatingSystemTypeRepository = heatingSystemTypeRepository;
	}



	@Override
	public HeatingSystemType getHeatingSystemTypeById(long id) {
		return heatingSystemTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("HeatingSystemType", "Id", id));
	}

}
