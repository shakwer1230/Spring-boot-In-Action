package com.sun.jsp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/25
 * @
 */
@Entity
@Table(name = "logger_infos")
@Data
public class LoggerEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ali_id")
    public Long id;

    /**
     * 客户端ip
     */
    @Column(name = "ali_client_ip")
    public String clientIp;

    /**
     * 请求uri
     */
    @Column(name = "ali_uri")
    public String uri;
    /**
     *终端请求方式 普通请求 ajax 请求
     */
    @Column(name = "ali_type")
    public String type;

    /**
     * 请求方式 post get
     */
    @Column(name = "ali_method")
    public String method;

    /**
     * 请求参数
     */
    @Column(name = "ali_param_data")
    public String paramData;

    /**
     * 请求接口唯一的sessionid
     */
    @Column(name = "ali_session_id")
    public String sessionId;

    /**
     * 请求时间
     */
    @Column(name = "ali_time",insertable = false)
    public Timestamp time;

    /**
     * 请求接口返回的时间
     */
    @Column(name = "ali_return_time")
    public String retuenTime;

    /**
     * 请求接口返回的json
     */
    @Column(name = "ali_return_data")
    public String returnData;

    /**
     * http 状态
     */
    @Column(name = "ali_http_status_code")
    public String httpStatusCode;

    /**
     * 花费总时间
     */
    @Column(name = "ali_time_consuming")
    public Integer timeConsuming;
}
