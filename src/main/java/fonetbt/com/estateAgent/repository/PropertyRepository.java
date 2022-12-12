package fonetbt.com.estateAgent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fonetbt.com.estateAgent.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
