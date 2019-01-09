# <p style="color:red">基于 Maven 搭建的 java 项目 进行系列化和反序列化</p> #

### 首先导入 Jackson 的架包依赖，因为我这里利用 jackson 进行系列化和反系列化 ###
	<dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.7</version>
     </dependency>

###  这里使用了一个实体类进行测试,并写了相对的 getter 和 setter 的方法，并重写了 toString() 的方法
	package com.nf147.ssms.entity;

	public class News {
    private long id;
    private String title;
    private String body;

    public News() {
    }

    public News(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
	}

## 接下写一个测试的方法 ##
	 public void toJson() throws IOException {
        //对数据进行系列化和反系列化
        // 这里获取 jackson 的操作对象
        ObjectMapper om = new ObjectMapper();
        News news = new News("陈子寒", "框架终究是框架");
        //java 对象 -> json 字符串
        String s = om.writeValueAsString(news);
        System.out.println("java 对象转换为 Json 字符串" + s);
        //json 字符串 -> java 对象
        News news_new = om.readValue(s, News.class);
        System.out.println("Json 字符串转换为 java 对象" + news_new);
    }
# 打印的结果是 #
	java 对象转换为 Json 字符串{"id":0,"title":"陈子寒","body":"框架终究是框架"}
	Json 字符串转换为 java 对象News{id=0, title='陈子寒', body='框架终究是框架'}

## 利用 Gson 进行系列化 ##
	List<News> newsList = Arrays.asList(
                new News("yuandan", "放假"),
                new News("春节", "快来了")
        );
        String newsListStr = om.writeValueAsString(newsList);
        News[] newsArray = om.readValue(newsListStr, News[].class);
        List<News> newsList1 = om.readValue(newsListStr, new TypeReference<List<News>>() {});
        System.out.println(newsList1);
			
		//利用 Gson 对 Json 字符串 反系列化 为 java 对象	
        List<News> newsList2 = new Gson().fromJson(newsListStr, new TypeToken<List<News>>() {}.getType());
        System.out.println(newsList2);
