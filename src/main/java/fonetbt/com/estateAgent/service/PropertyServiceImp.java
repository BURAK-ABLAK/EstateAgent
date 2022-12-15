package fonetbt.com.estateAgent.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.Dao.Request.PropertyCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyGetByFilterRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.PropertyCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyGetByFilterResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyGetByIdResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyUpdateResponse;
import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.Property;
import fonetbt.com.estateAgent.repository.PropertyRepository;
import fonetbt.com.estateAgent.spec.PropertySpec;

@Service
public class PropertyServiceImp implements PropertyService {

	private PropertyRepository propertyRepository;

	private PropertyTypeService propertyTypeService;

	private PropertyStatusService propertyStatusService;

	private HeatingSystemTypeService heatingSystemTypeService;

	private CustomerService customerService;

	private EstateAgentService estateAgentService;
	

	

	public PropertyServiceImp(PropertyRepository propertyRepository, PropertyTypeService propertyTypeService,
			PropertyStatusService propertyStatusService, HeatingSystemTypeService heatingSystemTypeService,
			CustomerService customerService, EstateAgentService estateAgentService) {
		super();
		this.propertyRepository = propertyRepository;
		this.propertyTypeService = propertyTypeService;
		this.propertyStatusService = propertyStatusService;
		this.heatingSystemTypeService = heatingSystemTypeService;
		this.customerService = customerService;
		this.estateAgentService = estateAgentService;
	}

	@Override
	public PropertyCreateResponse Create(PropertyCreateRequest request) {

		PropertyCreateResponse response = new PropertyCreateResponse();

		Property property = new Property();

		property.setRoomCount(request.getRoomCount());
		property.setAdress(request.getAdress());
		property.setSize(request.getSize());
		property.setFloorCount(request.getFloorCount());
		property.setHeatingsystemtypeId(request.getHeatingSystemType());
		property.setPropertystatusId(request.getPropertyStatus());
		property.setPropertyTypeId(request.getPropertyType());
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
	public PropertyGetByIdResponse getPropertyById(long id) {

		PropertyGetByIdResponse response= new PropertyGetByIdResponse();

        Property propertyModel = new Property();
        propertyModel=propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Property", "Id", id));

        response.setId(propertyModel.getId());
        response.setAdress(propertyModel.getAdress());
        response.setFloorCount(propertyModel.getFloorCount());
        response.setPropertyType(propertyTypeService.GetById(propertyModel.getPropertyTypeId()));
        response.setOwnerid(customerService.getCustomerById(propertyModel.getId()));
        response.setRoomCount(propertyModel.getRoomCount());
        response.setPropertystatus(propertyStatusService.getPropertyStatusById(propertyModel.getPropertystatusId()));
        response.setSize(propertyModel.getSize());
        response.setEstateagentid(estateAgentService.getEstateAgentById(propertyModel.getEstateagentId()));
        response.setHeatingsystemtype(heatingSystemTypeService.getHeatingSystemTypeById(propertyModel.getHeatingsystemtypeId()));
	
        return response;
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

		response.Id = updateResult.getId();
		response.Adress = updateResult.getAdress();
		response.Size = updateResult.getSize();
		response.RoomCount = updateResult.getRoomCount();
		response.FloorCount = updateResult.getFloorCount();

		return response;
	}

	@Override
	public void deleteProperty(long id) {

		propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Property", "id", id));

		propertyRepository.deleteById(id);

	}

	@Override
	public List<PropertyGetByFilterResponse> GetPropertyByFilter(PropertyGetByFilterRequest request) {
		
		List<PropertyGetByFilterResponse> response= new ArrayList<>();
        List<Property> propertyModel=new ArrayList<>();

        Specification<Property> spec = PropertySpec.getSpec(request.RoomCount,
                        request.Size,
                        request.FloorCount,
                        request.PropertyTypeId,
                        request.HeatingSystemTypeId,
                        request.PropertyStatusId);
        propertyModel
                =propertyRepository.findAll(spec);

        for (int i=0;i<propertyModel.stream().count();i++){

            var item= new PropertyGetByFilterResponse();

            item.setId(propertyModel.get(i).getId());
            item.setAdress(propertyModel.get(i).getAdress());
            item.setFloorCount(propertyModel.get(i).getFloorCount());
            item.setPropertyType(propertyTypeService.GetById(propertyModel.get(i).getPropertyTypeId()));
            item.setOwnerid(customerService.getCustomerById(propertyModel.get(i).getId()));
            item.setRoomCount(propertyModel.get(i).getRoomCount());
            item.setPropertystatus(propertyStatusService.getPropertyStatusById(propertyModel.get(i).getPropertystatusId()));
            item.setSize(propertyModel.get(i).getSize());
            item.setEstateagentid(estateAgentService.getEstateAgentById(propertyModel.get(i).getEstateagentId()));
            item.setHeatingsystemtype(heatingSystemTypeService.getHeatingSystemTypeById(propertyModel.get(i).getHeatingsystemtypeId()));

            response.add(item);
        }

        return response;
		
	}



}
