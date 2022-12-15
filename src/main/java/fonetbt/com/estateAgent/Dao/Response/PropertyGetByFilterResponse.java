package fonetbt.com.estateAgent.Dao.Response;

import fonetbt.com.estateAgent.model.Customer;
import fonetbt.com.estateAgent.model.EstateAgent;
import fonetbt.com.estateAgent.model.HeatingSystemType;
import fonetbt.com.estateAgent.model.PropertyStatus;
import fonetbt.com.estateAgent.model.PropertyType;
import lombok.Data;

@Data
public class PropertyGetByFilterResponse {
	

	public Long id;


	public String Adress;


	public int RoomCount;

	
	public String Size;

	
	public String FloorCount;


	public PropertyType propertyType;
	

	public HeatingSystemType heatingsystemtype;
	

	public Customer ownerid;
	

	public PropertyStatus propertystatus;
	

	public EstateAgent estateagentid;
		

}
