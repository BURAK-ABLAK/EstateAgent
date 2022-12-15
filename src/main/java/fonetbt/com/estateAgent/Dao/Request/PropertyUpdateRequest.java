package fonetbt.com.estateAgent.Dao.Request;

import lombok.Data;

@Data
public class PropertyUpdateRequest {
	

	public String Adress;

	public int RoomCount;

	public String Size;

	public String FloorCount;

	public long PropertyType;

	public long HeatingSystemType;

	public long OwnerId;

	public long PropertyStatus;

	public long EstateagentId;

}
