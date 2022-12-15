package fonetbt.com.estateAgent.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "adress")
	private String adress;

	@Column(name = "Room_Count")
	private int roomCount;

	@Column(name = "Size")
	private String size;

	@Column(name = "Floor_Count")
	private String floorCount;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "isDeleted")
	private boolean isDeleted;

	@Column(name = "CreatedDate")
	private Date CreatedDate;

	@Column(name = "UpdatedDate")
	private Date UpdatedDate;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "property_type_id", referencedColumnName = "id")
	private PropertyType propertyType;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "heating_system_type_id", referencedColumnName = "id")
	private HeatingSystemType heatingsystemtype;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private Customer ownerid;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "property_status_id", referencedColumnName = "id")
	private PropertyStatus propertystatus;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "estateAgent_id", referencedColumnName = "id")
	private EstateAgent estateagentid;

}
