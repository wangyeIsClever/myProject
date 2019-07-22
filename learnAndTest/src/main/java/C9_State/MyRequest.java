package C9_State;

public class MyRequest {

    private String url; // 请求地址

    private String method; // 请求方法

    private boolean isMethodNessary; // 是否需要请求方法

    public boolean isMethodNessary() {
        return isMethodNessary;
    }

    public void setMethodNessary(boolean methodNessary) {
        isMethodNessary = methodNessary;
    }

    public MyRequest(String url, String method, boolean isMethodNessary) {
        this.url = url;
        this.method = method;
        this.isMethodNessary = isMethodNessary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
