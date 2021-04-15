package com.yaorange.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaorange.constant.CommonConstant;
import com.yaorange.controller.vo.Result;
import com.yaorange.entity.User;
import com.yaorange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author：Hentai
 * @Description：前端控制器
 * @Date：Created in 13:49 2021/4/13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/list")
//    @ResponseBody// 结果返回json
//    public Result<List<User>> findAll(){
//        Result<List<User>> result = new Result<>();
//        List<User> list = userService.list();
//        result.setSuccess(true);
//        result.setResult(list);
//        return result;
//    }

    @GetMapping("/list")
    @ResponseBody// 结果返回json
    public Result<Object> findAll(){
        List<User> list = userService.list();
        return Result.ok(list);
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    @ResponseBody
    public Result<IPage<User>> queryUserByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        Result<IPage<User>> result = new Result<IPage<User>>();

        //1：创建分页对象
        Page<User> page = new Page<User>(pageNum, pageSize);
        //2: 调用分页查询方法，必须将Page对象作为第一个参数
        //不带条件的分页查询
        IPage<User> pageList = userService.page(page);
        //带条件的分页查询
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        IPage<User> pageList = userService.page(page, queryWrapper);
        result.setSuccess(true);
        result.setCode(CommonConstant.SC_OK_200);
        result.setResult(pageList);
        return result;
    }
}

