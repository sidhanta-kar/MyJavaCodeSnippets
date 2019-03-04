/**
 * 
 */
package com.sidco.snippet.impl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MyRegexImpl {

	Pattern pattern;
	Matcher matcher;
	/**
	 * 
	 */
	public MyRegexImpl() {
		super();
	}
	
	/**
	 * @param pattern
	 */
	public MyRegexImpl(String pattern) {
		super();
		this.pattern = Pattern.compile(pattern);
	}

	/**
	 * @return the pattern
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = Pattern.compile(pattern);
	}

	/**
	 * @return the matcher
	 */
	public Matcher getMatcher() {
		return matcher;
	}

	/**
	 * @param matcher the matcher to set
	 */
	public void setMatcher(String matcher) {
		this.matcher = this.pattern.matcher(matcher);
	}
	
	public boolean hasMatch(){
		return this.matcher.find();
	}
	
	public boolean hasMatch(String matcher){
		this.matcher = this.pattern.matcher(matcher);
		return this.matcher.find();
	}

}
