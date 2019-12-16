package com.ccf.service.impl;

import com.ccf.pojo.Admin;
import com.ccf.service.*;
import com.ccf.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminMapper adminMapper;

    @Override
    public boolean add_admin(Admin admin) {
        int row = adminMapper.add_admin(admin);
        return row == 1 ? true : false;
    }

    @Override
    public boolean del_admin(int aid) {
        int row = adminMapper.delete_admin(aid);
        return row == 1 ? true : false;
    }

    @Override
    public Admin sel_admin(int aid) {
        Admin admin = adminMapper.select_admin(aid);
        return admin;
    }

    @Override
    public boolean mod_admin(Admin admin) {
        int row = adminMapper.modify_admin(admin);
        return row == 1 ? true : false;
    }

}
