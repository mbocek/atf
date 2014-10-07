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
package org.atf.core.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.atf.core.api.TestClassContext;
import org.atf.core.api.TestContext;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class TestClassContextImpl implements TestClassContext {

	private Collection<TestContext> testContexts;
	
	public TestClassContextImpl() {
		testContexts = new HashSet<TestContext>();
	}
	
	public void addTestContext(TestContext testContext) {
		this.testContexts.add(testContext);
	}
	/* 
	 * (non-Javadoc)
	 * @see org.atf.core.api.TestClassContext#getTestMethods()
	 */
	@Override
	public Collection<TestContext> getTestContexts() {
		return Collections.unmodifiableCollection(testContexts);
	}

}
