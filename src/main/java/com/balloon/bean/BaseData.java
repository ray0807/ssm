package com.balloon.bean;

import java.io.Serializable;

public class BaseData<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 144444111L;

	public String msg;

	/**
	 * success 1 fail 0
	 */
	public int errorCode;

	public Page page;

	public T data;

}
