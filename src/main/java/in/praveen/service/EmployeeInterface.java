package in.praveen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import in.praveen.entity.Contact;
import in.praveen.entity.Employee;

public interface EmployeeInterface {
	
	public boolean savecontact(Employee emp);
	public List<Employee> getAllContacts();
	public Page<Employee> getAllContactsNew(Integer pageNo,Integer pageSize);
	
	public Boolean isContactExists(Employee emp);
	Employee getContactById(Integer empid);
	boolean deleteContactById(int empid);

}
