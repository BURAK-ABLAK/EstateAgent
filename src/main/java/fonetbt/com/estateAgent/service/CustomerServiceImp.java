package fonetbt.com.estateAgent.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import fonetbt.com.estateAgent.Dao.Request.CustomerCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.CustomerUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.CustomerCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.CustomerUpdateResponse;
import fonetbt.com.estateAgent.exeption.ResourceNotFoundExeption;
import fonetbt.com.estateAgent.model.Customer;
import fonetbt.com.estateAgent.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImp(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerCreateResponse Create(CustomerCreateRequest request) {
		CustomerCreateResponse response = new CustomerCreateResponse();

		Customer customer = new Customer();

		customer.setName(request.getName());
		customer.setSurname(request.getSurname());
		customer.setAdress(request.getAdress());
		customer.setPhone(request.getPhone());
		customer.setEmail(request.getEmail());
		customer.setActive(true);
		customer.setCreatedDate(Calendar.getInstance().getTime());

		Customer createResult = customerRepository.save(customer);

		response.Id = createResult.getId();
		return response;
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {

		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Customer", "Id", id));

	}

	@Override
	public CustomerUpdateResponse updateCustomer(long id, CustomerUpdateRequest request) {

		CustomerUpdateResponse response = new CustomerUpdateResponse();

		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Customer", "Id", id));

		existingCustomer.setName(request.getName());
		existingCustomer.setSurname(request.getSurname());
		existingCustomer.setAdress(request.getAdress());
		existingCustomer.setPhone(request.getPhone());
		existingCustomer.setEmail(request.getEmail());
		existingCustomer.setActive(true);
		existingCustomer.setUpdatedDate(Calendar.getInstance().getTime());

		Customer updateResult = customerRepository.save(existingCustomer);

		response.Id = updateResult.getId();
		response.Name = updateResult.getName();
		response.Adress = updateResult.getAdress();
		response.Phone = updateResult.getPhone();
		response.Email = updateResult.getEmail();

		return response;
	}

	@Override
	public void deleteCustomer(long id) {

		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Customer", "id", id));

		customerRepository.deleteById(id);

	}

}
