package fonetbt.com.estateAgent.Dao.Request;

import lombok.Data;

@Data
public class EstateAgentCreateRequest {

	private String Name;

	private long OfficerId;

	private String Adress;

	private String Phone;

	private String Fax;

}
