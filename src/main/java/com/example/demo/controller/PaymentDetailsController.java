package com.example.demo.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.PaymentService;
import com.example.demo.model.PaymentDetails;
import com.example.demo.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
@RequestMapping("/subadmin")
public class PaymentDetailsController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PaymentRepository paymentRepository;

//	@GetMapping("/testpayment")
//	public String testpaymentDetails() {
//		return "paymentlist";
//	}

	@PostMapping("/savecreditcard")
	public String savepaymentDetails(PaymentDetails paymentDetails) {
		System.err.println(":::::::savepaymentdetails::::::::");
		if (paymentDetails != null) {
			paymentService.savepayment(paymentDetails);
		}

		return "redirect:/subadmin/getcreditcardlist";
	}

	@GetMapping("/getcreditcardlist")
	public String getpaymentlist(Model model) {
		List<PaymentDetails> list = paymentService.findAll();
		model.addAttribute("paymenttinfo", list);
		return "paymentlist";
	}

	@PostMapping("/saveDebitcard")
	public String savedavitcard(PaymentDetails paymentDetails) {
		if (paymentDetails != null) {
			paymentService.savepayment(paymentDetails);
		}

		return "redirect:/subadmin/getdebitcardlist";
	}

	@GetMapping("/getdebitcardlist")
	public String getdebitcardlist(Model model) {
		List<PaymentDetails> data = paymentService.findAll();
		if (data.isEmpty()) {
			return "please provide valid data !!!!!!!!!!";
		} else {

			model.addAttribute("paymenttinfo", data);
		}
		return "paymentlist";
	}

	@PostMapping("/SaveEMI")
	public String SaveEMI(PaymentDetails paymentDetails) {
		if (paymentDetails != null) {
			paymentService.saveEmi(paymentDetails);
		}
		return "redirect:/subadmin/getEmiList";
	}

	@GetMapping("/getEmiList")
	public String getEmiList(Model model) {
		List<PaymentDetails> listdata = paymentService.findAll();
		if (listdata.isEmpty()) {
			return "please provide valid data !!!!!!!!!!";
		} else {
			model.addAttribute("paymenttinfo", listdata);
		}
		return "paymentlist";
	}

	@PostMapping("/saveBanking")
	public String saveBanking(PaymentDetails paymentDetails) {
		if (paymentDetails != null) {
			paymentService.saveEmi(paymentDetails);
		}
		return "redirect:/subadmin/getBankingList";
	}

	@GetMapping("/getBankingList")
	public String getBanking(Model model) {
		List<PaymentDetails> data = paymentService.findAll();
		if (data.isEmpty()) {
			return "please provide valid data !!!!!!!!!!";
		} else {
			model.addAttribute("paymenttinfo", data);
		}
		return "paymentlist";
	}

	@PostMapping("/saveaddress")
	public String saveaddress(PaymentDetails paymentDetails) {
		if (paymentDetails != null) {
			paymentService.savepayment(paymentDetails);
		}
		return "redirect:/subadmin/getaddressList";
	}

	@GetMapping("/getaddressList")
	public String getadressList(Model model) {
		List<PaymentDetails> data = paymentService.findAll();
		if (data.isEmpty()) {
			return "please provide valid data !!!!!!!!!!";
		} else {
			model.addAttribute("paymenttinfo", data);
		}
		return "paymentlist";
	}
	
	@PostMapping("/makepayment")
	public String makepayment(PaymentDetails paymentDetails) throws RazorpayException {
		/* System.err.println(paymentDetails); */
		/*
		 * RazorpayClient razorpayClient = new RazorpayClient("rzp_test_Zrop3uzNtvPs1D",
		 * "GZOzwaVBU1F7XFoHjicULiad");
		 * 
		 * JSONObject options = new JSONObject(); options.put("amount", 1500);
		 * options.put("currency", "INR"); options.put("receipt", "txn_123456"); Order
		 * order = razorpayClient.Orders.create(options); System.err.println(options);
		 */
		return "paymentmsg";
		}


}
