package devsearch.images.ws.exception;

public class RestApiImagesException extends Exception {

    private static final long serialVersionUID = 275096902867943873L;
    private String sourceExceptionMessage;
    private String exceptionCode;

    public RestApiImagesException(String message) {
	super(message);
    }

    public RestApiImagesException(ExceptionMessages message) {
	super(message.getExceptionMessage());
	this.exceptionCode = message.getExceptionCode();
    }

    public RestApiImagesException(ExceptionMessages message, String sourceExceptionMessage) {
	super(message.getExceptionMessage());
	this.exceptionCode = message.getExceptionCode();
	this.sourceExceptionMessage = sourceExceptionMessage;
    }

    public RestApiImagesException(String message, String exceptionCode, String sourceExceptionMessage) {
	super(message);
	this.exceptionCode = exceptionCode;
	this.sourceExceptionMessage = sourceExceptionMessage;
    }

    public String getSourceExceptionMessage() {
	return this.sourceExceptionMessage;
    }

    public String getExceptionCode() {
	return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
	this.exceptionCode = exceptionCode;
    }

}
