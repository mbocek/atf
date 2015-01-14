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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class ExecutorAdapter {
	private ExecutorService executorService;
	
	public ExecutorAdapter(int threadCount, ThreadFactoryAdapter threadFactory) {
		executorService = Executors.newFixedThreadPool(threadCount, threadFactory);
	}
	
	public void execute(Task task) {
		executorService.execute(task);
	}
	
	public void forceStop() {
		executorService.shutdown();
		try {
			executorService.awaitTermination(10, TimeUnit.MICROSECONDS);
			List<Runnable> threads = executorService.shutdownNow();
			for (Runnable thread : threads) {
				Task task = (Task) thread;
				
			}
		} catch (final InterruptedException e) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}
