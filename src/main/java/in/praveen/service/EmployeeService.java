package in.praveen.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.praveen.entity.Contact;
import in.praveen.entity.Employee;
import in.praveen.repository.EmployeeRepository;


@Service
public class EmployeeService implements EmployeeInterface {
	private JavaMailSender javamailsender;
	@Autowired
	private EmployeeRepository er;
	private Optional<Employee> findById;
	@Autowired
	public EmployeeService(JavaMailSender javamailsender) {
		this.javamailsender=javamailsender;
	}
	
	@Override
	public boolean savecontact(Employee emp) {
		// TODO Auto-generated method stub
		emp.setPassword(randompassword());
		Employee save = er.save(emp);
		if(save.getEmpid()!=null) {
			String sub="Your Login Credentials for xyz hospital are Activated";
			sendNotification(emp,sub);
			return true;
		}return false;
		
	}

	@Override
	public List<Employee> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Employee> getAllContactsNew(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		PageRequest request = PageRequest.of(pageNo, pageSize);
		
		Page<Employee> getallemplist = er.findAll(request);
		
		return getallemplist;
	}


	public Employee getContactById(Integer empid) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = er.findById(empid);
		return findById.get();
	}

	@Override
	public boolean deleteContactById(int empid) {
		// TODO Auto-generated method stub
			boolean existsById = er.existsById(empid);
			Optional<Employee> emp=er.findById(empid);
			er.deleteById(empid);
			String sub="Your Login Credentials for xyz hospital are De-activated";
			sendNotification(emp.get(),sub);
		return existsById;
	}

	@Override
	public Boolean isContactExists(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String randompassword() {
		
	       int n=8;
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz";
	        StringBuilder sb = new StringBuilder(n);
	        for (int i = 0; i < n; i++)
	        {
	        	int index = (int)(AlphaNumericString.length()* Math.random());
	            sb.append(AlphaNumericString.charAt(index));
	        }
	        return sb.toString();
}
public void sendNotification(Employee e,String sub) throws MailException {
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(e.getEmail());
		//mail.setFrom("xyzhospital6@gmail.com");
		mail.setCc("xyzhospital6@gmail.com","natanipraveenkumar@gmail.com");
		mail.setSubject(sub);
		mail.setText("Dear "+e.getName()+",\r\n"
				+ "\r\n"
				+"Your user id:"+e.getEmail()+"\r\n"
				+"\r\n"
				+ "Your temparery password is : " +e.getPassword()+ "\r\n"
				);
		javamailsender.send(mail);
	}
	

	

}
