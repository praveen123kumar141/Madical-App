package in.praveen.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.praveen.constants.AppConstants;
import in.praveen.entity.Contact;
import in.praveen.entity.Employee;
import in.praveen.service.EmployeeService;

@Controller
public class EmpController {
	
@Autowired
private EmployeeService es;

@GetMapping("/add-new-employee")
public String loadform(Model m) {
	Employee emp=new Employee();
	m.addAttribute("contact", emp);
	return AppConstants.EMPCONTACT;
}
@PostMapping("/save-employee")
public String AddNewEmployee(@ModelAttribute("contact") Employee contact,Model m) {
	
	boolean savecontact = es.savecontact(contact);
	if(savecontact)
		m.addAttribute("succ", "record insert successfully");
	else 
		m.addAttribute("err", "record not inserted successfully");
	
	return AppConstants.EMPCONTACT;
}
@GetMapping("/get-all-employees")
public String getAllEmployees(HttpServletRequest req,Model m) {
	Integer pageSize=3;
	Integer pageNo=1;
	//read the pno from the url use the HttpServletRequest req ->object
	//and req.getParameter("pno")-> used to get the pno value from the url
	String reqparam = req.getParameter("pno");
	if(reqparam!=null && !"".equals(reqparam)) {
		pageNo=Integer.parseInt(reqparam);
	}
	
	Page<Employee> pageobj = es.getAllContactsNew(pageNo-1, pageSize);
	
	int totalpages=pageobj.getTotalPages();
	
	
	List<Employee> allContacts = pageobj.getContent();
	m.addAttribute("contacts", allContacts);
	m.addAttribute("tp", totalpages);
	m.addAttribute("currPno", pageNo);
	
	//mav.addObject("contacts", allContacts);
	
	//mav.addObject("tp", totalpages);
	
	//mav.addObject("currPno", pageNo);
	
	//mav.setViewName("viewcontacts");
	
	return "viewemployes";
}
@GetMapping("/editempcontact")
public String editcontactDetails(@RequestParam("empid")Integer empid,Model m) 
{
	Employee contactById = es.getContactById(empid);
	//Contact getcontactobj = cs.getContactById(ContactId);
	/*mav.addObject("contact", getcontactobj);
	mav.setViewName("contact");*/
	m.addAttribute("contact", contactById);
	return AppConstants.EMPCONTACT;
}
@GetMapping("/deleteempcontact")
public String softdeleteContactById(@RequestParam("empid")Integer empid) {
	boolean deleteContactById = es.deleteContactById(empid);

	return "redirect:get-all-employees";
}

}
