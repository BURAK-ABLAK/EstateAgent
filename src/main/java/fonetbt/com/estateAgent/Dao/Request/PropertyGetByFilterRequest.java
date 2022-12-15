package fonetbt.com.estateAgent.Dao.Request;

import lombok.Data;

@Data
public class PropertyGetByFilterRequest {

	public String Adress;

	public int RoomCount;

	public String Size;

	public String FloorCount;

	public long PropertyTypeId;

	public long HeatingSystemTypeId;

	public long PropertyStatusId;

	
}
