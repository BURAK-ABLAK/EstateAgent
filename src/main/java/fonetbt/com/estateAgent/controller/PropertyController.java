package fonetbt.com.estateAgent.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fonetbt.com.estateAgent.Dao.Request.PropertyCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyGetByFilterRequest;
import fonetbt.com.estateAgent.Dao.Request.PropertyUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.PropertyCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyGetByFilterResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyGetByIdResponse;
import fonetbt.com.estateAgent.Dao.Response.PropertyUpdateResponse;
import fonetbt.com.estateAgent.model.Property;
import fonetbt.com.estateAgent.service.PropertyService;

@RestController
@RequestMapping("/api/propertys")
public class PropertyController {

	private PropertyService propertyService;

	public PropertyController(PropertyService propertyService) {
		super();
		this.propertyService = propertyService;
	}

	// build create
	@PostMapping
	public ResponseEntity<PropertyCreateResponse> Create(@RequestBody PropertyCreateRequest request) {
		return new ResponseEntity<PropertyCreateResponse>(propertyService.Create(request), HttpStatus.CREATED);
	}

	// build get all
	@GetMapping
	public List<Property> getAllProperty() {
		return propertyService.getAllPropertys();
	}

	// build get by id
	// http://localhost:8080/api/propertys/1-2-3-...etc
	@GetMapping("{id}")
	public ResponseEntity<PropertyGetByIdResponse> getPropertyById(@PathVariable("id") long propertyId) {
		return new ResponseEntity<PropertyGetByIdResponse>(propertyService.getPropertyById(propertyId), HttpStatus.OK);
	}

	@PostMapping("/getbyfilter")
	public List<PropertyGetByFilterResponse> getPropertyByFilter(@RequestBody PropertyGetByFilterRequest request) {
		return propertyService.GetPropertyByFilter(request);

	}

	// build update
	// http://localhost:8080/api/propertys/1-2-3-...etc
	@PutMapping("{id}")
	public ResponseEntity<PropertyUpdateResponse> updateProperty(@PathVariable("id") long id,
			@RequestBody PropertyUpdateRequest request) {
		return new ResponseEntity<PropertyUpdateResponse>(propertyService.updateProperty(id, request), HttpStatus.OK);
	}

	// build delete
	// http://localhost:8080/api/propertys/1-2-3-...etc
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProperty(@PathVariable("id") long id) {
		propertyService.deleteProperty(id);

		return new ResponseEntity<String>("Property deleted success!", HttpStatus.OK);
	}

}
