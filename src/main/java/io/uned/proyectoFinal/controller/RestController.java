package io.uned.proyectoFinal.controller;

import io.uned.proyectoFinal.model.Abono;
import io.uned.proyectoFinal.model.Cliente;
import io.uned.proyectoFinal.model.Clientes;
import io.uned.proyectoFinal.model.Credito;
import io.uned.proyectoFinal.model.UploadedFile;
import io.uned.proyectoFinal.util.Util;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.xml.sax.SAXParseException;

@Controller
@RequestMapping("/controller")
public class RestController {

	UploadedFile ufile; 
	
	@Autowired
	private Util util;

	public RestController() {
		System.out.println("init RestController");
		ufile = new UploadedFile();
	}

	@RequestMapping(value = "/procesarArchivo", method = RequestMethod.POST)
	public @ResponseBody
	String procesarArchivo(MultipartHttpServletRequest request,
			HttpServletResponse response) throws SAXParseException {

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
			
		    
			JAXBContext jc = JAXBContext.newInstance(Clientes.class);
		    Unmarshaller unmarshaller = jc.createUnmarshaller();
		    Clientes clientes = (Clientes) unmarshaller.unmarshal(streamSource);
            	     
		     if(clientes == null){
		    	 return "error";
		     }
		     
		     System.out.println("cliente : "+ clientes.getList().size());
		     
		     Cliente cliente = (Cliente)clientes.getList().get(0);
		     System.out.println("cliente : "+ cliente.getNombre() + " "+cliente.getApellido1()+" "+cliente.getApellido2());
		     
		     if(cliente.getCreditos() == null){
		    	 System.out.println("cliente credito null");
		     }
		     
		     Credito credito = (Credito) cliente.getCreditos().get(0);
		     System.out.println("plazo Fecha formalizacion de credito : "+credito.getPlazo());
		     
		     
		     if(credito.getAbonos() == null){
		    	 System.out.println("abonos del credito null");
		     }
		     Abono abono = (Abono) credito.getAbonos().get(0);
		     System.out.println("Monto abono : "+abono.getMonto());
		     System.out.println("Fecha abono : "+abono.getDate().toString());
             
             

		} 

		catch (IOException e) {
			e.printStackTrace();
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return "loaded: " + ufile.name + "- type: " + ufile.type ;

	}
	
	
	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}
}
