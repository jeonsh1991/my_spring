package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping("/board/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/board/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		log.info("¿©±â"+uploadFile);
		
		String uploadFolder= "C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			
			log.info("-------------------------------------");
			log.info("upload file name: "+multipartFile.getOriginalFilename());
			log.info("Upload File Size:" +multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO: handle exception
				log.error(e.getMessage());
			}
			
		}
		
	}
	
}
