package fonetbt.com.estateAgent.service;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.PropertyType;
import fonetbt.com.estateAgent.repository.PropertyTypeRepository;

@Service
public class PropertyTypeServiceImp implements PropertyTypeService {
	
	private PropertyTypeRepository propertyTypeRepository;
	
	

	public PropertyTypeServiceImp(PropertyTypeRepository propertyTypeRepository) {
		super();
		this.propertyTypeRepository = propertyTypeRepository;
	}



	@Override
	public PropertyType GetById(long id) {
		return propertyTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("PropertyType", "Id", id));
	}
}



