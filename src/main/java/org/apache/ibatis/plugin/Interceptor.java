/*
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * @author Clinton Begin
 * 插件必须实现的一个接口
 */
public interface Interceptor {

  // 直接覆盖所要拦截的对象原有方法，invocation 是可以通过反射调用原来的对象
  Object intercept(Invocation invocation) throws Throwable;

  // target 是被拦截的对象，给被拦截对象生成一个代理
  default Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  /**
   *  设置参数用的 ，可以配置一些信息，来给过滤读取，比如说，要拦截 每个查询不超过100条，
   *  那么这个100有可能是配置的，就放配置文件来读取，然后给过滤器来设置进去
   * @param properties
   */
  default void setProperties(Properties properties) {
    // NOP
  }

}
