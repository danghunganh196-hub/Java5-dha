package vn.fpoly.java5.schedule;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Logger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
    @Scheduled(cron = "*/5 * * * * ?")
    public void writeLog() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(formatter);
        logger.info("task chạy lúc: {} ", date);
    }
}
