package in.praveen.entity;

import javax.persistence.*;
import javax.persistence.Id;
@Entity
public class DoctorSugg {
	
	@Id
	@GeneratedValue
	private Integer suggid;
	private Integer pId;
	private String sugg;
	private String pre;
	private String date;
	public Integer getSuggid() {
		return suggid;
	}
	public void setSuggid(Integer suggid) {
		this.suggid = suggid;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getSugg() {
		return sugg;
	}
	public void setSugg(String sugg) {
		this.sugg = sugg;
	}
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
