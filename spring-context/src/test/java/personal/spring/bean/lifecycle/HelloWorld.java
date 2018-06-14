package personal.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 类描述：Spring Bean生命周期测试类
 *
 * @author 汤旗
 * @date 2018-06-14
 */
public class HelloWorld implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    /**
     * 消息
     */
    private String message;

    public HelloWorld() {
        System.out.println("3.HelloWorld struct.......");
    }

    /**
     * 构造函数
     *
     * @param message
     */
    public HelloWorld(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void xml_init(){
        //xml开头的表示配置文件配置,这里是bean配置中init-method配置调用
        System.out.println("11.HelloWorld 初始化(init-method)");
    }

    public void xml_destroy(){
        //destroy-method 配置调用
        System.out.println("16.HelloWorld 销毁(destroy-method)");
    }


    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // setBeanName 后调用
        System.out.println("7.setBeanFactory(BeanFactory) setBeanName后调用");
    }

    /**
     * Set the name of the bean in the bean factory that created this bean.
     * <p>Invoked after population of normal bean properties but before an
     * init callback such as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method.
     *
     * @param name the name of the bean in the factory.
     *             Note that this name is the actual bean name used in the factory, which may
     *             differ from the originally specified name: in particular for inner bean
     *             names, the actual bean name might have been made unique through appending
     *             "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
     *             method to extract the original bean name (without suffix), if desired.
     */
    @Override
    public void setBeanName(String name) {
        // 属性注入后调用
        System.out.println("6.setBeanName(BeanNameAware) 属性注入后调用, 此时name = " + name);
    }

    /**
     * Invoked by a BeanFactory on destruction of a singleton.
     *
     * @throws Exception in case of shutdown errors.
     *                   Exceptions will get logged but not rethrown to allow
     *                   other beans to release their resources too.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("15.destroy(DisposableBean) 在processAfterInitialization之后,配置的xml_destroy之前调用");
    }

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     *
     * @throws Exception in the event of misconfiguration (such
     *                   as failure to set an essential property) or if initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // processBeforeInitialization(BeanPostProcessor)后调用
        System.out.println("10.afterPropertiesSet(InitializingBean) processBeforeInitialization之后,配置的xml_init之前调用");
    }
}
