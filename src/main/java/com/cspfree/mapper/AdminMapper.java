package com.cspfree.mapper;

import com.cspfree.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    int add_admin(@Param("addAdmin") Admin admin);

    int delete_admin(@Param("delAdmin") int aid);

    int modify_admin(@Param("modAdmin") Admin admin);

    Admin select_admin(@Param("selAdmin") int aid);

}
