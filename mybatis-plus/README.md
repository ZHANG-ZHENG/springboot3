mybatis-plus官网：https://baomidou.com/
mybatis-plus github：https://github.com/baomidou/mybatis-plus

快速开始：https://baomidou.com/pages/226c21/#%E5%88%9D%E5%A7%8B%E5%8C%96%E5%B7%A5%E7%A8%8B

搭配springboot3版本：
mysql-connector-java 改成 mysql-connector-j

建表语句：
CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
)

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

ALTER TABLE user   
	ADD COLUMN version int NULL default 1 COMMENT '乐观锁',
	ADD COLUMN create_time datetime NULL COMMENT '创建时间',
	ADD COLUMN update_time datetime NULL COMMENT '更新时间';

操作案例：在SampleTest类下

druid官网：
	https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter
	https://mvnrepository.com/artifact/com.alibaba/druid-spring-boot-starter


工程启动后测试访问：http://localhost:8080/test/test1
工程启动后druid访问：http://localhost:8080/druid/index.html

druid web监控没整合成功，官网最新的包也不是依赖spring3.x编译的，感觉是servlet-api变更引起。druid继续关注官网最新。