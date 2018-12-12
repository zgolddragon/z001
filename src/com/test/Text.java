package com.test;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.SmbmsUserDAO;
import com.pojo.SmbmsUser;

public class Text {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建用于读取配置文件的输入流
		InputStream in=Test.class.getClassLoader()
				.getResourceAsStream("config.xml");
		
		//声明构造器
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//加载配置文件创建SqlSessionFactory
		SqlSessionFactory factoty=builder.build(in);
		//获取SQL执行对象SqlSession
		SqlSession session=factoty.openSession();
		//根据接口找到对应的映射文件根据接口的方法调用对应的SQL语句
		List<SmbmsUser> userList=session.getMapper(SmbmsUserDAO.class)
				.findAll();
		
		for(SmbmsUser user :userList){
			System.out.println(user.getUserName());
		}
        session.close();
	}

}
