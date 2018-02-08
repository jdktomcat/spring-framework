package personal.spring.context;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class SimpleContextTest {

    private static final String PATH = "/personal/spring/bean/simpleBean.xml";

    @Test
    public void testSingleConfigLocation() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(PATH);
        assertTrue(ctx.containsBean("simpleBean"));
        ctx.close();
    }
}
