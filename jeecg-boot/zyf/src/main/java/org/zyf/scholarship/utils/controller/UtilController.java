package org.zyf.scholarship.utils.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zyf.scholarship.utils.Util;
import org.zyf.scholarship.utils.service.UtilService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/zyf/util")
public class UtilController {
    @Autowired
    private UtilService utilService;

    @RequestMapping(value = "/queryUserRole", method = RequestMethod.GET)
    public Result<String> queryUserRole(@RequestParam(name = "userId", required = false)
                                            String userId) {
        Result<String> result = new Result<>();
        if (StringUtils.isBlank(userId)) {
            userId = Util.getLoginUser().getId();
        }
        Util.Role role = utilService.who(userId);
        System.out.println(role.name());
        result.setResult(role.name());
        return result;
    }
}