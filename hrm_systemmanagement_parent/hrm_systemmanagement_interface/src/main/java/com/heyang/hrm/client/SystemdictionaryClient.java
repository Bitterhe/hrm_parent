package com.heyang.hrm.client;

import com.heyang.hrm.domain.Systemdictionary;
import com.heyang.hrm.query.SystemdictionaryQuery;
import com.heyang.hrm.util.AjaxResult;
import com.heyang.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ZUUL-GATEWAY",configuration = FeignClientsConfiguration.class,
        fallbackFactory = SystemdictionaryClientHystrixFallbackFactory.class)
@RequestMapping("/systemdictionary")
public interface SystemdictionaryClient {
    /**
     * 保存和修改公用的
     * @param systemdictionary  传递的实体
     * @return Ajaxresult转换结果
     */
    @GetMapping("/save")
    AjaxResult save(Systemdictionary systemdictionary);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取对象
    @RequestMapping("/{id}")
    Systemdictionary get(@RequestParam(value="id",required=true) Long id);


    /**
     * 查看所有的信息
     * @return
     */
    @RequestMapping("/list")
    public List<Systemdictionary> list();

    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @PostMapping("/json")
    PageList<Systemdictionary> json(@RequestBody SystemdictionaryQuery query);
}
