# MySQL一些常用的语句
	在表创建完毕后，如果需要查看一下表的定义，可以使用如下命令：

<span style="color:red">desc tablename<\span>

	例如查看emp表（假装这个表之前就已经创建好了）
	desc emp;
![](https://i.imgur.com/L16dJfT.jpg)

	虽然desc命令可以查看表定义，但是其输出的信息还是不够全面，为了查看更全面的表定义信息，有时就需要通过查看创建表的SQL语句来得到，可以使用如下命令实现:

<span style="color:red">show create table tablename \G;<\span>

![](https://i.imgur.com/9gQ3Upm.jpg)
![](https://i.imgur.com/9HH2E44.jpg)

	从上面表的创建SQL语句中，除了可以看到表定义外，还可以看到表的engine(存储引擎)和charset(字符集)等信息。“\G”选项的含义是使得记录能够按照字段竖着排列，对于内容比较长的记录更易于显示。

#mysql中数据库常用的字符串函数
	upper(str)将字符串转换为大写
	select upper(name)，name from t_user

	lower(str)将字符串转换为小写
	select lower(name) from t_user

	length(str)查询字符串的长度
	select length(name),name from t_user

	SUBSTR(str,pos)截取字符从1开始java中从0开始
	select SUBSTR(name,1,1),name from t_user(第一个1代表从第一个开始，第二个1代表截取几个字符)

	REPLACE(str,form_str,to_str)替换
	select replace(name,'a','mmm'),name from t_user(函数中的'a'被'mmm'替换了)

	TRIM([remstr From] str)去除左右俩边的空格
	select trim(name) from t_user

	INSTR('str',substr)查找字符中某个字符的索引，从1开始没有为0和java的区别 java从0开始
	select INSTR('name','c'),name from t_user
	select INSTR('name','a'),name from t_user('a'代表在'name'中的下标，mysql中的下标是从1开始，java是从0开始)

#数值函数
	round()函数 小数后保留的位数
	select ROUND(sum,1),sum from t_order

	NOW()日期函数 获取系统当前时间
	select NOW() from t_order
	select * from t_order;

	ADDDATE(date,INTERVSL expr unit)指定日期加天数 算出新的日期
	select ADDDATE(createdate,2),createdate from t_order 
 
	LAST_DAY(date)计算当前日期的最后一天
	select LAST_DAY(NOW()) from t_order

#通用函数
	mgr 空值 IFNULL(expr1,expr2)如果为空则用默认值代替
	select IFNULL(age,'空值')，age from t_user where id=3;(这样会修改查看到的结果，不会修改表中的数据)