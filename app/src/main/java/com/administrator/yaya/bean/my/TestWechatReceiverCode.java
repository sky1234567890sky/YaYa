package com.administrator.yaya.bean.my;
//微信二维码
public class TestWechatReceiverCode {
    /**
     * timestamp : 2019-11-04 17:52:51
     * status : 500
     * error : Internal Server Error
     * message : com.ruoyi.framework.shiro.session.OnlineSession cannot be cast to com.ruoyi.framework.shiro.session.OnlineSession
     * trace : java.lang.ClassCastException: com.ruoyi.framework.shiro.session.OnlineSession cannot be cast to com.ruoyi.framework.shiro.session.OnlineSession
     at com.ruoyi.framework.shiro.session.OnlineSessionDAO.doDelete(OnlineSessionDAO.java:109)
     at org.apache.shiro.session.mgt.eis.CachingSessionDAO.delete(CachingSessionDAO.java:304)
     at org.apache.shiro.session.mgt.DefaultSessionManager.delete(DefaultSessionManager.java:240)
     at org.apache.shiro.session.mgt.DefaultSessionManager.afterExpired(DefaultSessionManager.java:207)
     at org.apache.shiro.session.mgt.AbstractValidatingSessionManager.onExpiration(AbstractValidatingSessionManager.java:159)
     at org.apache.shiro.web.session.mgt.DefaultWebSessionManager.onExpiration(DefaultWebSessionManager.java:284)
     at org.apache.shiro.session.mgt.AbstractValidatingSessionManager.validate(AbstractValidatingSessionManager.java:145)
     at org.apache.shiro.session.mgt.AbstractValidatingSessionManager.doGetSession(AbstractValidatingSessionManager.java:120)
     at org.apache.shiro.session.mgt.AbstractNativeSessionManager.lookupSession(AbstractNativeSessionManager.java:148)
     at org.apache.shiro.session.mgt.AbstractNativeSessionManager.getSession(AbstractNativeSessionManager.java:140)
     at org.apache.shiro.mgt.SessionsSecurityManager.getSession(SessionsSecurityManager.java:156)
     at org.apache.shiro.mgt.DefaultSecurityManager.resolveContextSession(DefaultSecurityManager.java:461)
     at org.apache.shiro.mgt.DefaultSecurityManager.resolveSession(DefaultSecurityManager.java:447)
     at org.apache.shiro.mgt.DefaultSecurityManager.createSubject(DefaultSecurityManager.java:343)
     at org.apache.shiro.subject.Subject$Builder.buildSubject(Subject.java:845)
     at org.apache.shiro.web.subject.WebSubject$Builder.buildWebSubject(WebSubject.java:148)
     at org.apache.shiro.web.servlet.AbstractShiroFilter.createSubject(AbstractShiroFilter.java:292)
     at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:359)
     at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:96)
     at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:124)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)
     at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:92)
     at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:93)
     at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:200)
     at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
     at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
     at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:199)
     at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)
     at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:490)
     at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)
     at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)
     at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)
     at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)
     at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)
     at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)
     at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:791)
     at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1417)
     at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
     at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
     at java.lang.Thread.run(Thread.java:748)

     * path : /yayaApp/userCodeImg
     */
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String trace;
    private String path;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
