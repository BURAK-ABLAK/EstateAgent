package fonetbt.com.estateAgent.service;

import java.util.List;

import fonetbt.com.estateAgent.Dao.Request.CustomerCreateRequest;
import fonetbt.com.estateAgent.Dao.Request.CustomerUpdateRequest;
import fonetbt.com.estateAgent.Dao.Response.CustomerCreateResponse;
import fonetbt.com.estateAgent.Dao.Response.CustomerUpdateResponse;
import fonetbt.com.estateAgent.model.Customer;

public interface CustomerService {

	CustomerCreateResponse Create(CustomerCreateRequest request);

	List<Customer> getAllCustomers();

	Customer getCustomerById(long id);

	CustomerUpdateResponse updateCustomer(long id, CustomerUpdateRequest request);

	void deleteCustomer(long id);

}
