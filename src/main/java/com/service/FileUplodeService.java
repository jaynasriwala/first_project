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
			
			String path = "D:\\adv java\\spring-project\\first_project\\src\\main\\webapp\\WEB-INF\\static";
			byte[] b = masterImg.getBytes();
			
			File file = new File(path,masterImg.getOriginalFilename());
		
			FileUtils.writeByteArrayToFile(file, b);

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
