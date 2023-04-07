package com.zz.test.config.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;


@Configuration
@MapperScan("com.zz.test.**.dao.**")//扫描mapper
public class MyBatisPlusConfig {
    /**
     * 注册锁插件
     */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
	    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
	    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());//注册乐观锁插件
	    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//注册分页插件
	    interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());//注册防全表更新与删除插件
	    return interceptor;
	}
	
}
