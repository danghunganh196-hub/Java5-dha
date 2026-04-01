package vn.fpoly.java5.services;

import org.springframework.stereotype.Service;

@Service("momo")
public class MoMoService implements PaymentService{
    public void pay(){
        System.out.println("Thanh toán bằng MoMo");
    }
}
