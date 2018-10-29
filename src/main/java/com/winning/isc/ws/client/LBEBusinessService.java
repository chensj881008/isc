package com.winning.isc.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.3
 * Thu Aug 16 19:54:13 CST 2018
 * Generated source version: 2.2.3
 * 
 */
 
@WebService(targetNamespace = "http://ws.livebos.apex.com/", name = "LBEBusinessService")
@XmlSeeAlso({ObjectFactory.class})
public interface LBEBusinessService {

    @WebMethod
    @RequestWrapper(localName = "queryTasks", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryTasks")
    @ResponseWrapper(localName = "queryTasksResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryTasksResponse")
    @WebResult(name = "QueryResult", targetNamespace = "")
    public QueryResult queryTasks(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "caller", targetNamespace = "")
                    String caller,
            @WebParam(name = "queryOption", targetNamespace = "")
                    QueryOption queryOption
    );

    @WebMethod
    @RequestWrapper(localName = "getNotice", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetNotice")
    @ResponseWrapper(localName = "getNoticeResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetNoticeResponse")
    @WebResult(name = "NoticeResult", targetNamespace = "")
    public NoticeResult getNotice(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "user", targetNamespace = "")
                    String user,
            @WebParam(name = "type", targetNamespace = "")
                    int type
    );

