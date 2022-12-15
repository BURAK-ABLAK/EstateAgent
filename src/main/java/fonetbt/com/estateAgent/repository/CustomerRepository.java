package fonetbt.com.estateAgent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fonetbt.com.estateAgent.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
