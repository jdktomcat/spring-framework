package personal.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 类描述：Spring bean BeanFactory前处理器
 *
 * @author 汤旗
 * @date 2018-06-14
 */
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // configurableListableBeanFactory.getBeanDefinition("appcontext-service.xml");

        System.out.println("1.postProcessBeanFactory(BeanFactoryPostProcessor) 工厂后处理器, ApplicationContext容器初始化中refresh()中调用");
    }
}
