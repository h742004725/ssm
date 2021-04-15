package com.yaorange.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaorange.entity.User;
import com.yaorange.mapper.UserMapper;
import com.yaorange.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hentai
 * @since 2021-04-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
