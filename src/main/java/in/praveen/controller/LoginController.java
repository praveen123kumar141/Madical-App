package in.praveen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.praveen.entity.Employee;
import in.praveen.entity.Login;
import in.praveen.repository.EmployeeRepository;

@Controller
public class LoginController {
	@Autowired
	private EmployeeRepository er;
	@GetMapping("/login")
	public String adminLogin(Model m) {
		Login l=new Login();
		m.addAttribute("loginobj", l);
		return "loginpage";
	}
	@PostMapping("/login-check")
	public String loginCheck(@ModelAttribute("loginobj")Login obj,Model m ) {
		boolean existsById = er.existsById(obj.getUserid());
		if(existsById) {
			Optional<Employee> findById = er.findById(obj.getUserid());
			if(findById.get().getEmpid()==obj.getUserid() && 
					findById.get().getPassword().equals(obj.getPass())) {
				
				if(findById.get().getType().equals("doctor")) {
					m.addAttribute("name", findById.get().getName());
					return "doctor";
				}
				
				
				if(findById.get().getType().equals("receptionist")) {
					m.addAttribute("name", findById.get().getName());
					return "receptionist";
				}
				
				
				if(findById.get().getType().equals("admin")) {
					m.addAttribute("name", findById.get().getName());
					return "admin";
				}
				
				if(findById.get().getType().equals("medical")) {
					m.addAttribute("name", findById.get().getName());
					return "medical";
				}
		
			}else {
				m.addAttribute("err","please enter valid results ");
				return "loginpage";
			}
			
	}else {
		int id=1234;
		String pass="admin";
		String name="chandu";
		if(obj.getPass().equals(pass) && id==obj.getUserid()) {
			m.addAttribute("name", name);
			return "admin";
		}else {
			m.addAttribute("err","please enter valid results ");
			return "loginpage";
		}
	}
		return "loginpage";
	}
	

}
