package com.nt.beans;

public final class DieselEngine implements Engine {
	
	public DieselEngine() {
		System.out.println("DieselEngine:0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("DiselEngine:: Engine started");
		
	}

	@Override
	public void stop() {
		System.out.println("DiselEngine:: Engine stopped");
		
	}

}
