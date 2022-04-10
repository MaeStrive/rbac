package com.atmae.myrabc.service.impl;

import com.atmae.myrabc.entity.Email;
import com.atmae.myrabc.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 9:22
 * @Description:
 */
@Service
@Slf4j
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 自动统计数据
     * 每30秒执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    @Override
    public void doCount() {
        //TODO 统计数据


        //定时发送邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //发送邮件的工具类
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setSubject(new Date()+"：网站注册人数报告");
            mimeMessageHelper.setText("今日网站注册人数为"+0);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo("1915857256@qq.com");

            //发送
            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //打印日志
        log.info("今日邮件已经发送~~~");
    }
}
