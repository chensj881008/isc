package com.winning.isc.ws.service;


import com.winning.isc.base.utils.ConnectionUtil;
import com.winning.isc.base.Constants;
import com.winning.isc.base.utils.PmisWSUtil;
import com.winning.isc.ws.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenshijie
 * @title PMIS接口表导入数据表
 * @email chensj@winning.com.cm
 * @package cn.com.winning.ssgj.ws.service
 * @date 2018-02-05 13:09
 * wsdl2java -encoding utf-8 -p com.winning.isc.ws.client -d D:\\ws\\  http://203.110.176.178:9089/service/LBEBusiness?wsdl
 */
@Component
public class PmisWebServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmisWebServiceClient.class);
    /**
     * PMIS接口表信息
     */
    private static final Map<String, String> pmisInfoData;
    static {
        pmisInfoData = new HashMap<String, String>();
        pmisInfoData.put("1", "SYS_USER_INFO"); //用户信息
        pmisInfoData.put("8", "SYS_ORG"); //组织机构
    }


    /**
     * 加载PMIS系统接口数据
     */
    public static void insertData() {
        for (String dataType : pmisInfoData.keySet()) {
            String tableNam = pmisInfoData.get(dataType);
            generateDymaicSql(tableNam, dataType);
        }
    }

    public static void insertPMISInterfaceData(String dataType) {
        String tableName = pmisInfoData.get(dataType);
        generateDymaicSql(tableName, dataType);
    }


    /**
     * 用户登录(PMIS验证)
     * @param userid 工号
     * @param password 密码(MD5)
     * @return
     */
    public QueryResult userLoginValidateByPmis(String userid, String password){
        LBEBusinessService lbeBusinessService = PmisWSUtil.createLBEBusinessService();
        LoginResult loginResult = PmisWSUtil.createLoginResult();
        List<LbParameter> params = PmisWSUtil.createUserLoginLbParameter(userid,password);
        QueryResult queryResult = lbeBusinessService.query(
                loginResult.getSessionId(),
                Constants.PmisWSConstants.USER_LOGIN_WS_SERVICE_OBJECT_NAME,
                params,
                "",
                new QueryOption());
        PmisWSUtil.createLogoutResult(loginResult);
        return queryResult;
    }


    /**
     * SQL数据生成
     *
     * @param tableName
     * @param dataType
     */
    private static void generateDymaicSql(String tableName, String dataType) {
        LOGGER.info("删除表" + tableName + "数据开始");
        String sql = "";
        if (dataType.equals(Constants.PmisWSConstants.WS_SERVICE_QUERY_USER)) {
            sql = "DELETE FROM " + tableName + " WHERE USER_TYPE='1';";
        } else {
            sql = "DELETE FROM " + tableName + " ;";
        }
        LOGGER.info("删除表SQL：" + sql);
        executeSqlInfo(sql);
        LOGGER.info("删除表" + tableName + "数据结束");
        LBEBusinessService lbeBusinessService = PmisWSUtil.createLBEBusinessService();
        LoginResult loginResult = PmisWSUtil.createLoginResult();
        List<LbParameter> params = PmisWSUtil.createLbParameter(dataType);
        QueryOption queryOption = PmisWSUtil.createFirstCountValueOption();
        QueryResult result = lbeBusinessService.query(loginResult.getSessionId(), Constants.PmisWSConstants.PMIS_DATA_LOAD_WS_SERVICE_OBJECT_NAME,
                params, "", queryOption);
        if (result.getResult() <= 0) {
            throw new RuntimeException(result.getMessage());
        } else {
            long statTime = System.currentTimeMillis();
            int total = result.getCount();
            LOGGER.info("导入表" + tableName + "数据开始:");
            LOGGER.info(tableName + "表数据量：" + total + "  列数：" + result.getMetaData().getColumnCount());
            int pageSize = Constants.PmisWSConstants.QUERY_BATCH_SIZE;
            int lastPageSize = total % pageSize;
            int page = 0;
            boolean pageEnd = false;
            if (lastPageSize > 0) {
                page = total / pageSize + 1;
                pageEnd = true;
            } else {
                page = total / pageSize;
                pageEnd = false;
            }
            for (int i = 1; i <= page; i++) {
                if ((i == page) && pageEnd) {
                    queryOption = PmisWSUtil.createQueryValueOption(i, pageSize);
                    result = lbeBusinessService.query(loginResult.getSessionId(), Constants.PmisWSConstants.PMIS_DATA_LOAD_WS_SERVICE_OBJECT_NAME,
                            params, "", queryOption);
                    resolveWSResult(result, tableName);
                } else {
                    queryOption = PmisWSUtil.createQueryValueOption(i);
                    result = lbeBusinessService.query(loginResult.getSessionId(), Constants.PmisWSConstants.PMIS_DATA_LOAD_WS_SERVICE_OBJECT_NAME,
                            params, "", queryOption);
                    resolveWSResult(result, tableName);
                }
            }
            long endTime = System.currentTimeMillis();
            LOGGER.info("导入表" + tableName + "数据结束，耗时：" + (endTime - statTime));
        }
        PmisWSUtil.createLogoutResult(loginResult);
    }

    private static void resolveWSResult(QueryResult result, String tableName) {
        if (tableName.toUpperCase().equals("SYS_USER_INFO")) {
            resolveUserInfoData(result);
        } else {
            generateSQLInfo(result, tableName);
        }
    }

    /**
     * 生成其他接口表信息
     *
     * @param result
     * @param tableName
     */
    private static void generateSQLInfo(QueryResult result, String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into " + tableName.toUpperCase() + " values \n");
        List<LbRecord> recordList = result.getRecords();
        List<ColInfo> colInfos = result.getMetaData().getColInfo();

        for (int i = 0; i < recordList.size(); i++) {
            LbRecord record = recordList.get(i);
            List<Object> values = record.getValues();
            for (int j = 0; j < values.size(); j++) {
//                 开始数据为数字
                if (j == 0 && colInfos.get(j).getType() == 1) {
                    sb.append("(" + resolveValue(values.get(j)) + ",");
//              开始数据为字符或者时间
                } else if (j == 0 && (colInfos.get(j).getType() == 0 || colInfos.get(j).getType() == 3)) {
                    sb.append("(\'" + resolveStringValue(values.get(j)) + "\',");
//              全部结束数据为数字
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 1) &&
                        (i == recordList.size() - 1)) {
                    sb.append(resolveValue(values.get(j)) + " );  \n");
//              全部结束数据为字符或者时间
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 0 || colInfos.get(j).getType() == 3) &&
                        (i == recordList.size() - 1)) {
                    sb.append("\'" + resolveStringValue(values.get(j)) + "\' );  \n");
//              单行结束为数字
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 1)) {
                    sb.append(resolveValue(values.get(j)) + "  ),  \n");
//              单行结束为字符或者时间
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 0 || colInfos.get(j).getType() == 3)) {
                    sb.append("\'" + resolveStringValue(values.get(j)) + " \' ),\n");
//              字段处理 数字
                } else if (colInfos.get(j).getType() == 1) {
                    sb.append(resolveValue(values.get(j)) + ",");
                } else if (colInfos.get(j).getType() == 0 || colInfos.get(j).getType() == 3) {
//              字段处理 字符或者时间
                    sb.append("\'" + resolveStringValue(values.get(j)) + "\',");
                }
            }
        }
