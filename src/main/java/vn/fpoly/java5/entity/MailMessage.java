package vn.fpoly.java5.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailMessage {
    @Builder.Default
    private String from = "FPT Polytechnic<poly@fpt.edu.vn>";
    String to,cc,bcc,subject,body,fileName;
}
