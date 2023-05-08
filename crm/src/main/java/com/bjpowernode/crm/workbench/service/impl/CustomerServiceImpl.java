package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.workbench.mapper.CustomerMapper;
import com.bjpowernode.crm.workbench.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<String> queryCustomerNameByName(String name) {
        return customerMapper.selectAllCustomerNameByName(name);
    }

}
