package crud.springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private int code;
	private String designation;
	private String createBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	@Column(name = "created_Date")
	private String createdDate;
	
	private String updatedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	@Column(name = "updated_Date")
	public String updatedDate;
	private boolean isActive;
	
	public Employee() {
		
		
	}

	public Employee(int id, String firstName, String lastName, int code, String designation, String createBy,
			String createdDate, String updatedBy, String updatedDate,boolean isActive) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.designation = designation;
		this.createBy = createBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setisActive(boolean isActive) {
		this.isActive=isActive;
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", code=" + code
				+ ", designation=" + designation + ", createBy=" + createBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}

	
	


}
