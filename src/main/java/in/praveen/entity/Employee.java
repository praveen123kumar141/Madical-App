package in.praveen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="EmployeeId")
	private Integer empid;
	
	@NotEmpty(message="name is not null")
	@Column(name="Employee_Name")
	private String name;
	
	//@NotEmpty(message="email is mandatory")
	@Column(name="Email")
	private String email;
	
	//@NotEmpty(message="password is mandatory")
	@Column(name="Password")
	private String password;
	
	//@NotEmpty(message="Employee type is mandatory")
	@Column(name="Type_Of_Employee")
	private String type;
	
	//@Size(min = 0, max = 23, message = "Name must be between 2 and 32 characters long") 
	@Column(name="work_Start_time")
	private Integer stime;
	
	//@Min(value=0)
	//@Max(value=23)
	@Column(name="Work_End_time")
	private Integer etime;
	
	@Column(name="Word_Number")
	private Integer wno;
	
	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStime() {
		return stime;
	}

	public void setStime(Integer stime) {
		this.stime = stime;
	}

	public Integer getEtime() {
		return etime;
	}

	public void setEtime(Integer etime) {
		this.etime = etime;
	}

	public Integer getWno() {
		return wno;
	}

	public void setWno(Integer wno) {
		this.wno = wno;
	}

	public String getTyofocc() {
		return tyofocc;
	}

	public void setTyofocc(String tyofocc) {
		this.tyofocc = tyofocc;
	}

	@Column(name="Type_Of_Occupation")
	private String tyofocc;


	
	
}
