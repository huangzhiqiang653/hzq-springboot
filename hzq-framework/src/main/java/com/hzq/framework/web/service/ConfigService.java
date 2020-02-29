package com.hzq.framework.web.service;

import com.hzq.system.service.ISysConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 首创 html调用 thymeleaf 实现参数管理
 *
 * @author 黄智强
 */
@Service("config")
public class ConfigService {
    @Resource
    private ISysConfigService configService;

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey) {
        return configService.selectConfigByKey(configKey);
    }
}
