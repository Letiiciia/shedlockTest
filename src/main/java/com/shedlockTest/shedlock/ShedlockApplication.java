package com.shedlockTest.shedlock;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class ShedlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShedlockApplication.class, args);
	}

}
@Component
class BaeldungTaskScheduler {

	@Scheduled(fixedRate = 3000)
	@SchedulerLock(name = "shedlock",
			lockAtLeastFor = "PT5M", lockAtMostFor = "PT14M")
	public void scheduledTask1() {
		System.out.println("Rodando 1: " + LocalDateTime.now());
	}


}
