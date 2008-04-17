/**
 * 
 */
package org.misrical.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.misrical.salat.ISalaatClock;

/**
 * @author mustafa
 *
 */
public class SalaatMonth //implements Map<Integer, ISalaatClock> {
{
    private Map<Integer, ISalaatClock> storageDelegate = new HashMap<Integer, ISalaatClock>();

//	@Override
	public void clear() {
		storageDelegate.clear();
	}

//	@Override
	public boolean containsKey(Object key) {
		return storageDelegate.containsKey(key);
	}

//	@Override
	public boolean containsValue(Object value) {
		return storageDelegate.containsValue(value);
	}

//	@Override
//	public Set<Entry<Integer,ISalaatClock>> entrySet() {
//		return storageDelegate.entrySet();
//	}

//	@Override
	public ISalaatClock get(Object key) {
		return storageDelegate.get(key);
	}

//	@Override
	public boolean isEmpty() {
		return storageDelegate.isEmpty();
	}

//	@Override
	public Set<Integer> keySet() {
		return storageDelegate.keySet();
	}

//	@Override
	public ISalaatClock  put(Integer key, ISalaatClock value) {
		return storageDelegate.put(key, value);
	}

//	@Override
	public void putAll(Map<? extends Integer, ? extends ISalaatClock> m) {
	    storageDelegate.putAll(m);
	}

//	@Override
	public ISalaatClock remove(Object key) {
		return storageDelegate.remove(key);
	}

//	@Override
	public int size() {
		return storageDelegate.size();
	}

//	@Override
	public Collection<ISalaatClock> values() {
		return storageDelegate.values();
	}

}
