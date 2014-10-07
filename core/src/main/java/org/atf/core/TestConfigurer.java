/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.atf.core;

import java.lang.reflect.Method;
import java.util.Collection;

import org.atf.core.api.TestClassContext;
import org.atf.core.impl.TestClassContextImpl;
import org.atf.core.impl.TestContextImpl;
import org.atf.core.utils.ReflectionUtils;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class TestConfigurer {

	private Class<?> testClass;
	
	public TestConfigurer withClass(Class<?> testClass) {
		this.testClass = testClass;
		return this;
	}

	public TestClassContext configure() {
		return buildTestContext(new TestClassContextImpl(), this.testClass);
	}

	private TestClassContext buildTestContext(TestClassContextImpl testClassContext, Class<?> testClass) {
		Collection<Method> testMethods = ReflectionUtils.getTestMethods(testClass);
		for (Method method : testMethods) {
			testClassContext.addTestContext(new TestContextImpl(method));
		}
		return testClassContext;
	}

}
