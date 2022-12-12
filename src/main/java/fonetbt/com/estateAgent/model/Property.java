package fonetbt.com.estateAgent.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	
	@Column(name="adress")
	private String adress;
	
	@Column(name="Room_Count")
	private int roomCount;
	
	@Column(name="Size")
	private String size;
	
	@Column(name="Floor_Count")
	private String floorcount;
	
	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name="property_type_id",referencedColumnName = "id")
	private PropertyType propertyType;
	
	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name="heating_system_type_id",referencedColumnName = "id")
	private HeatingSystemType heatingsystemtype;
	
	
	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name="owner_id",referencedColumnName = "id")
	private Customer ownerid;
	
	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name="property_status_id",referencedColumnName = "id")
	private PropertyStatus propertystatus;
	
	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name="estateAgent_id",referencedColumnName = "id")
	private EstateAgent estateagentid;
}
