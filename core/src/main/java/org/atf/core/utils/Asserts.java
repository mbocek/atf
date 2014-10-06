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

import java.util.Iterator;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public final class Asserts {

	private Asserts() {
	}
	
	public static void checkForNextItem(String message, Iterator<?> iterator) {
		if (!iterator.hasNext()) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkForException(String message, Throwable exception) {
		if (exception instanceof ClassNotFoundException) {
			throw new IllegalStateException(message, exception);
		} else {
			throw new RuntimeException(message, exception);
		}
	}
}
