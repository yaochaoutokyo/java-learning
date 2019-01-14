package impl;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.DubboService;

import java.io.IOException;

/**
 * Created by yaochao on 2019/01/14
 */
public class DubboServiceImpl implements DubboService {
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
			return sessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e); // 必须抛，否则无返回值
		}
	}

	public String getNameById(Integer id) {
		SqlSession sqlSession = getSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.getById(id).getName();
	}
}
