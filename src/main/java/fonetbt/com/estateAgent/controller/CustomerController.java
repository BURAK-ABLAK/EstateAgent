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

import fonetbt.com.estateAgent.Dao.Request.CustomerCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.CustomerUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.CustomerCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.CustomerUpdateResponse;
import fonetbt.com.estateAgent.model.Customer;
import fonetbt.com.estateAgent.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	// build create
	@PostMapping
	public ResponseEntity<CustomerCreateResponse> Create(@RequestBody CustomerCreateRequest request) {
		return new ResponseEntity<CustomerCreateResponse>(customerService.Create(request), HttpStatus.CREATED);
	}

	// build get all
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// build get by id
	// http://localhost:8080/api/customers/1-2-3-...etc
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	// build update
	// http://localhost:8080/api/customers/1-2-3-...etc
	@PutMapping("{id}")
	public ResponseEntity<CustomerUpdateResponse> updateCustomer(@PathVariable("id") long id,
			@RequestBody CustomerUpdateRequest request) {
		return new ResponseEntity<CustomerUpdateResponse>(customerService.updateCustomer(id, request), HttpStatus.OK);
	}

	// build delete
	// http://localhost:8080/api/customers/1-2-3-...etc
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);

		return new ResponseEntity<String>("Customer deleted success!", HttpStatus.OK);
	}
}
