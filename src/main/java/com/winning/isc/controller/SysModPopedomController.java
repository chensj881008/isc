package com.winning.isc.controller;

import com.winning.isc.base.Constants;
import com.winning.isc.model.SysModPopedom;
import com.winning.isc.model.SysRoleInfo;
import com.winning.isc.model.support.NodeTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenshijie
 * @title
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj.web.controller
 * @date 2018-02-26 11:32
 */
@RestController
@RequestMapping(value = "/admin/rolemodule")
public class SysModPopedomController extends BaseController {

    @RequestMapping(value = "/query")
    @ResponseBody
    public Map<String, Object> queryRoleModuleMapping(Long roleId) {
        SysModPopedom modPopedom = new SysModPopedom();
        modPopedom.setRoleId(roleId);
        List<Long> modIdList = super.getFacade().getSysModPopedomService().getModuleIdList(modPopedom);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        result.put("data", modIdList);
        return result;
    }



   @RequestMapping(value = "/add")
   @ResponseBody
   public Map<String, Object> addModPopedomMapping(@RequestBody List<SysModPopedom> modPopedomList) {
       super.getFacade().getSysModPopedomService().createSysModPopedomByList(modPopedomList);
       Map<String, Object> result = new HashMap<String, Object>();
       result.put("status", Constants.SUCCESS);
       return result;
   }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> deleteModPopedomMapping(SysModPopedom modPopedom) {
        super.getFacade().getSysModPopedomService().removeSysModPopedom(modPopedom);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        return result;
    }




    @RequestMapping(value = "/addPopedom")
    @ResponseBody
    public Map<String, Object> upagteModPopedomMapping(String idList) {
        super.getFacade().getSysModPopedomService().modifyModPopedomMapping(idList);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        return result;
    }

    @RequestMapping(value = "/queryRolePopedom")
    @ResponseBody
    public Map<String, Object> queryRolePopedom(Long roleId) {
        SysModPopedom modPopedom = new SysModPopedom();
        modPopedom.setRoleId(roleId);
        List<SysModPopedom> modPopedomList = super.getFacade().getSysModPopedomService().getSysModPopedomHasPopedomList(modPopedom);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        result.put("data", modPopedomList);
        return result;
    }
}
