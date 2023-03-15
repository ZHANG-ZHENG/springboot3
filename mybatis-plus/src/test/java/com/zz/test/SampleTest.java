package com.zz.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.test.user.bean.User;
import com.zz.test.user.dao.UserMapper;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    
    /**
     * 查询测试
     */
    //@Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.lt("age", 10);//.like("name", "雨")
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList total:"+userList.size());
        userList.forEach(System.out::println);
    }
    /**
     * 插入测试
     */     
    //@Test
    public void testInsert() {
        User user = new User();
        user.setName("小7");
        user.setAge(21);
        user.setEmail("2312103645@qq.com");
        int insert = userMapper.insert(user);//如果没有设置id，那么会自动生成id
        System.out.println("insert:"+insert);//受影响行数
        System.out.println(user);//id会自动回填
    }
    /**
     * 更新测试
     */    
    //@Test
    public void testUpdate(){
        User user = new User();
        user.setId(5L);
        user.setName("5,修改过后"+System.currentTimeMillis());
        int i = userMapper.updateById(user);
        System.out.println(i);
    }  
    /**
     * 乐观锁
     */     
    //@Test
    public void testUpdateVersion(){
    	User user1 = userMapper.selectById(5L);
    	user1.setName("线程1,修改过后"+System.currentTimeMillis());
    	
    	User user2 = userMapper.selectById(5L);
    	user2.setName("线程2,修改过后"+System.currentTimeMillis());
    	
        int u2Result = userMapper.updateById(user2);
        int u1Result = userMapper.updateById(user1);
        
        System.out.println("u1Result="+u1Result);
        System.out.println("u2Result="+u2Result);
    }
    /**
     * 事务
     */    
    //@Test
    @Transactional
    @Rollback(false)//SpringBootTest测试下不自动回滚
    public void testUpdateTransactional(){
        User user = new User();
        user.setId(1L);
        user.setAge(1);
        userMapper.updateById(user);   
        user.setAge(2);
        userMapper.updateById(user);
    }
    /**
     * 分页查询
     */
    @Test
    public void testSelectPage() {
        Page<User> page=new Page<User>();
        page.setSize(3L);
        page.setCurrent(1);
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.lt("age", 10);//.like("name", "雨")
        Page<User> userPage = userMapper.selectPage(page, wrapper);
        System.out.println("总条数:"+userPage.getTotal());
        System.out.println("当前页:"+userPage.getCurrent());
        System.out.println("每页显示条数，默认 10:"+userPage.getSize());
        System.out.println("总页数:"+userPage.getPages());
        System.out.println("查询结果列表大小:"+userPage.getRecords().size());
        for(User user : userPage.getRecords()){
        	System.out.println("page user:"+user.getName());
        }
    }
}
