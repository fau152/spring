# 一、添加模板文件
在Spring文档中搜索`<beans>`找到配置文件
在任意文件夹上右键->new->Edit File Templates->编辑模板（将Spring官网提供的配置文件模板粘贴过来）->apply

# 二、IOC控制反转
创建对象的控制权发生反转，之前需要自己手动new获取对象，现在直接从Spring容器中获取想要的对象。

## 基本使用步骤：
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
---
# 三、setter注入
## 使用步骤：

一、创建测试Bean类（测试bean类需要有setter方法，例子中使用lombok代替）

```java
import lombok.Data;
import lombok.ToString;

@Setter
@NoArgsConstructor
@ToString
public class User {
   private String name;
   private Integer age;
   private String gender;
}
```
   
二、在配置文件中进行setter注入的配置
```xml
<!--setter注入-->
    <bean id="userSetterDI" class="com.colin.bean.User">
        <property name="name" value="张三"/>
        <property name="age" value="18"/>
        <property name="gender" value="男"/>
    </bean>
```
三、从容器中获取bean对象
```java
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void testSetterDI(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        User user = ac.getBean("userSetterDI",User.class);
        System.out.println(user);
    }
}
```

**注意：**
1. Bean类必须要要有setter方法
2. Bean类必须要有无参数构造方法，当写带参数的构造方法的时候记得保留无参构造方法，
   防止无参构造方法被覆盖
3. setter方法的命名一定要规范，因为源码中是根据xml文件中的的字段前面加上set来匹配要调用
   的setter方法的，而不是根据字段来匹配。

# 四、构造函数注入
这也是Spring团队推荐使用的注入方式，因为这种方式会促使开发者将组件开发成不 可变对象并且确保注入的依赖不为null。
另外，基于构造函数的注入的组件被客户端调用的时候也已经是完全构造好的。

## 使用步骤（三种形式）
一、创建测试bean类
```java
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private Integer age;
    private String gender;
}
```
二、xml文件配置
```xml
<!--constructor注入-->
<bean id="userConstructor1" class="com.colin.bean.User">
   <constructor-arg index="0" value="李四"/>
   <constructor-arg index="1" value="18"/>
   <constructor-arg index="2" value="女"/>
</bean>

<bean id="userConstructor2" class="com.colin.bean.User">
   <constructor-arg type="java.lang.String" value="王五"/>
   <constructor-arg type="java.lang.Integer" value="19"/>
   <constructor-arg type="java.lang.String" value="男"/>
</bean>

<bean id="userConstructor3" class="com.colin.bean.User">
   <constructor-arg name="name" value="时光"/>
   <constructor-arg name="age" value="20"/>
   <constructor-arg name="gender" value="女"/>
</bean>
```
三、从容器中获取指定的对象
```java
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void testConstructorDI(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        User user1 = ac.getBean("userConstructor1", User.class);
        User user2 = ac.getBean("userConstructor2", User.class);
        User user3 = ac.getBean("userConstructor3", User.class);
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
    }
}
```

**注意：**
1. Bean类必须要有带参数的构造方法
2. 使用constructor注入时，可以没有无参构造方法，但是为了避免不必要的麻烦，保留无参构造
方法更好。
3. index：根据带参数的构造方法的参数位置注入的，参数位置调换则导致注入结果不同
4. type：首先根据类型进行匹配，当有两个及以上的同类型参数的时候，根据从左到右的顺序注入
5. name：根据参数名进行匹配，一般不会有歧义，推荐使用。
---





