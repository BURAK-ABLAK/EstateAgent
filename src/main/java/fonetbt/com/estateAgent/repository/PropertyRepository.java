package fonetbt.com.estateAgent.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fonetbt.com.estateAgent.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
	List<Property> findAll(Specification<Property> spec);
}
