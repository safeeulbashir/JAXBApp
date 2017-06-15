package com.safee.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.safee.jaxbclasses.Address;
import com.safee.jaxbclasses.Mark;
import com.safee.jaxbclasses.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		app.marshall();
		app.unmarshall();

	}

	public void unmarshall() {
		File file = new File("C:/SWInstallation/LoyalWorkspace/myjaxb/src/main/resources/Student.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Student.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//jaxbUnmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Student student = (Student) jaxbUnmarshaller.unmarshal(file);
			System.out.println(student.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void marshall() {
		File file = new File("C:/SWInstallation/LoyalWorkspace/myjaxb/src/main/resources/Student.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			 jaxbMarshaller.marshal(getMeAnEmployee(), file);
			//jaxbMarshaller.marshal(getMeAnEmployee(), System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Student getMeAnEmployee() {
		Student student = new Student();
		student.setStudentId(1);
		Address address = new Address();
		address.setAddressType("HOME");
		address.setLine1("1026 San Jacinto Dr.");
		address.setLine2("Apt 1714");
		address.setCity("Irving");
		address.setState("TX");
		address.setZip(75063);
		address.setCountry("USA");
		Mark mark = new Mark();
		mark.setSubject("JAVA");
		mark.setMark(90);
		mark.setMaxMark(100);
		Address address2 = new Address();
		address2.setAddressType("HOME");
		address2.setLine1("951 Buena Vista Dr. SE.");
		address2.setLine2("Apt G201");
		address2.setCity("Albuquerque");
		address2.setState("NM");
		address2.setZip(87106);
		address2.setCountry("USA");
		Mark mark2 = new Mark();
		mark2.setSubject("C++");
		mark2.setMark(95);
		mark2.setMaxMark(100);	
		student.setStudentId(1);
		student.setFirstName("Safeeul Bashir");
		student.setLastName("Safee");
		student.getAddress().add(address);
		student.getMark().add(mark);
		student.getAddress().add(address2);
		student.getMark().add(mark2);
		return student;
	}
}
