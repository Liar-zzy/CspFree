package com.ccf.mapper;

import com.ccf.pojo.FreeList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FreeListMapper {

    List<FreeList> getFreeList();

    List<FreeList> getAFreeList(@Param("name")String  name);
}
