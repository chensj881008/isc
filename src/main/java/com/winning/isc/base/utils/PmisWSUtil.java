package com.winning.isc.base.utils;

import com.winning.isc.ws.client.*;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import com.winning.isc.base.Constants;

/**
 * @author chenshijie
 * @title
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj.base.util
 * @date 2018-02-05 13:19
 */
public class PmisWSUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmisWSUtil.class);

    private static LBEBusinessService lbeBusinessService = null;

    /**
     * 获取登录结果，主要提取结果中sessionId用户后续查询使用
     * @return
     */
    public static LoginResult createLoginResult() {

        LoginResult result = createLBEBusinessService().login(Constants.PmisWSConstants.WS_USER,
                             Constants.PmisWSConstants.WS_PASSWORD,
                            "",
                            Constants.PmisWSConstants.WS_ALGORITHM,
                           "");
        LOGGER.info("WebService用户"+Constants.PmisWSConstants.WS_USER+"登录系统："+result.getMessage());

        return result;
    }

    /**
     * 退出登录解决超时问题
     */
    public static void createLogoutResult(LoginResult result) {
       LogoutResult logoutResult = createLBEBusinessService().logout(result.getSessionId());
       LOGGER.info("WebService用户"+Constants.PmisWSConstants.WS_USER+"退出登录："+logoutResult.getMessage());
    }

    /**
     * 获取WS服务 LBEBusinessService
     * @return
     */
    public static LBEBusinessService createLBEBusinessService() {
        if (lbeBusinessService == null) {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(LBEBusinessService.class);
            factory.setAddress(Constants.PmisWSConstants.WS_URL);
            lbeBusinessService = factory.create(LBEBusinessService.class);
        }
        return lbeBusinessService;
    }

    /**
     * 用户登录验证参数
     * @param userid
     * @param password
     * @return
     */
    public static List<LbParameter> createUserLoginLbParameter(String userid, String password) {
        List<LbParameter> params = new ArrayList<>();
        LbParameter param = new LbParameter();
        param.setName("Puserid");
        param.setValue(userid);
        params.add(param);
        param = new LbParameter();
        param.setName("Ppassword");
        param.setValue(password);
        params.add(param);
        param = new LbParameter();
        param.setName("Ptype");
        param.setValue("2");
        params.add(param);
        return params;
    }

    /**
     * 创建查询需要的参数
     * @param quertType 参考Constansts.PmisWSConstants.WS_SERVICE_TYPE_*
     * @return params
     */
    public static List<LbParameter> createLbParameter(String quertType){
        LbParameter param = new LbParameter();
        param.setName(Constants.PmisWSConstants.QUERY_TYPE_NAME);
        param.setValue(quertType);
        List<LbParameter> params = new ArrayList<LbParameter>();
        params.add(param);
        return params;
    }

    /**
     *  封装第一次查询的QueryOption
     * @return option
     */
    public static QueryOption createFirstCountValueOption(){
        QueryOption option = new QueryOption();
        option.setBatchNo(1);
        option.setBatchSize(Constants.PmisWSConstants.QUERY_FIRST_BATCH_SIZE);
        option.setQueryCount(true);
        return option;
    }

    /**
     * 封装分页查询的QueryOption
     * 用来查询不足一页的数据
     * @param page  页码
     * @param pageSize 每页显示值
     * @return option
     */
    public static QueryOption createQueryValueOption(int page,int pageSize){
        QueryOption option = new QueryOption();
        option.setBatchNo(page);
        option.setBatchSize(pageSize);
        option.setQueryCount(false);
        return option;
    }

    /**
     * 封装分页查询的QueryOption
     * 用来查询某一页的数据
     * @param page 页码
     * @return option
     */
    public static QueryOption createQueryValueOption(int page){
        QueryOption option = new QueryOption();
        option.setBatchNo(page);
        option.setBatchSize(Constants.PmisWSConstants.QUERY_BATCH_SIZE);
        option.setQueryCount(false);
        return option;
    }

}
