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

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class ThreadFactoryAdapter.
 *
 * @author Michal Bocek
 * @since 1.0.0
 */
public class ThreadFactoryAdapter implements ThreadFactory {
	
	private static String ATF_THREAD_NAME = "atf-thread-";
	private ThreadGroup threadGroup;
	private AtomicInteger counter = new AtomicInteger();

	public ThreadFactoryAdapter(ThreadGroup threadGroup) {
		this.threadGroup = threadGroup;
	}
	
	@Override
	public Thread newThread(Runnable runnable) {
		Thread newThread = new Thread(threadGroup, runnable, ATF_THREAD_NAME + counter.getAndIncrement());
		return newThread;
	}

}
