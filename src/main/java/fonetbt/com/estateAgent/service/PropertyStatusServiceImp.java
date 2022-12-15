package fonetbt.com.estateAgent.service;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.PropertyStatus;
import fonetbt.com.estateAgent.repository.PropertyStatusRepository;

@Service
public class PropertyStatusServiceImp implements PropertyStatusService {
	
	private PropertyStatusRepository propertyStatusRepository;
	
	

	public PropertyStatusServiceImp(PropertyStatusRepository propertyStatusRepository) {
		super();
		this.propertyStatusRepository = propertyStatusRepository;
	}



	@Override
	public PropertyStatus getPropertyStatusById(long id) {
		return propertyStatusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("PropertyStatus", "Id", id));
	}
	
	

}
