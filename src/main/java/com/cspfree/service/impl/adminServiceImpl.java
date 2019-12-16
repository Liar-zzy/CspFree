package com.cspfree.service.impl;

import com.cspfree.mapper.AdminMapper;
import com.cspfree.pojo.Admin;
import com.cspfree.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class adminServiceImpl implements adminService {

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
