package model.client;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class HolidayClient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_seq")
	private Long id;

	private String date;
	private String localName;
	private String name;
	private String countryCode;
	private boolean global;
	private int year;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "holiday_id")
	private List<HolidayType> types;

	public HolidayClient() {
		super();
	}

	public HolidayClient(Long id, String date, String localName, String name, String countryCode, boolean global,
			int year, List<HolidayType> types) {
		super();
		this.id = id;
		this.date = date;
		this.localName = localName;
		this.name = name;
		this.countryCode = countryCode;
		this.global = global;
		this.year = year;
		this.types = types;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<HolidayType> getTypes() {
		return types;
	}

	public void setTypes(List<HolidayType> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "HolidayClient [id=" + id + ", date=" + date + ", localName=" + localName + ", name=" + name
				+ ", countryCode=" + countryCode + ", global=" + global + ", year=" + year + ", types=" + types + "]";
	}

}