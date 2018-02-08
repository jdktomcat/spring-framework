package personal.spring.bean;

import org.jruby.RubyProcess;

import java.util.Objects;

public class SimpleBean {

    private Integer number;

    private String name;

    public SimpleBean() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init...........");
    }

    public void destroy() {
        System.out.println("destroy...........");
    }

    public void lazyInit() {
        System.out.println("lazy init...........");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleBean that = (SimpleBean) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
