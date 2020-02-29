package com.hzq.web.controller.system;

import com.hzq.framework.web.base.BaseController;
import com.hzq.system.domain.SysMenu;
import com.hzq.system.domain.SysUser;
import com.hzq.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页 业务处理
 *
 * @author 黄智强
 */
@Controller
public class SysIndexController extends BaseController {

    @Value("${hzq.copyrightYear}")
    private int copyrightYear;
    @Value("${hzq.version}")
    private String version;

    @Resource
    private ISysMenuService menuService;

    /**
     * 系统首页
     *
     * @param mmap
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        SysUser user = getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", copyrightYear);
        return "index";
    }

    /**
     * 系统介绍
     *
     * @param mmap
     * @return
     */
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", version);
        return "main";
    }
}
