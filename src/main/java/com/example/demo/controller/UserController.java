
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.FeedBackService;
import com.example.demo.Service.SendEmailService;
import com.example.demo.Service.UserService;
import com.example.demo.model.FeedBack;

import com.example.demo.model.SendEmails;
import com.example.demo.model.User;
import com.example.demo.repository.FeedBackRepository;
import com.example.demo.repository.SendEmailRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FeedBackService feedbackService;
	@Autowired
	private FeedBackRepository feedBackRepo;
	@Autowired
	private SendEmailService sendEmailService;
	@Autowired
	private SendEmailRepository sendEmailRepo;

	@GetMapping("registration")
	public String Registration() {
		return "register";
	}

	@PostMapping("/saveuser")
	public String Stringsaveuser(User user) {
		if (user != null) {
			if (userRepository.existsByemail(user.getEmail())) {
				return "User Already exists By Email Id  !!!!!!!!!!!";
			}
			if (userRepository.existsByUsername(user.getUsername())) {
				return "User Already Exists By UserName!!!!!!!!!!";
			} else {
				userService.saveuser(user);
			}
		}
		return "redirect:/admin/loginpage";
	}

	@GetMapping("/loginpage")
	public String loginpage(User user) {
		System.err.println(":::::::::userData:::::::" + user);
		return "login";
	}

	@GetMapping("/loginbutton")
	public String loginbutton(User user) {
		System.err.println(":::::::::userData:::::::" + user);
		return "login";
	}

	@GetMapping("/userLogin")
	public String userLogin(User user, Model model) {
		System.err.println("::::::::::::userLogin::::::::::::" + user);
		if (userRepository.existsByPassword(user.getPassword())
				&& userRepository.existsByusername(user.getUsername())) {
			return "index";
		} else {
			return "login";
		}
	}

	@GetMapping("/deshbord")
	public String deshbord() {
		return "index";
	}

	@GetMapping("/product-list")
	public String productlist(@ModelAttribute User user, Model model, @RequestParam(defaultValue = "1") int page,
		
			@RequestParam(defaultValue = "10") int size) {
		System.err.println("productlist");
	List<User> data = userRepository.findAll();
		System.err.println("::::::::"+data);
		if (data != null) {
			model.addAttribute("userinfo", data);
			model.addAttribute("currentPage", page);
//			model.addAttribute("totalPages", data.getTotalPages());
			System.err.println(page);
			System.out.println("Test");
			
		} else {
			return "Record Not found";
		}
		return "User-list";
	}

	@GetMapping("/edituser/{id}")
	public String edituser(@PathVariable("id") Long id, Model model) {
		Optional<User> edit = userService.findByid(id);
		User userData = edit.get();
		System.err.println(":::::::::userData:::::::" + userData);
		model.addAttribute("editinfo", userData);
		return "product-edit";
	}

	@PostMapping("/updateuser")
	public String updateuser(User user, Long id, Model model) {
		System.err.println(":::::::::userData:::::::" + user);
		Optional<User> udata = userService.findByid(id);

		if (udata.isPresent()) {
			userService.updateuser(user, udata);
			List<User> list = userService.findAll();
			model.addAttribute("userinfo", list);
			return "User-list";
		} else {
			return "Record not found!!";
		}
	}

	@GetMapping("deleteuserById/{id}")
	public String deleteuserById(@PathVariable("id") long id, User user, Model model) {
		Optional<User> duser = userService.findByid(id);
		System.err.println("::::duser:::::" + duser);
		if (duser.isPresent()) {
			userService.deleteuserByid(id);
			List<User> list = userService.findAll();
			model.addAttribute("userinfo", list);
			return "User-list";
		} else {
			return "Please Provide Valid ID !!!!!!";
		}
	}

	@GetMapping("/product-details/{id}")
	public String productDetails(@PathVariable("id") Long id, Model model) {
		System.out.println(":::::::::product-payment:::::::");
		Optional<User> edit = userService.findByid(id);
		User userData = edit.get();
		System.out.println(":::::::::product-payment:::::::");
		model.addAttribute("editinfo", userData);
		return "product-details";
	}

	@GetMapping("/payment")
	public String payment() {
		return "product-payment";
	}

	@GetMapping("/mailinbox")
	public String mailbox(Model model) {
		List<FeedBack> list = feedbackService.findAll();
		model.addAttribute("list", list);
		List<FeedBack> data = feedBackRepo.findByStatus(true);
		model.addAttribute("data", data.size());

		return "mailbox";
	}

	@GetMapping("/readMail/{id}")
	public String viewmail(@PathVariable("id") Long id,Model model) {
		List<FeedBack> data = feedBackRepo.findByStatus(true);
		model.addAttribute("data", data.size());
		Optional<FeedBack> feedData=feedBackRepo.findById(id);
	    if(feedData.isPresent()) {
	    	FeedBack  datass = feedData.get();
			model.addAttribute("email",datass.getEmail());
			model.addAttribute("createdDate",datass.getCreatedDate());
			model.addAttribute("message",datass.getMessage());
			
			return "mailbox-view";
	    }else {
	    	 return "mailbox";
	    }
	 
	   
	}

	@GetMapping("/composemail")
	public String composemail(Model model) {
		List<FeedBack> data = feedBackRepo.findByStatus(true);
		model.addAttribute("data", data.size());
		return "mailbox-compose";
	}
	@PostMapping("/sendEmail")
	public String sendEmail(@ModelAttribute SendEmails sendemail) {
		sendEmailService.save(sendemail);
		return "redirect:/admin/composemail";
		}

	@GetMapping("/lockscreen")
	public String lockscreen() {
		return "lock";
	}

	@GetMapping("/filemManager")
	public String fileManager() {
		return "file-manager";
	}

	@GetMapping("/blog")
	public String Blog() {

		return "blog";
	}

	@PostMapping("/comment")
	public String comment(@ModelAttribute FeedBack feedback) {
		feedbackService.save(feedback);
		return "blog";
	}

	@GetMapping("/blogdetails")
	public String blogdetails() {
		return "blog-details";
	}

	@GetMapping("/error404")
	public String error404() {

		return "404";
	}
}
