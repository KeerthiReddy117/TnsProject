package com.tnsif.programs.accessmodifiers.first;

public class diffclass {

	public static void main(String[] args) {
		sameclass sc = new sameclass();
		sc.defaultmethod();
		sc.privatemethod();
		sc.protmethod();
		sc.publicmethod();
		
		//private member can't accessible
		//System.out.println(sc.privari);
		
		System.out.println(sc.defvari);
		System.out.println(sc.protvari);
		System.out.println(sc.pubvari);

	}

}
