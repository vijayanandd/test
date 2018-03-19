package de.hybris.platform.customerreview.incep;

import de.hybris.platform.customerreview.jalo.CustomerReview;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CustomerReviewExerciseTotalReviewsInRange implements MethodInterceptor
{
	private int rangeBegin;
	private int rangeEnds;

	public int getRangeBegin() {
		return rangeBegin;
	}

	public void setRangeBegin(int rangeBegin) {
		this.rangeBegin = rangeBegin;
	}

	public int getRangeEnds() {
		return rangeEnds;
	}

	public void setRangeEnds(int rangeEnds) {
		this.rangeEnds = rangeEnds;
	}

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
	
		try{
			
			Object result = methodInvocation.proceed();
			List<CustomerReview> response = (List<CustomerReview>)result;
			
			Predicate<CustomerReview> customerReview = cr -> cr.getRating() < rangeBegin && cr.getRating() > rangeEnds;
			
			response.removeIf(customerReview);
			
			return response;
		
		}catch(Exception e){
			throw e;
		}
	}
}