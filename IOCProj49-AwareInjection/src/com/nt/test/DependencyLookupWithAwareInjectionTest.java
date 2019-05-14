package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Viechle;

public class DependencyLookupWithAwareInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Viechle viechle=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target class object
		viechle =ctx.getBean("viechle",Viechle.class);
		//invoke the methods
		viechle.jounery("hyd", "pune");
		viechle.entertainment();
		viechle.sounHorn();
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
