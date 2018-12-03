#char跟varchar的区别
1. char和varchar是一样的字符型，不同在于，varchar比char更灵活，精确，且不占内存空间(当你取同样的字符时，char会在该字符后面加上空格，而varchar则只取得这个字符，比如有字段5，用varchar从该字段中取aa时，你取得的是"aa"用char，则取得的是"aa  "char会在后面用空格补齐5个字段)
#char比vachar有什么优势
1. varchar的速度比char慢。因为char是直接取得全部，而varchar是精确的去取得你要的字符。char因为要直存直取查询速度较快。

#varchar和text的区别
1. text不能设置默认值
2. 和char或者varchar之类的字段不同，text中存储的内容不会和行数据存在一起，而是数据库另找地方存储的
3. text上限比较高，安全性上需要注意，在异常状态下可能会存储非常大的数据，造成问题。
4. char(n)会自动去掉结尾的空格 varchar(n)和text不会去掉结尾空格
5. char(n)最大255，varchar(n)最大65535，text上限65535字节，再多也能存
6. char(n) 和 varchar(n) 中间的 n 代表字符的个数，不是字节的个数,GBk中一个中文等于2个字节，utf8中一个中文字最少占3个字节
7. 如果数据超过n的限制，那么数据将会被截断
8. char是国定宽度，如果数据长度不满足n，那么将会在右边用空格补齐；varchar是变长宽度
9. varchar是标准类型；text不是标准类型
10. varchar跟text都最大保存65535字节长度的数据，但是text还有mediumtext/longtext它可以支持存储跟多的内容
11. varchar的存储格式是 stored-inline，text的存储格式是 off-record。一般情况来说，varchar的速度要比 text 快

Blob类型，可以存储大字段

#set/enum该怎么去使用