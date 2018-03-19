package de.hybris.platform.customerreview.incep;

import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CustomerReviewExercise implements MethodInterceptor
{
	
	private String curse_words;
	
	public String getCurse_words() {
		return curse_words;
	}

	public void setCurse_words(String curse_words) {
		this.curse_words = curse_words;
	}

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		
		try{
			
			Object[] methodArguments = methodInvocation.getArguments();
			
			if(methodArguments[0] !=null){
				
				Double rating = (Double)methodArguments[0];
				
				if(rating.doubleValue()<0)
				throw new CustomerReviewExerciseException("  < 0 ");
			
				
				String comment = (String)methodArguments[2];
				String[] comment_separated = comment.split("[ ]");
				List<String> comment_listed = Arrays.asList(comment_separated);
				
				
				String[] curse_words_separated = curse_words.split("[ ]");
				for (String curse_word : curse_words_separated) {
					if(comment_listed.contains(curse_word)){
						throw new CustomerReviewExerciseException(" Curse Word(s) exists ");
					}
				}
			}
			
			Object result = methodInvocation.proceed();
		
			return result;
		
		}catch(Exception e){
			throw e;
		}
	}	
}