
package model.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class HolidayType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_seq")
	private Long id;
	
	private String types;
	
	@ManyToOne
	private HolidayClient holiday;

	public HolidayType() {
		super();
	}

	public HolidayType(String types) {
		super();
		this.types = types;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public HolidayClient getHoliday() {
		return holiday;
	}

	public void setHoliday(HolidayClient holiday) {
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return "HolidayType [id=" + id + ", types=" + types + ", holiday=" + holiday + "]";
	}

	
}