//        System.out.println(sb.toString());
        executeSqlInfo(sb.toString());
    }

    /**
     * 处理字符串中存在的单引号问题
     *
     * @param o
     * @return
     */
    private static String resolveStringValue(Object o) {
        return o.toString().replace("'", "‘");
    }

    /**
     * 生成用户信息SQL
     *
     * @param result
     */
    private static void resolveUserInfoData(QueryResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into SYS_USER_INFO (");
        List<LbRecord> recordList = result.getRecords();
        List<ColInfo> colInfos = result.getMetaData().getColInfo();
        for ( int colNum = 0 ; colNum < colInfos.size() ;colNum++) {
            if(colNum == colInfos.size() -1){
                sb.append(colInfos.get(colNum).getLabel().toUpperCase());
            }else{
                sb.append(colInfos.get(colNum).getLabel().toUpperCase()+",");
            }
        }
        sb.append(" ) values \n");
        for (int i = 0; i < recordList.size(); i++) {
            LbRecord record = recordList.get(i);
            List<Object> values = record.getValues();
            for (int j = 0; j < values.size(); j++) {
                if (j == 0 && colInfos.get(j).getType() == 1) {
                    sb.append("(" + values.get(j) + ",");
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 1) &&
                        (i == recordList.size() - 1)) {
                    sb.append(values.get(j) + ");  \n");
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 1)) {
                    sb.append(values.get(j) + "),  \n");
                } else if (j == 0 && colInfos.get(j).getType() == 0) {
                    sb.append("(\'" + values.get(j) + "\',");
                } else if ((j == values.size() - 1) && (colInfos.get(j).getType() == 0)) {
                    sb.append("\'" + values.get(j) + " \' ),");
                } else if (colInfos.get(j).getType() == 1) {
                    sb.append(values.get(j) + ",");
                } else if (colInfos.get(j).getType() == 0) {
                    sb.append("\'" + values.get(j) + "\',");
                }
            }
        }
        System.out.println(sb);
        executeSqlInfo(sb.toString());
    }

    /**
     * 转换接口中存在数字为空的数据
     *
     * @param o
     * @return
     */
    private static Object resolveValue(Object o) {
        return o.toString().equals("") ? 0 : o;
    }

    /**
     * 执行生成SQL脚本
     *
     * @param sql
     */
    private static void executeSqlInfo(String sql) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionUtil.getConnection();
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeAll(connection, ps, rs);
        }
    }


}
