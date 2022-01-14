# 一、添加模板文件
在Spring文档中搜索`<beans>`找到配置文件
在任意文件夹上右键->new->Edit File Templates->编辑模板（将Spring官网提供的配置文件模板粘贴过来）->apply

# 二、IOC控制反转
创建对象的控制权发生反转，之前需要自己手动new获取对象，现在直接从Spring容器中获取想要的对象。

## 使用步骤：
一、引入Spring的依赖
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.12.RELEASE</version>
</dependency>
```
二、创建Spring.xml配置文件（文件名随意）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```
三、创建测试bean类（要注入容器中的类）
```java
import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;
    private String gender;
}
```
四、在配置文件中设置`<bean/>`标签将对象注入到容器中
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="user" class="com.colin.bean.User"/>
</beans>
```
五、从容器中获取对象
```java
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        User user = (User)ac.getBean("user");
        System.out.println(user.toString());
    }
}
```
