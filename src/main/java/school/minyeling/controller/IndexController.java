package school.minyeling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class IndexController {
    //发送者的邮箱账号
    @Value("${spring.mail.username}")
    private String mailusername;
    @Autowired
    JavaMailSender jms;

    @RequestMapping(value = "send")
    public String send(String mailNum, String titleName, String info) {
        try {
            System.out.println("=== send  =============");
            System.out.println(mailNum);
            System.out.println(titleName);
            System.out.println(info);
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送者邮箱
            mainMessage.setFrom(mailusername);
            //接收者邮箱
            mainMessage.setTo(mailNum);
            //发送的邮件标题
            mainMessage.setSubject(titleName);
            //发送的内容
            mainMessage.setText(info);
            //发送
            jms.send(mainMessage);
            return "发送成功";
        } catch (Exception e) {
            return "发送失败";
        }
    }

    //添加附件发送
    @RequestMapping(value = "sends")
    public String sends(String mailNum, String titleName, String info, @RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D:\\a\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
//            return "上传成功";
            System.out.println("成功了");
            System.out.println(filePath+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //建立邮件消息
            MimeMessage mainMessage = jms.createMimeMessage();
            //用MimeMessageHelper组装复杂邮件，第二个参数为true，可以发送附件
            MimeMessageHelper helper = new MimeMessageHelper(mainMessage, true);
            //发送者邮箱
            helper.setFrom(mailusername);
            //接收者邮箱
            helper.setTo(mailNum);
            //发送的邮件标题
            helper.setSubject(titleName);
            //发送的内容
            helper.setText(info);
            //添加附件
            helper.addAttachment(fileName, new File(filePath+fileName));
            //发送
            jms.send(mainMessage);
            return "发送成功";
        } catch (Exception e) {
            return "发送失败";
        }
    }

}