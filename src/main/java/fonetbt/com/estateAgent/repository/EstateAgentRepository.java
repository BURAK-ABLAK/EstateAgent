package fonetbt.com.estateAgent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fonetbt.com.estateAgent.model.EstateAgent;

@Repository
public interface EstateAgentRepository extends JpaRepository<EstateAgent,Long> {
	
}
