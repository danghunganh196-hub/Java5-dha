package vn.fpoly.java5.utility;

import vn.fpoly.java5.entity.MailMessage;

public interface MailService {
    void sendMail(MailMessage mailMessage);
    default void sendMail(String to, String subject, String body) {
        this.sendMail(MailMessage.builder().to(to).subject(subject).body(body).build());
    }
}
