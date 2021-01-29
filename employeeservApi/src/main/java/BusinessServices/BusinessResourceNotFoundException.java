package BusinessServices;

import javax.servlet.http.HttpServletResponse;

public class BusinessResourceNotFoundException extends BusinessServicesException {

    private static final long serialVersionUID = -3525899983340057094L;

    public BusinessResourceNotFoundException(String message) {
        super( HttpServletResponse.SC_NOT_FOUND, message);
    }

    public BusinessResourceNotFoundException(String message, Throwable cause) {
        super(HttpServletResponse.SC_NOT_FOUND, message, cause);
    }

    public BusinessResourceNotFoundException(Object responseBody) {
        super(HttpServletResponse.SC_NOT_FOUND, responseBody);
    }

    public String getMessageAsResponse() {
        StringBuilder msg = new StringBuilder("The service representation ");
        if (getServiceName() != null) {
            msg.append('"').append(getServiceName()).append("\" ");
        }
        msg.append("could not find the resource. ");
        if (getMessage() != null) {
            msg.append(getMessage());
        }

        return msg.toString();
    }
}

