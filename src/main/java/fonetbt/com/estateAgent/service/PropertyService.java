package fonetbt.com.estateAgent.service;

import java.util.List;

import fonetbt.com.estateAgent.Dao.Request.PropertyCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyGetByFilterRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.PropertyCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyGetByFilterResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyGetByIdResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyUpdateResponse;
import fonetbt.com.estateAgent.model.Property;

public interface PropertyService {

	PropertyCreateResponse Create(PropertyCreateRequest request);

	List<Property> getAllPropertys();
	
	PropertyGetByIdResponse getPropertyById(long id);

	List<PropertyGetByFilterResponse> GetPropertyByFilter(PropertyGetByFilterRequest request);

	PropertyUpdateResponse updateProperty(long id, PropertyUpdateRequest request);

	void deleteProperty(long id);

}
