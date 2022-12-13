package fonetbt.com.estateAgent.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="estateAgents")
public class EstateAgent{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="officer_id",referencedColumnName = "id")
	private Customer officerId;
	
	@Column(name="Adress")
	private String adress;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Fax")
	private String fax ;
	
	@Column(name="isActive")
	private boolean isActive ;
	
	@Column(name="isDeleted")
	private boolean isDeleted ;
	
	@Column(name="CreatedDate")
	private Date CreatedDate ;
	
	@Column(name="UpdatedDate")
	private Date UpdatedDate ;
	
	
}
