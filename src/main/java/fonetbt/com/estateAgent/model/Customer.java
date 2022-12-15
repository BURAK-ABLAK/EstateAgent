package fonetbt.com.estateAgent.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "SurName")
	private String surname;

	@Column(name = "Adress")
	private String adress;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Email")
	private String email;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "isDeleted")
	private boolean isDeleted;

	@Column(name = "CreatedDate")
	private Date CreatedDate;

	@Column(name = "UpdatedDate")
	private Date UpdatedDate;
}
