package com.safee.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.safee.jaxbclasses.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app=new App();
		app.unmarshall();

	}

	public void unmarshall() {
		File file = new File("C:/SWInstallation/LoyalWorkspace/myjaxb/src/main/resources/Student.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Student.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student) jaxbUnmarshaller.unmarshal(file);
			System.out.println(student);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
