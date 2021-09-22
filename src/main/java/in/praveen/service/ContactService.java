package in.praveen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.praveen.entity.Contact;
import in.praveen.repository.ContactRepository;

@Service
public class ContactService implements ContactInterface {

	@Autowired
	private ContactRepository cr;
	private Optional<Contact> findById;

	@Override
	public boolean savecontact(Contact contact) {
		// TODO Auto-generated method stub
	
		contact.setActiveSw("Y");
		Contact savedEntity = cr.save(contact);
		if (savedEntity != null && savedEntity.getContactId() != null) {
			return true;
		}
		return false;
	}
	/*implementing filtering(use Example-> means dynamic queary creation
	 *  another name is queary by example
	 */
	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		Contact contactfilter=new Contact();
		contactfilter.setActiveSw("Y");
		Example<Contact> example=Example.of(contactfilter);
		List<Contact> getallcontactslist = cr.findAll(example);
		return getallcontactslist;
	}
	//implement pagination
	/*implementing filtering(use Example-> means dynamic queary creation
	 *  another name is queary by example
	 */
	@Override
	public Page<Contact> getAllContactsNew(Integer pageNo,Integer pageSize) {
		// TODO Auto-generated method stub
		Contact contactfilter=new Contact();
		contactfilter.setActiveSw("Y");
		
		Example<Contact> example=Example.of(contactfilter);
		
		PageRequest request = PageRequest.of(pageNo, pageSize);
		
		Page<Contact> getallcontactslist = cr.findAll(example, request);
		
		return getallcontactslist;
	}
	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		 Optional<Contact> getById = cr.findById(contactId);
		if(getById.isPresent()) {
			return getById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		// hard delete
		/*boolean existsById = cr.existsById(contactId);
		if(existsById) {
			cr.deleteById(contactId);
			return true;
		}
		return false;*/
		
		//soft delete
		Optional<Contact> contactobj = cr.findById(contactId);
		if(contactobj.isPresent()) {
			Contact contact=contactobj.get();
			contact.setActiveSw("N");
			cr.save(contact);
			return true;
		}
		return false;
	}
	@Override
	public Boolean isContactExists(Contact contact) {
		Example<Contact> example = Example.of(contact);
		return cr.exists(example);
	}
}
