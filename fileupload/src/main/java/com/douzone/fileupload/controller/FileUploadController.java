package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping({ "", "/form" })
	public String form() {
		return "form";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "file1") MultipartFile multipartFile, Model model) { // 서블릿이 temp에 저장해둔 파일에 접근하는게 MultipartFile

		System.out.println("email : " + email);
		
		String url = fileUploadService.restore(multipartFile);
		
		model.addAttribute(url);
		
		
		return "result";
	}

}
