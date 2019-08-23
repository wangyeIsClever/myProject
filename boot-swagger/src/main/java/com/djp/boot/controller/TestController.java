package com.djp.boot.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;

@RestController
@RequestMapping("/api")
@Api("某个模块接口说明")
public class TestController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "test接口",notes = "测试一下test接口")
    @ApiImplicitParam(name = "id",value = "测试id",paramType = "path",required = true ,dataType = "Integer")
    @GetMapping("/swagger2/{id}")
    public Object test(@PathVariable Integer id){
        logger.info("id:{}",id);
        return "测试swagger2";
    }

}
