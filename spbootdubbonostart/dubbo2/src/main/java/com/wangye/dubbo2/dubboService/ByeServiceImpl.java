package com.wangye.dubbo2.dubboService;

import com.wangye.dubboapi.api.ByeService;
import org.springframework.stereotype.Service;

@Service
public class ByeServiceImpl implements ByeService {

    @Override
    public String sayBye(String name) {
        return "Bye " + name;
    }

}
