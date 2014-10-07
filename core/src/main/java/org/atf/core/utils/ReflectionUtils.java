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
package org.atf.core.utils;

import static org.atf.core.utils.Asserts.checkForException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.atf.Test;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public final class ReflectionUtils {

	private ReflectionUtils() {
	}
	
	public static Class<?> classForName(String className) {
		Class<?> result;
		try {
			result = Class.forName(className);
		} catch (ClassNotFoundException e) {
			checkForException(String.format("Class %s not found", className), e);
			// never occurs - runtime exception is thrown
			result = null;
		}
		return result;
	}

	public static Collection<Method> getTestMethods(Class<?> testClass) {
		List<Method> methods = new ArrayList<Method>(Arrays.asList(testClass.getMethods()));
		Iterator<Method> iterator = methods.iterator();
		while(iterator.hasNext()) {
			Method method = iterator.next();
			if (!method.isAnnotationPresent(Test.class)) {
				iterator.remove();
			}
		}
		return methods;
	}
}
