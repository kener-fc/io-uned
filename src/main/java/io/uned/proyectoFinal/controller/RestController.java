package io.uned.proyectoFinal.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.util.FileCopyUtils;
import org.xml.sax.SAXException;

import java.io.File;
import javax.xml.bind.*;

import io.uned.proyectoFinal.model.SummaryCart;
import io.uned.proyectoFinal.model.SummaryElement;
import io.uned.proyectoFinal.model.UploadedFile;

@Controller
@RequestMapping("/controller")
public class RestController {

	UploadedFile ufile;

	public RestController() {
		System.out.println("init RestController");
		ufile = new UploadedFile();
	}

	@RequestMapping(value = "/procesarArchivo", method = RequestMethod.POST)
	public @ResponseBody
	String procesarArchivo(MultipartHttpServletRequest request,
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
						
			StreamSource streamSource = new StreamSource(mpf.getInputStream());
			
		     JAXBContext jc = JAXBContext.newInstance(SummaryCart.class);
		     Unmarshaller unmarshaller = jc.createUnmarshaller();
             SummaryCart sc = (SummaryCart) unmarshaller.unmarshal(streamSource);
             
             if(sc == null){
            	return "error"; 
             }             
             System.out.println("cantidad de summaryElements : "+ sc.getSummaryElementList().size());
             
             SummaryElement summaryElement1 = sc.getSummaryElementList().get(0);
             
             System.out.println("summaryElement1  getDisplayName: "+summaryElement1.getDisplayName());
             
             

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		// we are using getTimeInMillis to avoid server cached image

		return "loaded: " + ufile.name + "- type: " + ufile.type ;

	}
}
