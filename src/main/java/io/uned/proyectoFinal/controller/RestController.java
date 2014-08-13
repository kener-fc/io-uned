package io.uned.proyectoFinal.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.util.FileCopyUtils;

import io.uned.proyectoFinal.model.UploadedFile;

@Controller
@RequestMapping("/controller")
public class RestController {

	UploadedFile ufile;

	public RestController() {
		System.out.println("init RestController");
		ufile = new UploadedFile();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	String upload(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		// 0. notice, we have used MultipartHttpServletRequest

		// 1. get the files from the request object
		Iterator<String> itr = request.getFileNames();

		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() + " uploaded!");

		try {
			// just temporary save file info into ufile
			ufile.length = mpf.getBytes().length;
			ufile.bytes = mpf.getBytes();
			ufile.type = mpf.getContentType();
			ufile.name = mpf.getOriginalFilename();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// we are using getTimeInMillis to avoid server cached image

		return "loaded";

	}
}
