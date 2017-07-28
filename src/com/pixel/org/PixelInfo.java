package com.pixel.org;

import java.util.ArrayList;
import java.util.List;

public class PixelInfo {
	private int  index;
	private String tag;
	private List<Pixel> list = new ArrayList<>();

	public List<Pixel> getList() {
		return list;
	}

	public void setList(List<Pixel> list) {
		this.list = list;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
