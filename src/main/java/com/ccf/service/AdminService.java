package com.ccf.service;

import com.ccf.pojo.Admin;

public interface AdminService {

    boolean add_admin(Admin admin);

    boolean del_admin(int aid);

    Admin sel_admin(int aid);

    boolean mod_admin(Admin admin);

}
