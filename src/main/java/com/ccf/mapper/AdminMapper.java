package com.ccf.mapper;

import com.ccf.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    /**
    * 添加用户
    * */
    int add_admin(@Param("addAdmin") Admin admin);
    /**
     * 删除用户
     * */
    int delete_admin(@Param("delAdmin") int aid);

    /**
     * 更新信息
     * */
    int modify_admin(@Param("modAdmin") Admin admin);

    /**
     * 查询用户
     * */
    Admin select_admin(@Param("selAdmin") int aid);

}
