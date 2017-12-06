package com.app.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	
	public static final String MEDIA_TYPE="application/json";
	public static final String TEXT="text/plain";
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
