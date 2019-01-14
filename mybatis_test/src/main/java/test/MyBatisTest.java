package test;

import domain.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by yaochao on 2019/01/11
 */
public class MyBatisTest {
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
			return sessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		SqlSession sqlSession = getSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getById(1);
		System.out.println(user.getName());
	}
}