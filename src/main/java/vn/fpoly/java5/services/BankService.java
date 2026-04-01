package vn.fpoly.java5.services;

import org.springframework.stereotype.Service;

@Service("bank")
public class BankService implements PaymentService{
    public void pay(){
        System.out.println("Thanh toán bằng chuyển khoản ngân hàng");
    }
}

