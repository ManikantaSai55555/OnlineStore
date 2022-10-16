package com.src.service;

import com.src.dao.ValidDAOImpl;
import com.src.dao.ValidDAOInter;

public class ValidImpl implements ValidInter {

    ValidDAOInter vdao=new ValidDAOImpl();

    @Override
    public boolean validUser(String username, String password) {
        
        return vdao.validUser(username, password);

    }

}
