package org.misrical;

import java.lang.reflect.Constructor;

import org.testng.IObjectFactory;

/**
 * @author mustafa
 *
 */
public class TestFactory implements IObjectFactory {

  private static final long serialVersionUID = -6948813259679484044L;

  /**
   * @see org.testng.IObjectFactory#newInstance(java.lang.reflect.Constructor, java.lang.Object[])
   */
  @Override
  public Object newInstance(Constructor arg0, Object... arg1) {
    return null;
  }

}
