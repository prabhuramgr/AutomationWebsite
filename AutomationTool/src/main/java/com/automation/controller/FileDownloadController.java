package com.automation.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileDownloadController {
	
	private static String projectDirectory ="/Users/prram/Automation Global/global-member-automation/Member Automation/src";
	
	@RequestMapping(value = "/downloadFile/{file_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public FileSystemResource getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename="+fileName+".xlsx"); 
	    return new FileSystemResource(new File(projectDirectory+"/test/java/Datatables/"+fileName+"/"+fileName+".xlsx")); 
	}
}
