package com.ccf.mapper;

import com.ccf.pojo.FreeList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeListMapper {

    List<FreeList> getFreeList();

    List<FreeList> getAFreeList(@Param("name")String  name);

}
