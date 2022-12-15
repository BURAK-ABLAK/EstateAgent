package fonetbt.com.estateAgent.Dao.Response;

import fonetbt.com.estateAgent.model.Customer;
import fonetbt.com.estateAgent.model.EstateAgent;
import fonetbt.com.estateAgent.model.HeatingSystemType;
import fonetbt.com.estateAgent.model.PropertyStatus;
import fonetbt.com.estateAgent.model.PropertyType;

public class PropertyUpdateResponse {

	public long id;

	public String adress;

	public int roomCount;

	public String size;

	public String floorCount;

	public PropertyType propertyType;

	public HeatingSystemType heatingsystemtype;

	public Customer ownerid;

	public PropertyStatus propertystatus;

	public EstateAgent estateagentid;
}
