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
package org.atf.core.execution;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

import org.atf.core.api.TestMethodContext;
import org.junit.Test;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class ExecutorAdapterTest {

	private class TestTask extends Task {

		public TestTask(TestMethodContext context) {
			super(context);
		}

		@Override
		public void run() {		
			System.out.println(this.getThreadName());
			System.out.println(this.getMethodName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Interupted in in sleep");
			}
		}
	}
	
	private static class TestMethodContextSimple implements TestMethodContext {
		
		private static AtomicInteger counter = new AtomicInteger();
		
		@Override
		public Method getTestMethod() {
			return null;
		}
		
		@Override
		public String getName() {
			return "test context " + counter.getAndIncrement();
		}
		
		@Override
		public String getFullName() {
			return null;
		}
	};
	
	@Test
	public void forceStopService() throws InterruptedException {
		ExecutorAdapter executorAdapter = new ExecutorAdapter(3, new ThreadFactoryAdapter(new ThreadGroup("atf")));
		for (int i = 0; i < 100; i++) {
			executorAdapter.execute(new TestTask(new TestMethodContextSimple()));
		}
		Thread.sleep(1000);
		executorAdapter.forceStop();
	}
}
