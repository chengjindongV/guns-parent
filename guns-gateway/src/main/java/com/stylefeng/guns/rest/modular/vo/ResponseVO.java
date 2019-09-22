package com.stylefeng.guns.rest.modular.vo;

/**
 * @Author: chengjindong
 * @Date: 2019/9/21 22:07
 */
public class ResponseVO<M> {

    // 返回状态【0.成功，1，业务失败，999，系统异常】
    private int status;

    // 返回信息
    private String msg;

    //返回数据实体
    private M data;

    private ResponseVO(){} // 私有无参构造？？？

    public static<M> ResponseVO success(M m){ // 成功
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(m);

        return responseVO;
    }

    public static<M> ResponseVO serviceFail(String msg){  // 业务异常
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static<M> ResponseVO appFail(String msg){  // 系统异常
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }
}
