package cn.whu.dhji.service.impl;

import cn.whu.dhji.entity.User;
import cn.whu.dhji.mapper.UserMapper;
import cn.whu.dhji.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘泽彬
 * @since 2019-05-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getByUsername(String username) {
        if (username != null){
            User user = new User();
            user.setUsername(username);
            return baseMapper.selectOne(user);
        }
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }

}
