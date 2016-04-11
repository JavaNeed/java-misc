package com.misc.common;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Demo {
	public static void main(String[] args) throws JAXBException {
		File file = new File(ReadXMLFileDOM.class.getClassLoader().getResource("employees.xml").getFile());
		
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    EmployeeMap empMap = (EmployeeMap) jaxbUnmarshaller.unmarshal(file);
	     
	    for(Integer empId : empMap.getEmployeeMap().keySet()) {
	        System.out.println(empMap.getEmployeeMap().get(empId).getFirstName());
	        System.out.println(empMap.getEmployeeMap().get(empId).getLastName());
	    }
	}
}
