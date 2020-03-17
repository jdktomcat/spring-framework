package personal.spring.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import static org.junit.Assert.assertTrue;

public class SimpleBeanFactoryTest {

    private static final String PATH = "/personal/spring/bean/simpleBean.xml";

    @Test
    public void testSingleConfigLocation() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(PATH);
        assertTrue(defaultListableBeanFactory.containsBean("simpleBean"));
        defaultListableBeanFactory.clearMetadataCache();
    }
}
