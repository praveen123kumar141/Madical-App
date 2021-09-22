package in.praveen.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.praveen.entity.Contact;
import in.praveen.entity.DoctorPre;
import in.praveen.entity.DoctorSugg;
import in.praveen.entity.Id;
import in.praveen.entity.madical;
import in.praveen.repository.DoctorSuggRepo;
import in.praveen.repository.MedicalRepository;
import in.praveen.service.Doctor;

@Controller
public class DoctorController {
	@Autowired
	private Doctor d;
	@Autowired
	private DoctorSuggRepo ds;
	@Autowired
	private MedicalRepository mr;
	@GetMapping("/doctor-search-page")
	public String LoadDoctorform(Model m) {
		
		m.addAttribute("contact", new Id());
		return "doctorform";
		
	}
	@PostMapping("/getdata")
	public String getDataOfPatient(@ModelAttribute("contact")Id pid,Model m) {
		
		boolean exhistById = d.exhistById(pid.getId());
		if(exhistById) {
			Contact details = d.getDetails(pid.getId());
			//m.addAttribute("madicin", new DoctorPre());
			m.addAttribute("contact",details );
			DoctorSugg dobj=new DoctorSugg();
			String sd=new Date().toString();
			System.out.println(sd);
			dobj.setDate(sd);
			dobj.setpId(details.getContactId());
			List<DoctorSugg> ld=ds.findAll();
			/*
			 * Iterator iterator = ld.iterator(); while(iterator.hasNext()) {
			 * System.out.println(iterator.next().); }
			 */
			List<DoctorSugg> ld1=new ArrayList();
			for(DoctorSugg s:ld){
				if(s.getpId()==pid.getId())
					ld1.add(s);
			}
			m.addAttribute("suggessions", ld1);
			m.addAttribute("suggn",dobj );
			return "doctorfeedback";
		}
		else {
			return "doctorform";
		}
	}
	@GetMapping("/feedbackpage")
	public String feedback(Model m) {
		DoctorSugg dobj=new DoctorSugg();
		m.addAttribute("suggn", dobj);
		return "doctorproceed";
	}
	@PostMapping("/save-doct-sugg")
	public String stirePrecription(@ModelAttribute("suggn")DoctorSugg dobj,Model m) {
		String sd=new Date().toString();
		System.out.println(sd);
		dobj.setDate(sd);
		//madical mobj=new madical();
		if(dobj.getpId()!=null && !(dobj.getPre().isEmpty()) && !(dobj.getSugg().isEmpty())) {
			ds.save(dobj);
			madical mobj=new madical();
			mobj.setDate(dobj.getDate());
			mobj.setpId(dobj.getpId());
			mobj.setPre(dobj.getPre());
			mr.save(mobj);
			m.addAttribute("succ","reord inserted successfully");
			
			return "doctorproceed";
		}else {
			m.addAttribute("err", "record is not inserted please fill valid details");
			return "doctorproceed";
		}
		
	}
	@GetMapping("/welcome-doctor")
	public String addsuggessions() {
		return "doctorwelcome";
	}
	
}
