package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("bDart")
public class BlueDart implements Courier {
	public BlueDart() {
		System.out.println("BlueDart:0-param constructor");
	}
	
	public  String deliver(int oid) {
		return oid+" orderno   items  are delivered by BlueDart";
	}

}
