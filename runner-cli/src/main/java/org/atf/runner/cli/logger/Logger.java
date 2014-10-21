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
package org.atf.runner.cli.logger;

/**
 * The Interface Logger.
 *
 * @author Michal Bocek
 * @since 1.0.0
 */
public interface Logger {
	
	/**
	 * Error.
	 *
	 * @param message the message
	 */
	void error(String message);

	/**
	 * Error.
	 *
	 * @param message the message
	 * @param e the e
	 */
	void error(String message, Throwable e);
	
	/**
	 * Error.
	 *
	 * @param message the message
	 * @param params the params
	 */
	void error(String message, Object...params);
	
	/**
	 * Info.
	 *
	 * @param message the message
	 */
	void info(String message);
	
	/**
	 * Info.
	 *
	 * @param message the message
	 * @param e the e
	 */
	void info(String message, Throwable e);

	/**
	 * Info.
	 *
	 * @param message the message
	 * @param params the params
	 */
	void info(String message, Object...params);
}
