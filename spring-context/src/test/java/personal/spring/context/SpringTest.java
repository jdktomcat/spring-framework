package personal.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.spring.bean.lifecycle.HelloWorld;

/**
 * 类描述：Spring Bean生存周期测试类
 *
 * @author 汤旗
 * @date 2018-06-14
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:personal/spring/bean/application-context.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        System.out.println("14.Bean working, message = " + obj.getMessage());
        //((ClassPathXmlApplicationContext)context).refresh();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
