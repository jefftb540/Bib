package br.com.biblioteca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Scheduler {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"WEB-INF/applicationContext.xml");
	}
}
