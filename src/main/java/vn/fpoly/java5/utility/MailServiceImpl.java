package vn.fpoly.java5.utility;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.fpoly.java5.entity.MailMessage;

import java.io.File;

@Service("mailService")
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    public MailServiceImpl(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(MailMessage mailMessage){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            var helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(mailMessage.getFrom());
            if (mailMessage.getTo()!=null && !mailMessage.getTo().isEmpty()) {
                helper.setTo(mailMessage.getTo());
            }
            if(mailMessage.getCc()!=null && !mailMessage.getCc().isEmpty()) {
                helper.setCc(mailMessage.getCc());
            }
            if(mailMessage.getBcc()!=null && !mailMessage.getBcc().isEmpty()) {
                helper.setBcc(mailMessage.getBcc());
            }
            if(mailMessage.getSubject()!=null && !mailMessage.getSubject().isEmpty()) {
                helper.setSubject(mailMessage.getSubject());
            }
            helper.setText(mailMessage.getBody(), true);
            if(mailMessage.getFileName() != null && !mailMessage.getFileName().isEmpty()) {
                File file = new File(mailMessage.getFileName());
                if(!file.exists()){
                    helper.addAttachment(mailMessage.getFileName(), file);
                }
            }
            mailSender.send(message);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
