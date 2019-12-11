package com.cspfree.service;

import com.cspfree.pojo.Admin;

public interface adminService {

    boolean add_admin(Admin admin);

    boolean del_admin(int aid);

    Admin sel_admin(int aid);

    boolean mod_admin(Admin admin);

}
