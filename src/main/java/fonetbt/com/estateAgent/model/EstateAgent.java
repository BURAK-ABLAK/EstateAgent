package fonetbt.com.estateAgent.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="EstateAgent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EstateAgent {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="officer_id",referencedColumnName = "id")
	private int officerId;
	
	@Column(name="Adress")
	private String adress;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Fax")
	private String fax ;
	
}
