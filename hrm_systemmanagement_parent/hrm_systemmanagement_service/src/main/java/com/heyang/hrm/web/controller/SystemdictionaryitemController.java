package com.heyang.hrm.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.heyang.hrm.domain.Systemdictionaryitem;
import com.heyang.hrm.query.SystemdictionaryitemQuery;
import com.heyang.hrm.service.ISystemdictionaryitemService;
import com.heyang.hrm.util.AjaxResult;
import com.heyang.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemdictionaryitem")
public class SystemdictionaryitemController {
    @Autowired
    public ISystemdictionaryitemService systemdictionaryitemService;

    /**
     * 保存和修改公用的
     *
     * @param systemdictionaryitem 传递的实体
     * @return Ajaxresult转换结果
     */
    @GetMapping("/save")
    public AjaxResult save(@RequestBody Systemdictionaryitem systemdictionaryitem) {
        try {
            if (systemdictionaryitem.getId() != null) {
                systemdictionaryitemService.updateById(systemdictionaryitem);
            } else {
                systemdictionaryitemService.insert(systemdictionaryitem);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！" + e.getMessage());
        }
    }

    /**
     * 删除对象信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            systemdictionaryitemService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！" + e.getMessage());
        }
    }

    //获取用户
    @GetMapping("/{id}")
    public Systemdictionaryitem get(@PathVariable("id") Long id) {
        return systemdictionaryitemService.selectById(id);
    }


    /**
     * 查看所有的员工信息
     *
     * @return
     */
    @GetMapping("/list")
    public List<Systemdictionaryitem> list() {
        return systemdictionaryitemService.selectList(null);
    }


    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping("/json")
    public PageList<Systemdictionaryitem> json(@RequestBody SystemdictionaryitemQuery query) {
        Page<Systemdictionaryitem> page = new Page<Systemdictionaryitem>(query.getPage(), query.getRows());
        page = systemdictionaryitemService.selectPage(page);
        return new PageList<Systemdictionaryitem>(page.getTotal(), page.getRecords());
    }
}
