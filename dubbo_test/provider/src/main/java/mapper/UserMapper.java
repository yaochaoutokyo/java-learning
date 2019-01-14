package mapper;

import domain.UserDO;

/**
 * Created by yaochao on 2019/01/14
 */
public interface UserMapper {
	UserDO getById(Integer id);
}
