package in.praveen.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.praveen.constants.AppConstants;
import in.praveen.entity.Contact;
import in.praveen.service.ContactService;

@Controller 
public class ContactController {

	@Autowired
	private ContactService cs;
	@GetMapping("/")
	public String home() {
		return "Home";
	}
	@GetMapping("/loadform")
	public String loadform(Model m) {
		Contact obj=new Contact();
		m.addAttribute("prob", new String[] {"Cardiologist"," Audiologist",
		"Dentist","ENT specialist","Gynaecologist","Orthopaedic","Neurologist"});
		m.addAttribute("contact", obj);
		return AppConstants.CONTACT;
	}
	@PostMapping("/savecontact")
	public String saveContact(@Valid Contact contact, BindingResult result,Model m) {
		if (result.hasErrors()) {
			return AppConstants.CONTACT;
		}
		Boolean contactExists = cs.isContactExists(contact);
		if(contactExists) {
			m.addAttribute("errmsg", "contact is already exhists");
		}
		else {
			boolean savecontact = cs.savecontact(contact);
			if(savecontact) {
				m.addAttribute("succmsg","contact is saved successfully");
			}else {
				m.addAttribute("errmsg", "faild to save contact");
			}
		}
		return AppConstants.CONTACT;
	}
	@GetMapping("/viewContacts")
	
	public ModelAndView getAllContacts(HttpServletRequest req) {
		Integer pageSize=3;
		Integer pageNo=1;
		//read the pno from the url use the HttpServletRequest req ->object
		//and req.getParameter("pno")-> used to get the pno value from the url
		String reqparam = req.getParameter("pno");
		if(reqparam!=null && !"".equals(reqparam)) {
			pageNo=Integer.parseInt(reqparam);
		}
		
		Page<Contact> pageobj = cs.getAllContactsNew(pageNo-1, pageSize);
		
		int totalpages=pageobj.getTotalPages();
		
		ModelAndView mav=new ModelAndView();
		
		List<Contact> allContacts = pageobj.getContent();
		
		mav.addObject("contacts", allContacts);
		
		mav.addObject("tp", totalpages);
		
		mav.addObject("currPno", pageNo);
		
		mav.setViewName("viewcontacts");
		
		return mav;
	}
	@GetMapping("/aboutus")
	public String abouters() {
		return "aboutus";
	}
}
