package fonetbt.com.estateAgent.Dao.Request;

import fonetbt.com.estateAgent.model.Customer;
import fonetbt.com.estateAgent.model.EstateAgent;
import fonetbt.com.estateAgent.model.HeatingSystemType;
import fonetbt.com.estateAgent.model.PropertyStatus;
import fonetbt.com.estateAgent.model.PropertyType;
import lombok.Data;

@Data
public class PropertyCreateRequest {
	

	private String adress;

	private int roomCount;

	private String size;

	private String floorCount;

	private PropertyType propertyType;

	private HeatingSystemType heatingsystemtype;

	private Customer ownerid;

	private PropertyStatus propertystatus;

	private EstateAgent estateagentid;

}
