package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Student;

public class RequiredAnnotationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Student stud=null;
		//create  IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		stud=ctx.getBean("st",Student.class);
		System.out.println(stud);
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
