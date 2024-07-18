package com.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileUplodeService {

	
	
	public void fileUplodeService(MultipartFile masterImg )
	{
		try 
		{
			
			String path = "D:\\adv java\\spring-project\\first_project\\src\\main\\webapp\\images\\profile";
			byte[] b = masterImg.getBytes();
			
			File file = new File(path,masterImg.getOriginalFilename());
		
			FileUtils.writeByteArrayToFile(file, b);

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void uploadUserImage(MultipartFile masterImage, String email) {

		System.out.println(masterImage.getOriginalFilename());

		//String path = "C:\\sts\\24-spring-web-mix-6pm\\src\\main\\webapp\\images\\profilepic";
		String path = "D:\\adv java\\spring-project\\first_project\\src\\main\\webapp\\images\\profile";

		// now you have to create another folder -> email -> copy profile pic
		File dir = new File(path, email);
		dir.mkdir();// exists -> false | not exists->true

		// dao insert
		try {
			byte b[] = masterImage.getBytes();// copy | extract

			File file = new File(dir, masterImage.getOriginalFilename());// path , name
			FileUtils.writeByteArrayToFile(file, b);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
