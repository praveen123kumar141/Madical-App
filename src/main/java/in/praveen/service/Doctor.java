package in.praveen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.praveen.entity.Contact;
import in.praveen.entity.Employee;
import in.praveen.repository.ContactRepository;

@Service
public class Doctor {
	
	@Autowired
	private ContactRepository  cr;
	
	public Contact getDetails(int pid) {
		
		Optional<Contact> findById = cr.findById(pid);
		return findById.get();
		
	}
	public boolean exhistById(Integer pid) {
		boolean existsById = cr.existsById(pid);
		if(existsById)
			return true;
	return false;
	}
}
