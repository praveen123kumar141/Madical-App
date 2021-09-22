package in.praveen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.praveen.repository.MedicalRepository;

@Controller
public class MadicalController {
	
	@Autowired
	private MedicalRepository mr;
	
	@GetMapping("/get-all-patient-madicaldetails")
	public String PatientMadical(Model m) {
		m.addAttribute("madical", mr.findAll());
		return "madical";
	}
	@GetMapping("/deleterecord")
	public String softdeleteContactById1(@RequestParam("	id")Integer contactId) {
		 mr.deleteById(contactId);

		return"madical";
	}

}
