package de.hybris.platform.customerreview.incep;

public class CustomerReviewExerciseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String exceptionMsg;

	public CustomerReviewExerciseException(String eMsg){
		this.exceptionMsg = eMsg;
	}
	
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	public String toString(){
		return "[Customer Review Exercise Exception is  - " + this.exceptionMsg + " ]";
	}
}