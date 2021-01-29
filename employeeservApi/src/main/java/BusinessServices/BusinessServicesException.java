package BusinessServices;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BusinessServicesException extends Exception {
    private static Logger logger = Logger.getLogger( String.valueOf( BusinessServicesException.class ) );

    private int responseCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    private Object responseBody;
    private String serviceName;
    private Map<String, Object> httpHeaders = new HashMap<String,Object>();

    public BusinessServicesException() {
    }

    public BusinessServicesException(String message) {
        super(message);
    }

    public BusinessServicesException(Throwable cause) {
        super(cause);
    }

    public BusinessServicesException(Object responseBody) {
        super();
        this.responseBody = responseBody;
    }

    public BusinessServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessServicesException(int responseCode) {
        this.responseCode = responseCode;
    }

    public BusinessServicesException(int responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    public BusinessServicesException(int responseCode, Throwable cause) {
        super(cause);
        this.responseCode = responseCode;
    }

    public BusinessServicesException(int responseCode, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public BusinessServicesException(int responseCode, Object responseBody) {
        super();
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public BusinessServicesException(int responseCode, Object responseBody, Exception cause) {
        super(cause);
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }


    public String getMessageAsResponse() {

        StringBuilder msg = new StringBuilder("The service representation ");
        if (getServiceName() != null) {
            msg.append('"').append(getServiceName()).append("\" ");
        }
        msg.append(" failed");
        if (getMessage() != null) {
            msg.append(" with following message: ").append(getMessage());
        }

        Throwable cause = getCause();
        if ((cause != null) && (cause.getMessage() != null)) {
            msg.append(" The underlying cause is: ").append(cause.getMessage());
        }

        return msg.toString();
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setHeader(String headerName, Object headerValue){
        this.httpHeaders.put(headerName, headerValue);
    }

    /**
     * Return the map of headers that are to be added to the exception response.
     *
     * This was introduced in order to allow the 503 response to declare when the
     * caller should retry the request.
     *
     * @return Return the map of headers.
     */
    public Map<String, Object> getHttpHeaders(){
        return Collections.unmodifiableMap(this.httpHeaders);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [responseCode=" + responseCode
                + ", responseBody=" + responseBody + ", serviceName="
                + serviceName + ", httpHeaders=" + httpHeaders
                + ", message=" + getMessage() + "]";
    }

}
