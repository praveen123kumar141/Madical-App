package in.praveen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.praveen.entity.Contact;
import in.praveen.repository.ContactRepository;
import in.praveen.service.ContactService;

@Controller
public class EditContactController {
	@Autowired
	private ContactService cs;
	@Autowired
	private ContactRepository cr;
	@GetMapping("/editcontact")
	public ModelAndView editcontactDetails(@RequestParam("cid")Integer ContactId) 
	{
		ModelAndView mav=new ModelAndView();
		Contact getcontactobj = cs.getContactById(ContactId);
		mav.addObject("contact", getcontactobj);
		mav.setViewName("contact");
		return mav;
	}
	// Hard delete
	/*@GetMapping("/deletecontact")
	public String deleteContactById(@RequestParam("cid")Integer contactId) {
		cs.deleteContactById(contactId);
		return"redirect:viewContacts";
	}*/
	// soft delete
	@GetMapping("/deletecontact")
	public String softdeleteContactById(@RequestParam("cid")Integer contactId) {
		boolean deleteContactById = cs.deleteContactById(contactId);

		return"redirect:viewContacts";
	}
}
