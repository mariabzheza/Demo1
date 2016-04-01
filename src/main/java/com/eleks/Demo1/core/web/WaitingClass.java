package com.eleks.Demo1.core.web;

import java.util.concurrent.TimeoutException;

public class WaitingClass<T extends Components<T>> {

	private static final int DEFAULT_TIMEOUT = 30000;
	private static final int DEFAULT_RETRY_DELAY = 500;
	//private Components component;
	private T component;

	public WaitingClass() {

	}

	public WaitingClass<T> forComponent(T component) {
		this.component = component;
		return this;
	}

	public T toBeAwailable() {
		int timePassed = 0;
		while(timePassed <= DEFAULT_TIMEOUT) {
			if (this.component.isAwailable()) {
				return this.component;
			}
			timePassed = timePassed + delay();
		}
		if(!this.component.isAwailable()) {
			try {
				throw new TimeoutException(this.component.getClass().getSimpleName() 
						+ " component wasn't awailable after Def_Timeout " + DEFAULT_TIMEOUT + " !");
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}
		return this.component;
	}

	private int delay() {
		try {
			Thread.sleep(DEFAULT_RETRY_DELAY);
			return DEFAULT_RETRY_DELAY;
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
}
