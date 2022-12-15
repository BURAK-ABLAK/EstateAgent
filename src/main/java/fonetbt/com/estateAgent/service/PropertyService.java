package fonetbt.com.estateAgent.service;

import java.util.List;

import fonetbt.com.estateAgent.Dao.Request.PropertyCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.PropertyCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyUpdateResponse;
import fonetbt.com.estateAgent.model.Property;

public interface PropertyService {

	PropertyCreateResponse Create(PropertyCreateRequest request);

	List<Property> getAllPropertys();

	Property getPropertyById(long id);

	PropertyUpdateResponse updateProperty(long id, PropertyUpdateRequest request);

	void deleteProperty(long id);

}
