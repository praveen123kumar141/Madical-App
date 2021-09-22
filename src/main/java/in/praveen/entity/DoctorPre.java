package in.praveen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorPre {
	@Id
	Integer id;
	Integer pid;
	String madicin;
	String nextapp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getMadicin() {
		return madicin;
	}
	public void setMadicin(String madicin) {
		this.madicin = madicin;
	}
	public String getNextapp() {
		return nextapp;
	}
	public void setNextapp(String nextapp) {
		this.nextapp = nextapp;
	}
	
	

}
