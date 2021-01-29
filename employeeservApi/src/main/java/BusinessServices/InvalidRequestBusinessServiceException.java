package BusinessServices;

import javax.servlet.http.HttpServletResponse;

public class InvalidRequestBusinessServiceException extends BusinessServicesException {

    public InvalidRequestBusinessServiceException() {
        super( HttpServletResponse.SC_BAD_REQUEST);
    }

    public InvalidRequestBusinessServiceException(String message) {
        super(HttpServletResponse.SC_BAD_REQUEST, message);
    }

    public InvalidRequestBusinessServiceException(Throwable cause) {
        super(HttpServletResponse.SC_BAD_REQUEST, cause);
    }

    public InvalidRequestBusinessServiceException(String message, Throwable cause) {
        super(HttpServletResponse.SC_BAD_REQUEST, message, cause);
    }

    public InvalidRequestBusinessServiceException(Object responseBody) {
        super(HttpServletResponse.SC_BAD_REQUEST, responseBody);
    }

    public String getMessageAsResponse() {
        StringBuilder msg = new StringBuilder("The service representation ");
        if (getServiceName() != null) {
            msg.append('"').append(getServiceName()).append("\" ");
        }
        msg.append("received an invalid request parameter. ");
        if (getMessage() != null) {
            msg.append(getMessage());
        }

        return msg.toString();
    }

}

