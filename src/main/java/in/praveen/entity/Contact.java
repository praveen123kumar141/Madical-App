package in.praveen.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Patient_contact")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@NotEmpty(message="Number is mandatory")
	@Column(name="AadharNo")
	private String aadharno;
	
	@Column(name="CONTACT_NAME")
	@NotEmpty(message = "Name Is Mandatory")
	private String contactName;
	
	@Column(name="Gender")
	@NotEmpty(message = "gender is mandatory")
	private String gender;
	
	@NotEmpty(message="Mobile Number is mandatory")
	@Pattern(regexp="^[6-9]\\d{9}$",message = "please enter valid mobile number")
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="City")
	@NotEmpty(message = "city Is Mandatory")
	private String city;
	
	@Column(name="State")
	@NotEmpty(message = "State Is Mandatory")
	private String state;
	
	@Column(name="Country")
	@NotEmpty(message = "Country Is Mandatory")
	private String country;
	
	@Column(name="Problem")
	@NotEmpty(message = "Problem Is Mandatory")
	private String problem;
	
	@Column(name="Active_SW")
	private String activeSw;
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable = false)
	private LocalDate createDate;
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",insertable = false)
	private LocalDate updateDate;
	
	public String getActiveSw() {
		return activeSw;
	}
	

	
	public String getProblem() {
		return problem;
	}



	public void setProblem(String problem) {
		this.problem = problem;
	}
	


	public String getAadharno() {
		return aadharno;
	}



	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}






	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	
	public Integer getContactId() {
		return contactId;
	}



	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}



	public String getContactName() {
		return contactName;
	}



	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	

	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public LocalDate getCreateDate() {
		return createDate;
	}



	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}



	public LocalDate getUpdateDate() {
		return updateDate;
	}



	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}

	



}

