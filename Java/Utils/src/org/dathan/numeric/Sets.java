package org.dathan.numeric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Sets {
	public static <T> Set<Set<T>> powerSet(Collection<T> items) {
		Set<Set<T>> powerSet = new HashSet<Set<T>>();
		List<T> list = new ArrayList<T>();
		list.addAll(items);
		for (int i=1; i<=items.size(); ++i) {
			powerSet.addAll(subsetsOfSize(list, i));
		}
		return powerSet;
	}
	
	public static <T> Set<Set<T>> subsetsOfSize(Collection<T> items, int size) {
		List<T> list = new ArrayList<T>();
		list.addAll(items);
		return subsetsOfSize(list, size);
	}
	
	public static <T> Set<Set<T>> subsetsOfSize(List<T> items, int size) {
		int[] indices = new int[size];
		return recursiveSubsetBuilder(items, indices, 0);
	}
	
	private static <T> Set<Set<T>> recursiveSubsetBuilder(List<T> items, int[] indices, int indexToVary) {
		Set<Set<T>> sets = new HashSet<Set<T>>();
		if (indexToVary == indices.length) {
			Set<T> set = new HashSet<T>();
			// TODO: this'll actually generate a lot of duplicates.  We should count from the previous-index up to 9, not from 0 to 9.
			for (int i=0; i<indices.length; ++i) {
				set.add(items.get(indices[i]));
			}
			sets.add(set);
			return sets;
		}

		for(int i=0; i<items.size(); ++i) {
			indices[indexToVary] = i;
			sets.addAll(recursiveSubsetBuilder(items, indices, indexToVary+1));
		}
		return sets;
	}
	
	public static <T> Set<T> union(Set<T> first, Set<T> second) {
		Set<T> newSet = new HashSet<T>();
		newSet.addAll(first);
		newSet.addAll(second);
		return newSet;
	}
	
	public static <T> Set<T> intersection(Set<T> first, Set<T> second) {
		Set<T> newSet = new HashSet<T>();
		newSet.addAll(first);
		newSet.retainAll(second);
		return newSet;
	}
}
