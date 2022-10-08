package com.inventory.utility;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class DBAutoBackupSchedular {

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String pwd;

	@Value("${schema.name}")
	private String schema;

	@Value("${schema.backup.path}")
	private String filePath;

	//@Scheduled(fixedRate = 60000)
	@Scheduled(cron = "0 0 17,22 * * *")	
	public void schedule() {

		String backupDateStr = Utility.getCurrentDateTimeForDbFileName();
		System.out.println("Auto Backup Started at " + backupDateStr);

		String fileName = "AUTO"; // default file name
		File f1 = new File(filePath);
		f1.mkdir(); // create folder if not exist

		String saveFileName = backupDateStr + "_" + fileName + ".sql";
		String savePath = filePath + "\\" + saveFileName;

		boolean isCompleted = false;
		try {
			isCompleted = DatabaseUtil.backup(user, pwd, schema, savePath);
			System.out.println("Auto Backup Script exceuted");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (isCompleted) {
			System.out.println("Auto Backup Complete at " + new Date());
		} else {
			System.out.println("Auto Backup Failure :" + backupDateStr);
		}
	}
}
