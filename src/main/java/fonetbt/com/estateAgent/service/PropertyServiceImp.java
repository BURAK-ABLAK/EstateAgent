package fonetbt.com.estateAgent.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.Dao.Request.PropertyCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.PropertyCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyUpdateResponse;
import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.Property;
import fonetbt.com.estateAgent.repository.PropertyRepository;

@Service
public class PropertyServiceImp implements PropertyService {
	
	private PropertyRepository propertyRepository;

	public PropertyServiceImp(PropertyRepository propertyRepository) {
		super();
		this.propertyRepository = propertyRepository;
	}

	@Override
	public PropertyCreateResponse Create(PropertyCreateRequest request) {

		PropertyCreateResponse response = new PropertyCreateResponse();

		Property property = new Property();

		property.setRoomCount(request.getRoomCount());
		property.setAdress(request.getAdress());
		property.setSize(request.getSize());
		property.setFloorCount(request.getFloorCount());

		// TODO officer_id added.

		property.setActive(true);
		property.setCreatedDate(Calendar.getInstance().getTime());

		Property createResult = propertyRepository.save(property);

		response.id = createResult.getId();
		return response;
	}

	@Override
	public List<Property> getAllPropertys() {

		return propertyRepository.findAll();
	}

	@Override
	public Property getPropertyById(long id) {

		return propertyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Property", "Id", id));

	}

	@Override
	public PropertyUpdateResponse updateProperty(long id, PropertyUpdateRequest request) {

		PropertyUpdateResponse response = new PropertyUpdateResponse();

		Property existingProperty = propertyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Property", "Id", id));

		existingProperty.setRoomCount(request.getRoomCount());
		existingProperty.setAdress(request.getAdress());
		existingProperty.setSize(request.getSize());
		existingProperty.setFloorCount(request.getFloorCount());

		existingProperty.setActive(true);
		existingProperty.setUpdatedDate(Calendar.getInstance().getTime());

		Property updateResult = propertyRepository.save(existingProperty);

		response.id = updateResult.getId();
		response.adress = updateResult.getAdress();
		response.size = updateResult.getSize();
		response.roomCount = updateResult.getRoomCount();
		response.floorCount = updateResult.getFloorCount();

		return response;
	}

	@Override
	public void deleteProperty(long id) {

		propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Property", "id", id));

		propertyRepository.deleteById(id);

	}
}
