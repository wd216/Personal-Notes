#SQLite3 中 LIMIT的使用
	可以用来取表中的数据，比如取表中第3到5中间的数据

	

1. limit后面写的数字(图中limit 6)的作用是用来取几条数据<span style="color: red">(不是从下标0开始)</span>
2. offset后面写的数字(offset 2)的作用是从表中第几条数据开始,2代表的是从第三条数据开始取，因为2代表的是下标<span style="color: red">(是从下标0开始)</span>
![](https://i.imgur.com/KdSVKKM.png)
