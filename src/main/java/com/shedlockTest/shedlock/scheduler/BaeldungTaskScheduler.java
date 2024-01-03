package com.shedlockTest.shedlock.scheduler;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
class BaeldungTaskScheduler {

	@Scheduled(fixedRate = 3000)
	@SchedulerLock(name = "shedlock", lockAtMostFor = "PT14M")
	public void scheduledTask1() {
		System.out.println("Rodando: " + LocalDateTime.now());
	}

	@Scheduled(fixedRate = 3000)
	@SchedulerLock(name = "blabla", lockAtMostFor = "PT14M")
	public void scheduledTask2() {
		System.out.println("Rodando: " + LocalDateTime.now());
	}


}