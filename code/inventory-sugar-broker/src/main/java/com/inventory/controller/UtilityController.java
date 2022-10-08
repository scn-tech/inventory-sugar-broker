package com.inventory.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.utility.DatabaseUtil;
import com.inventory.utility.Utility;

@Controller
@RequestMapping("/utility")
public class UtilityController {
	@Value( "${spring.datasource.username}")
	private String user;
	
	@Value( "${spring.datasource.password}")
	private String pwd;
	
	@Value( "${schema.name}")
	private String schema;
	
	@Value( "${schema.backup.path}")
	private String filePath;
	
    @GetMapping("backupdb")
    public String backupSQL(Model model){
		String backupDateStr = Utility.getCurrentDateTimeForDbFileName();
		System.out.println("Manual Backup Started at " + backupDateStr);
		
        String fileName = filePath+"\\" + backupDateStr+ "_MANUAL.sql";
        boolean isCompleted=false;
        try {
        	isCompleted = DatabaseUtil.backup(user, pwd, schema, fileName);
            System.out.println("Manual Backup Script exceuted :"+fileName);
        }catch (Exception e){
        	e.printStackTrace();
        	System.out.println("[Manual Backup database] failed:{}"+e.getMessage());
        	model.addAttribute("message", e.getMessage());
            return "redirect:/";
        }
        
        if(isCompleted) {
        	model.addAttribute("message","Database backup successful :: File Name : "+fileName);
        }
        else {
        	model.addAttribute("message","Database backup failed!!");
        }        
        return "BackupDb";
    }
}
