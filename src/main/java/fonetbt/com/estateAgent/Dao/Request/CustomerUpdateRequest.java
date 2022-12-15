package fonetbt.com.estateAgent.Dao.Request;

import lombok.Data;

@Data
public class CustomerUpdateRequest {

	private String Name;

	private String Surname;

	private String Adress;

	private String Phone;

	private String Email;

}
