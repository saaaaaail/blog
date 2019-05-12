package com.sail.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/12 21:21
 */

@Data
@ApiModel(value = "返回实体类",description = "返回实体类")
public class ResponseDataDTO<T> implements Serializable {

    @ApiModelProperty(value = "返回状态：1成功、0失败",name = "status",example = "1")
    private int status;

    @ApiModelProperty(value = "返回消息",name = "message",example = "success")
    private String message;

    @ApiModelProperty(value = "重定向url",name = "redirectUrl",example = " ")
    private String redirectUrl;

    @ApiModelProperty(value = "返回code",name = "code",example = "200")
    private int code;

    @ApiModelProperty(value = "返回数据",name = "data",example = " ")
    private T data;

    private ResponseDataDTO(){}

    private ResponseDataDTO(int status, String message, String redirectUrl, int code, T data) {
        this.status = status;
        this.message = message;
        this.redirectUrl = redirectUrl;
        this.code = code;
        this.data = data;
    }

    public static ResponseDataDTO success(){
        return new ResponseDataDTO<>(1,"成功","",200,null);
    }

    public static<T> ResponseDataDTO<T> success(T data){
        return new ResponseDataDTO<>(1,"成功","",200,data);
    }

    public static<T> ResponseDataDTO<T> success(String redirectUrl,T t) {
        return new ResponseDataDTO<>(1,"成功",redirectUrl,200,t);
    }

    public static<T> ResponseDataDTO<T> success(Integer code,T t) {
        return new ResponseDataDTO(1,"成功","",code,t);
    }

    public static ResponseDataDTO error() {
        return new ResponseDataDTO<>(0,"error","",500,null);
    }

    public static ResponseDataDTO error(String message) {
        return new ResponseDataDTO<>(0,message,"",500,null);
    }

    public static ResponseDataDTO error(Integer code) {
        return new ResponseDataDTO<>(0,"error","",code,null);
    }

    public static<T> ResponseDataDTO<T> error(String message,Integer code) {
        return new ResponseDataDTO<>(0,message,"",code,null);
    }

}
