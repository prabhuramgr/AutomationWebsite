package com.automation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.maven.cli.MavenCli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	private static final String projectDirectory = "/Users/prram/Automation Global/global-member-automation/Member Automation/src";
	private static StringBuffer sb = null;
	
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name,@RequestParam("email") String email,
			@RequestParam("file") MultipartFile file) {
		sb = new StringBuffer();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(projectDirectory+"/test/java/Datatables/"+name);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name+".xlsx");
				System.out.println(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				sb.append("You successfully uploaded file=" + name);
				
			} catch (Exception e) {
				
				sb.append("Unexpec Error" + name + " => " + e.getMessage());
				return sb.toString();
			}
		} 
			
			
			return updateGlobalSettings(name,email);
			
			
		
	}
	
	public static void main(String args[]){
		invokeMaven();
	}
	
	
    private static  String invokeMaven(){
    	MavenCli cli = new MavenCli();
    	cli.doMain(new String[]{"clean", "install"}, projectDirectory+"/..", System.out, System.out);
    	
    	sb.append("Project Execution Completed");
		return null;
    }
	
	
	private String updateGlobalSettings(String projectName, String email) {
		
		try{
			Properties prop = new Properties();
			InputStream  input = new FileInputStream(projectDirectory+"/test/java/Global Settings.properties");
			prop.load(input);
			input.close();
			System.setProperty("ro.to",prop.getProperty("RecipientEmailId"));
			prop.setProperty("RecipientEmailId", email);
			prop.setProperty("DataFile", projectName);
			
			OutputStream output = new FileOutputStream(projectDirectory+"/test/java/Global Settings.properties");
			prop.store(output, null);
			
			output.close();
			
			sb.append("Global settings changed");
			
			
			invokeMaven();

			return sb.toString();
		}catch(Exception e){
			e.printStackTrace();
			sb.append("Global settings not found");
			return sb.toString();
		}
		// TODO Auto-generated method stub
		
	}





	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name
						+ "<br />";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}
}
