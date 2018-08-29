package com.jiuzhang.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag<Item> implements Iterable<Item> {

	List<Item> interalList;

	public Bag() {
		interalList = new ArrayList<Item>();
	}

	public void add(Item item) {
		interalList.add(item);
	}

	public boolean isEmpty() {
		return true;
	}

	public int size() {
		return interalList.size();
	}

	@Override
	public Iterator<Item> iterator() {
		return interalList.iterator();
	}

}
