package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.fpoly.java5.services.BankService;
import vn.fpoly.java5.services.MoMoService;
import vn.fpoly.java5.services.VNPayService;

@Controller
@RequestMapping("/order")
public class CheckoutController {
    @GetMapping("/checkout")
    public String showCheckoutPage(){
        return "order/checkout";
    }
    @PostMapping("/checkout")
    public String checkout(@RequestParam String type, Model model){
        String message = "";
        switch(type){
            case "VNPAY":
                VNPayService vnPayService = new VNPayService();
                vnPayService.pay();
                message = "VNPAY";
                model.addAttribute("message", message);
                break;
            case "MOMO":
                MoMoService moMoService = new MoMoService();
                moMoService.pay();
                message = "MOMO";
                model.addAttribute("message", message);
                break;
            case "BANK":
                BankService bankService = new BankService();
                bankService.pay();
                message = "BANK";
                model.addAttribute("message", message);
                break;
                default:
                    message = "Phương thức không hợp lệ";
                    model.addAttribute("message", message);
                    break;
        }
        return "order/result";
    }
}

