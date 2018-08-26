package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter c = ctx.getBean("greeter", Greeter.class);
		//String msg = c.greet("스프링");
		System.out.println(c.greet("스프링"));
		ctx.close();
		
	}

}
