package org.misrical.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.misrical.salaat.ISalaatClock;

/**
 * This is a holder class. Holds values of type ISalaatClock for a given day of
 * the month. Currently the
 * 
 * @author mustafa
 * 
 */
public class SalaatMonth {
  //The local storage values:
  private Map<Integer, ISalaatClock> storageDelegate = new HashMap<Integer, ISalaatClock>();

  public void clear() {
    storageDelegate.clear();
  }

  public boolean containsKey(Integer key) {
    return storageDelegate.containsKey(key);
  }

  public boolean containsValue(ISalaatClock value) {
    return storageDelegate.containsValue(value);
  }

  public ISalaatClock get(Integer key) {
    return storageDelegate.get(key);
  }

  public boolean isEmpty() {
    return storageDelegate.isEmpty();
  }

  public ISalaatClock put(Integer key, ISalaatClock value) {
    return storageDelegate.put(key, value);
  }

  public void putAll(Map<? extends Integer, ? extends ISalaatClock> m) {
    storageDelegate.putAll(m);
  }

  public Set<Integer> getKeySet() {
    return storageDelegate.keySet();
  }

  public ISalaatClock remove(Integer key) {
    return storageDelegate.remove(key);
  }

  public int size() {
    return storageDelegate.size();
  }

  public Collection<ISalaatClock> values() {
    return storageDelegate.values();
  }
}
