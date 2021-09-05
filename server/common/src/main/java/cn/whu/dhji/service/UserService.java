package cn.whu.dhji.service;

import cn.whu.dhji.entity.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘泽彬
 * @since 2019-05-21
 */
@Service
public interface UserService extends IService<User> {

    User getByUsername(String username);

    Set<String> findPermissions(String username);

}
