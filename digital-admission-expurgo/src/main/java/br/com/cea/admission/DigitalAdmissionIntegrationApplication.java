package br.com.cea.admission;

import br.com.cea.admission.job.ScheduledAdmissionJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
public class DigitalAdmissionIntegrationApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(DigitalAdmissionIntegrationApplication.class);

	@Autowired
	private ScheduledAdmissionJob scheduledAdmissionJob;

	public static void main(String[] args) {
		SpringApplication.run(DigitalAdmissionIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		logger.info("Start process: " + LocalDateTime.now());

		try {
			scheduledAdmissionJob.execute();
			logger.info("====> execute sucess ");
			System.exit(0);
		} catch (Exception e) {
			logger.error("====> execute error: " + e.getMessage());
			System.exit(1);
		}

	}
}
