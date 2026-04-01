package vn.fpoly.java5.services;

import org.springframework.stereotype.Service;

@Service("vnpay")
public class VNPayService implements PaymentService{
    public void pay(){
        System.out.println("Thanh toán bằng VNPay");
    }
}
