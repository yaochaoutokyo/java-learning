import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by yaochao on 2019/01/14
 */
public class Provider {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		System.out.println(context.getDisplayName() + ": here");
		context.start();
		System.out.println("服务已经启动...");
		System.in.read();
	}
}