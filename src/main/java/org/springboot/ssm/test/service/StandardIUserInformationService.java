package org.springboot.ssm.test.service;

import org.springboot.ssm.test.dao.UserInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StandardIUserInformationService implements IUserInformationService {

    @Autowired
    private UserInformationDao uid;

    @Override
    public Object selectAll() {
        return uid.selectAll();
    }
}
