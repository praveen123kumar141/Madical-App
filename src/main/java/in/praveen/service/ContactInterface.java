package in.praveen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import in.praveen.entity.Contact;

public interface ContactInterface {
	public boolean savecontact(Contact contact);
	public List<Contact> getAllContacts();
	public Page<Contact> getAllContactsNew(Integer pageNo,Integer pageSize);
	public Contact getContactById(Integer contactId);
	public boolean deleteContactById(Integer contactId);
	public Boolean isContactExists(Contact contact);
	
}