    @WebMethod
    @RequestWrapper(localName = "logout", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.Logout")
    @ResponseWrapper(localName = "logoutResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.LogoutResponse")
    @WebResult(name = "LogoutResult", targetNamespace = "")
    public LogoutResult logout(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId
    );

    @WebMethod
    @RequestWrapper(localName = "validateUser", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ValidateUser")
    @ResponseWrapper(localName = "validateUserResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ValidateUserResponse")
    @WebResult(name = "UserInfo", targetNamespace = "")
    public QueryResult validateUser(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "userId", targetNamespace = "")
                    String userId,
            @WebParam(name = "password", targetNamespace = "")
                    String password,
            @WebParam(name = "algorithm", targetNamespace = "")
                    String algorithm,
            @WebParam(name = "securityCode", targetNamespace = "")
                    String securityCode
    );

    @WebMethod
    @RequestWrapper(localName = "queryWorkStepDetail", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryWorkStepDetail")
    @ResponseWrapper(localName = "queryWorkStepDetailResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryWorkStepDetailResponse")
    @WebResult(name = "WorkStepDetail", targetNamespace = "")
    public QueryResult queryWorkStepDetail(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "instanceId", targetNamespace = "")
                    long instanceId,
            @WebParam(name = "queryOption", targetNamespace = "")
                    QueryOption queryOption
    );

    @WebMethod
    @RequestWrapper(localName = "queryWorkflowDescribe", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryWorkflowDescribe")
    @ResponseWrapper(localName = "queryWorkflowDescribeResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryWorkflowDescribeResponse")
    @WebResult(name = "WorkflowDescirbe", targetNamespace = "")
    public WorkflowDescribeResponse queryWorkflowDescribe(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "uid", targetNamespace = "")
                    String uid,
            @WebParam(name = "startupOnly", targetNamespace = "")
                    boolean startupOnly
    );

    @WebMethod
    @RequestWrapper(localName = "queryTaskListByCondition", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryTaskListByCondition")
    @ResponseWrapper(localName = "queryTaskListByConditionResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryTaskListByConditionResponse")
    @WebResult(name = "QueryResult", targetNamespace = "")
    public QueryResult queryTaskListByCondition(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "caller", targetNamespace = "")
                    String caller,
            @WebParam(name = "condition", targetNamespace = "")
                    WorkCondition condition,
            @WebParam(name = "queryOption", targetNamespace = "")
                    QueryOption queryOption
    );

    @WebMethod
    @RequestWrapper(localName = "callBizFunction", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.CallBizFunction")
    @ResponseWrapper(localName = "callBizFunctionResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.CallBizFunctionResponse")
    @WebResult(name = "BizFunctionResult", targetNamespace = "")
    public BizFunctionResult callBizFunction(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "bizFunctionName", targetNamespace = "")
                    String bizFunctionName,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params
    );

    @WebMethod
    @RequestWrapper(localName = "doWorkAction", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.DoWorkAction")
    @ResponseWrapper(localName = "doWorkActionResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.DoWorkActionResponse")
    @WebResult(name = "WorkActionResult", targetNamespace = "")
    public WorkActionResult doWorkAction(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "workflowName", targetNamespace = "")
                    String workflowName,
            @WebParam(name = "instanceId", targetNamespace = "")
                    long instanceId,
            @WebParam(name = "actionId", targetNamespace = "")
                    int actionId,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params,
            @WebParam(name = "caller", targetNamespace = "")
                    String caller,
            @WebParam(name = "summary", targetNamespace = "")
                    String summary
    );

    @WebMethod
    @RequestWrapper(localName = "create", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.CreateResponse")
    @WebResult(name = "CreateResult", targetNamespace = "")
    public CreateResult create(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "objectName", targetNamespace = "")
                    String objectName,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params
    );

    @WebMethod
    @RequestWrapper(localName = "getUserInfo", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetUserInfo")
    @ResponseWrapper(localName = "getUserInfoResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetUserInfoResponse")
    @WebResult(name = "UserInfo", targetNamespace = "")
    public UserInfo getUserInfo(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "loginId", targetNamespace = "")
                    String loginId
    );

    @WebMethod
    @RequestWrapper(localName = "getWorkOwner", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetWorkOwner")
    @ResponseWrapper(localName = "getWorkOwnerResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetWorkOwnerResponse")
    @WebResult(name = "WorkOwnerResponse", targetNamespace = "")
    public WorkOwnerResponse getWorkOwner(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "instanceId", targetNamespace = "")
                    long instanceId,
            @WebParam(name = "stepId", targetNamespace = "")
                    int stepId
    );

    @WebMethod
    @RequestWrapper(localName = "doWorkActionByObject", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.DoWorkActionByObject")
    @ResponseWrapper(localName = "doWorkActionByObjectResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.DoWorkActionByObjectResponse")
    @WebResult(name = "WorkActionResult", targetNamespace = "")
    public WorkActionResult doWorkActionByObject(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "objectName", targetNamespace = "")
                    String objectName,
            @WebParam(name = "id", targetNamespace = "")
                    String id,
            @WebParam(name = "actionId", targetNamespace = "")
                    int actionId,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params,
            @WebParam(name = "caller", targetNamespace = "")
                    String caller,
            @WebParam(name = "summary", targetNamespace = "")
                    String summary
    );

    @WebMethod
    @RequestWrapper(localName = "killWorkflow", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.KillWorkflow")
    @ResponseWrapper(localName = "killWorkflowResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.KillWorkflowResponse")
    @WebResult(name = "LBEResult", targetNamespace = "")
    public LbeResult killWorkflow(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "workflowName", targetNamespace = "")
                    String workflowName,
            @WebParam(name = "caller", targetNamespace = "")
                    String caller,
            @WebParam(name = "instanceId", targetNamespace = "")
                    long instanceId,
            @WebParam(name = "reason", targetNamespace = "")
                    String reason
    );

    @WebMethod
    @RequestWrapper(localName = "validateSessionId", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ValidateSessionId")
    @ResponseWrapper(localName = "validateSessionIdResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ValidateSessionIdResponse")
    @WebResult(name = "LBEResult", targetNamespace = "")
    public LbeResult validateSessionId(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId
    );

    @WebMethod
    @RequestWrapper(localName = "execBizProcess", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ExecBizProcess")
    @ResponseWrapper(localName = "execBizProcessResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ExecBizProcessResponse")
    @WebResult(name = "BizProcessResult", targetNamespace = "")
    public BizProcessResult execBizProcess(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "bizProcessName", targetNamespace = "")
                    String bizProcessName,
            @WebParam(name = "id", targetNamespace = "")
                    String id,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params,
            @WebParam(name = "variables", targetNamespace = "")
                    java.util.List<LbParameter> variables
    );

    @WebMethod
    @RequestWrapper(localName = "getWorkAvailableAction", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetWorkAvailableAction")
    @ResponseWrapper(localName = "getWorkAvailableActionResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.GetWorkAvailableActionResponse")
    @WebResult(name = "AvailableWorkActionResponse", targetNamespace = "")
    public AvailableWorkActionResponse getWorkAvailableAction(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "instanceId", targetNamespace = "")
                    long instanceId
    );

    @WebMethod
    @RequestWrapper(localName = "query", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.Query")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.QueryResponse")
    @WebResult(name = "QueryResult", targetNamespace = "")
    public QueryResult query(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "objectName", targetNamespace = "")
                    String objectName,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params,
            @WebParam(name = "condition", targetNamespace = "")
                    String condition,
            @WebParam(name = "queryOption", targetNamespace = "")
                    QueryOption queryOption
    );

    @WebMethod
    @RequestWrapper(localName = "update", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.UpdateResponse")
    @WebResult(name = "LBEResult", targetNamespace = "")
    public LbeResult update(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "objectName", targetNamespace = "")
                    String objectName,
            @WebParam(name = "id", targetNamespace = "")
                    String id,
            @WebParam(name = "params", targetNamespace = "")
                    java.util.List<LbParameter> params
    );

    @WebMethod
    @RequestWrapper(localName = "execBizService", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ExecBizService")
    @ResponseWrapper(localName = "execBizServiceResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.ExecBizServiceResponse")
    @WebResult(name = "BizServiceResult", targetNamespace = "")
    public BizProcessResult execBizService(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "bizServiceName", targetNamespace = "")
                    String bizServiceName,
            @WebParam(name = "variables", targetNamespace = "")
                    java.util.List<LbParameter> variables
    );

    @WebMethod
    @RequestWrapper(localName = "login", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.LoginResponse")
    @WebResult(name = "LoginResult", targetNamespace = "")
    public LoginResult login(
            @WebParam(name = "userid", targetNamespace = "")
                    String userid,
            @WebParam(name = "password", targetNamespace = "")
                    String password,
            @WebParam(name = "scheme", targetNamespace = "")
                    String scheme,
            @WebParam(name = "algorithm", targetNamespace = "")
                    String algorithm,
            @WebParam(name = "securityCode", targetNamespace = "")
                    String securityCode
    );

    @WebMethod
    @RequestWrapper(localName = "delete", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://ws.livebos.apex.com/", className = "cn.com.winning.ssgj.ws.client.DeleteResponse")
    @WebResult(name = "LBEResult", targetNamespace = "")
    public LbeResult delete(
            @WebParam(name = "sessionId", targetNamespace = "")
                    String sessionId,
            @WebParam(name = "objectName", targetNamespace = "")
                    String objectName,
            @WebParam(name = "id", targetNamespace = "")
                    String id
    );
}