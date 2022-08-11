package com.wevioo.generator;

import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "doc")
public class ApiController {
    static Logger log = Logger.getLogger(GenerateDocuments.class.getName());

	@Autowired
	private DemoProperties demoProperties;

	@PostMapping(value = "/generate")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public void generateDOCDocument (@RequestBody Model model){
		File template = new File(demoProperties.getInput() , model.getTemplateName() + "." + model.getType());
		String outputDocument = demoProperties.getOutput() + model.getTemplateName() + "_out." + model.getType();
		HashMap<String, String> parameters = new HashMap<String,String>();
		for (Attribute attribute : model.getAttributeList()) {
			parameters.put(attribute.getName(), attribute.getValue());
		}
		Boolean success = GenerateDocuments.generateDocument(template, parameters, outputDocument);
		if (success == true){
			log.info("generation of file successful");
		}else{
			log.error("generation of file successful");
		}

	}   
}
