package com.nt.comp;

public final class CNGEngine implements Engine {
	
	public CNGEngine() {
		System.out.println("CNGEngine:0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("CNGEngine:: Engine started");
		
	}

	@Override
	public void stop() {
		System.out.println("CNGEngine:: Engine stopped");
		
	}

}
