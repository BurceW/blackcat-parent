package cn.itsource.blackcat.util;

/**
 * @author wgb
 * @version V1.0
 * @className AjaxResult
 * @description TODO
 * @date 2019/5/11 0011
 */
public class AjaxResult {

    private boolean success = true;
    private String message;
    private String errorCode;//错误码
    private Object data;//AjaxResult中封装数据

    public boolean isSuccess() {
        return success;
    }


    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public AjaxResult setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 成功
     * @return
     */
    public static AjaxResult me(){
        return new AjaxResult();
    }



}
