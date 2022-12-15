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
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "adress")
	private String Adress;

	@Column(name = "Room_Count")
	private int RoomCount;

	@Column(name = "Size")
	private String Size;

	@Column(name = "Floor_Count")
	private String FloorCount;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "isDeleted")
	private boolean isDeleted;
	
	@Column(name = "isPublished")
	private boolean isPublished;

	@Column(name = "CreatedDate")
	private Date CreatedDate;

	@Column(name = "UpdatedDate")
	private Date UpdatedDate;

	private long propertyTypeId;
	
	private long heatingsystemtypeId;

	private long ownerId;

	private long propertystatusId;

	private long estateagentId;
		
}
