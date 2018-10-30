package com.winning.isc.model;

import java.io.Serializable; 

import org.apache.ibatis.type.Alias; 

import com.winning.isc.model.BaseDomain;

import lombok.Data;

/**
 * @author ISC [Implementation service center]
 * @title 
 * @email Winning Health
 * @package com.winning.isc.model
 * @date 2018-43-30 09:43:08
 */
@Alias("pubOrgExt")
@Data
public class PubOrgExt extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：ORG_ID
     * 备注: 
     * 默认值：无
     */
    private Long orgId;
    /**
     * 字段名：ORG_NAME
     * 备注: 
     * 默认值：无
     */
    private String orgName;
    /**
     * 字段名：ORG_CODE
     * 备注: 
     * 默认值：无
     */
    private String orgCode;
    /**
     * 字段名：ORG_NAME_EXT
     * 备注: 
     * 默认值：无
     */
    private String orgNameExt;
}