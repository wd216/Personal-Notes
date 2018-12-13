解决注解 @RequestBody 返回对象时出现的中文乱码问题

	需要在 web-mvc.xml 中添加以下代码
	



<!--启用 mvc 的常用注解-->
    <mvc:annotation-driven validator="myValidator" conversion-service="conversionService">
        <!--@ResponseBody 的 UTF-8 编码-->
        <mvc:message-converters register-defaults="false">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>


![](https://i.imgur.com/1hd1wV7.png)