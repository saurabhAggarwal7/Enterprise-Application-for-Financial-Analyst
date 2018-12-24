/**
 * 
 */
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sowndhariyanandarajkumar
 *
 */

@Controller
public class BaseController {
	
	@Autowired
	faqController faqctrl;
	@Autowired
	UserController userctr;

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
		return "landing";
    }
	
	@RequestMapping(value = "/landing", method = RequestMethod.GET)
    public String logout() {
		return "landing";
    }
	
	
	@RequestMapping(value = "/landing1", method = RequestMethod.GET)
    public String landing() {
		return "landing";
    }
	
	
	
	@RequestMapping(value = "/adminpage", method = RequestMethod.GET)
    public String adminpage() {
		return "adminpage";
    }
	
	

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String roles(Model model,@RequestParam(value="name", required=false) String name) {
		return "roles";
    }
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
		return "index";
    }
	
	@RequestMapping(value= "/charts", method = RequestMethod.GET)
	public String charts(Model model,@RequestParam(value="name", required=false, defaultValue="sound.amtha@gmail.com") String name) {
		/* List<Users> users =userctr.getAllUsers();
		 for (int counter = 0; counter < users.size(); counter++) { 
			 if(name.equalsIgnoreCase(users.get(counter).getFirstname()))
			 {
				 model.addAttribute("username",users.get(counter).getFirstname());
			 }
			 System.out.println(users.get(counter).getFirstname());
		 }*/
		 
		 
	    return "charts";
	}

	
	@RequestMapping(value= "/signup", method = RequestMethod.GET)
	public String signup() {
	    return "signup";
	}
	
	
	@RequestMapping(value= "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}
	
	
	
	    
	@RequestMapping(value= "/faq", method = RequestMethod.GET)
	public String faq(Model model) {
		 List<faq> products = faqctrl.getAllFAQ();
		for (int counter = 0; counter < products.size(); counter++) { 		      
			model.addAttribute("q"+counter,products.get(counter).getQuestions());
			 model.addAttribute("ans"+counter,products.get(counter).getAnswers());
	      }   
		
		
	    return "faq";
	}
	
	@RequestMapping(value= "/info", method = RequestMethod.GET)
	public String info() {
	    return "info";
	}
	
	@RequestMapping(value= "/notes", method = RequestMethod.GET)
	public String notes() {
	    return "notes";
	}

	
	@RequestMapping(value= "/tables", method = RequestMethod.GET)
	public String tables() {
	    return "tables";
	}
	
	@RequestMapping(value= "/sound", method = RequestMethod.GET)
	public String sound() {
	    return "sound";
	}


	@RequestMapping(value= "/linkedIn", method = RequestMethod.GET)
	public String Linkedin() {
	    return "linkedIn";
	}
	
	
	@RequestMapping(value= "/userdashboard", method = RequestMethod.GET)
	public String userdashboard() {
	    return "userdashboard";
	}
	

	@RequestMapping(value= "/userfaq", method = RequestMethod.GET)
	public String userfaq(Model model) {
		 List<faq> products = faqctrl.getAllFAQ();
			for (int counter = 0; counter < products.size(); counter++) { 		      
				model.addAttribute("q"+counter,products.get(counter).getQuestions());
				 model.addAttribute("ans"+counter,products.get(counter).getAnswers());
		      }   
	    return "userfaq";
	}
	

	@RequestMapping(value= "/userinfo", method = RequestMethod.GET)
	public String userinfo() {
	    return "userinfo";
	}
	
	
	

	@RequestMapping(value= "/otherpage", method = RequestMethod.GET)
	public String otherpage() {
	    return "otherpage";
	}
}

