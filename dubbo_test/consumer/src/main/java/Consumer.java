import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DubboService;

/**
 * Created by yaochao on 2019/01/14
 */
public class Consumer {
	public static void main(String[] args) {
		//测试常规服务
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		System.out.println("consumer start");
		DubboService dubboService = (DubboService) context.getBean("dubboService");
		System.out.println("consumer");
		System.out.println(dubboService.getNameById(1));
	}
}
