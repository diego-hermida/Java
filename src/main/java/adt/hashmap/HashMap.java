package adt.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {

	public class hmnodes { // HashMap nodes
		K key;
		V value;
	}

	private int size = 0; // size of hashmap
	private LinkedList<hmnodes> buckets[]; // array of addresses of list

	public HashMap() {
		buckets = new LinkedList[4]; // initially create bucket of any size
		for (int i = 0; i < 4; i++)
			buckets[i] = new LinkedList<>();
	}

	public void put(final K key, final V value) throws Exception {
		final int bi = bucketIndex(key); // find the index,the new key will be
		// inserted in linklist at that index
		final int fountAt = find(bi, key); // check if key already exists or not
		if (fountAt == -1) {
			final hmnodes temp = new hmnodes(); // if doesn't exist create new
												// node
			// and insert
			temp.key = key;
			temp.value = value;
			buckets[bi].addLast(temp);
			size++;
		} else
			buckets[bi].get(fountAt).value = value;// if already exist modify
													// the value

		final double lambda = (size * 1.0) / buckets.length;
		if (lambda > 2.0)
			rehash(); // rehashing function which will increase the size of
						// bucket as soon as lambda exceeds 2.0

		return;
	}

	public V get(final K key) throws Exception {
		final int bi = bucketIndex(key);
		final int fountAt = find(bi, key);
		if (fountAt == -1)
			return null;
		else
			return buckets[bi].get(fountAt).value;
	}

	public V remove(final K key) throws Exception {
		final int bi = bucketIndex(key);
		final int fountAt = find(bi, key);
		if (fountAt == -1)
			return null;
		else {
			size--;
			return buckets[bi].remove(fountAt).value;
		}
	}

	public boolean containskey(final K key) throws Exception {
		final int bi = bucketIndex(key);
		final int fountAt = find(bi, key);
		if (fountAt == -1)
			return false;
		else
			return true;
	}

	public int size() {
		return size;
	}

	public boolean isempty() {
		return size == 0;
	}

	public ArrayList<K> keyset() throws Exception {
		final ArrayList<K> arr = new ArrayList<>();
		for (final LinkedList<HashMap<K, V>.hmnodes> bucket : buckets)
			for (int j = 0; j < bucket.size(); j++)
				arr.add(bucket.get(j).key);
		return arr;
	}

	public ArrayList<V> valueset() throws Exception {
		final ArrayList<V> arr = new ArrayList<>();
		for (final LinkedList<HashMap<K, V>.hmnodes> bucket : buckets)
			for (int j = 0; j < bucket.size(); j++)
				arr.add(bucket.get(j).value);
		return arr;
	}

	public void display() throws Exception {
		for (int i = 0; i < buckets.length; i++) {
			System.out.print("Bucket: " + i + " ");
			for (int j = 0; j < buckets[i].size(); j++) {
				final hmnodes temp = buckets[i].get(j);
				System.out.print("[" + temp.key + "->" + temp.value + "]");
			}
			System.out.println();
		}
	}

	public int find(final int bi, final K key) throws Exception {
		for (int i = 0; i < buckets[bi].size(); i++)
			if (key.equals(buckets[bi].get(i).key))
				return i;
		return -1;
	}

	public int bucketIndex(final K key) throws Exception {
		final int bi = key.hashCode();
		return Math.abs(bi % buckets.length);
	}

	private void rehash() throws Exception {
		final LinkedList<hmnodes> ob[] = buckets;
		buckets = new LinkedList[ob.length * 2];
		for (int i = 0; i < (ob.length * 2); i++)
			buckets[i] = new LinkedList<>();

		size = 0;
		for (final LinkedList<HashMap<K, V>.hmnodes> element : ob)
			for (int j = 0; j < element.size(); j++)
				put(element.get(j).key, element.get(j).value);

	}
}