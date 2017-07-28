package com.pixel.org;

import java.util.HashMap;

public class ColorMap {
	private HashMap<Integer, Integer> map = new HashMap<>();
	public ColorMap() {
		super();
		initMap();
	}

	public int getColorIndex(int color){
		Integer i = map.get(color);
		if(i == null){
			return 0;
		}
		return i;
	}
	
	private void initMap(){
		map.put(-3355393,1);
		map.put(-13057,2);
		map.put(-3368551,3);
		map.put(-3355495,4);
		map.put(-6697831,5);
		map.put(-6697780,6);
		map.put(-6710836,7);
		map.put(-3368500,8);
		map.put(-6723994,9);
		map.put(-6710938,10);
		map.put(-10053274,11);
		map.put(-16777165,12);
		map.put(-10066279,13);
		map.put(-13434829,14);
		map.put(-26215,15);
		map.put(-13159,16);
		map.put(-103,17);
		map.put(-3342439,18);
		map.put(-6684775,19);
		map.put(-6684724,20);
		map.put(-6684673,21);
		map.put(-6697729,22);
		map.put(-65485,23);
		map.put(-3368449,24);
		map.put(-26113,25);
		map.put(-39220,26);
		map.put(-39271,27);
		map.put(-6737101,28);
		map.put(-6724045,29);
		map.put(-6710989,30);
		map.put(-26164,31);
		map.put(-3381658,32);
		map.put(-10079437,33);
		map.put(-3368602,34);
		map.put(-3355546,35);
		map.put(-10053325,36);
		map.put(-13395661,37);
		map.put(-13395610,38);
		map.put(-13395559,39);
		map.put(-13408615,40);
		map.put(-10066381,41);
		map.put(-6697882,42);
		map.put(-10040218,43);
		map.put(-13408717,44);
		map.put(-10040167,45);
		map.put(-10040116,46);
		map.put(-13408666,47);
		map.put(-10053172,48);
		map.put(-10066228,49);
		map.put(-13421722,50);
		map.put(-6723892,51);
		map.put(-3381556,52);
		map.put(-10079386,53);
		map.put(-3381607,54);
		map.put(-39322,55);
		map.put(-26266,56);
		map.put(-13210,57);
		map.put(-154,58);
		map.put(-3342490,59);
		map.put(-6684826,60);
		map.put(-10027162,61);
		map.put(-10053121,62);
		map.put(-10027111,63);
		map.put(-10066177,64);
		map.put(-10027060,65);
		map.put(-6723841,66);
		map.put(-10027009,67);
		map.put(-3381505,68);
		map.put(-10040065,69);
		map.put(-39169,70);
	}
	
}
