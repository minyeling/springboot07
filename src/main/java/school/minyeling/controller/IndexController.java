package school.minyeling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class IndexController {
    //发送者的邮箱账号
    @Value("${spring.mail.username}")
    private String mailusername;
    @Autowired
    JavaMailSender jms;

    @RequestMapping(value = "send")
    public
    String send(){
        try {
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送者邮箱
            mainMessage.setFrom(mailusername);
            //接收者邮箱
            mainMessage.setTo("1760770433@qq.com");
            //发送的邮件标题
            mainMessage.setSubject("来自豆豆的一封信");
            //发送的内容
            mainMessage.setText("小奶狗！");
            System.out.println("123");
            //发送
            jms.send(mainMessage);
            return "发送成功";
        }catch (Exception e){
            return "发送失败";
        }
    }

    //添加附件发送
    @RequestMapping(value = "sends")
    public String sends() {
        try {
            //建立邮件消息
            MimeMessage mainMessage = jms.createMimeMessage();
            //用MimeMessageHelper组装复杂邮件，第二个参数为true，可以发送附件
            MimeMessageHelper helper = new MimeMessageHelper(mainMessage, true);
            //发送者邮箱
            helper.setFrom(mailusername);
            //接收者邮箱
            helper.setTo("123@qq.com");
            //发送的邮件标题
            helper.setSubject("Springboot发送邮件");
            //发送的内容
            helper.setText("邮件内容");
            //添加附件
            helper.addAttachment("ATM.pptx", new File("E:\\HTML\\ATM.pptx"));
            //发送
            jms.send(mainMessage);
            return "发送成功";
        }catch (Exception e){
            return "发送失败";
        }
    }

}