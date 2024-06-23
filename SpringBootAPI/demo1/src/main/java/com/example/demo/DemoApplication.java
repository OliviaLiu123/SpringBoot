package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
/*
可以批量处理的入口
 */

@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner{
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	// 日志
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		logger.info("Application started");

		logger.error("An error occurred", new RuntimeException("Error details"));
	}

	@Override
	public void run(String... args) throws Exception {
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());
	}
}
