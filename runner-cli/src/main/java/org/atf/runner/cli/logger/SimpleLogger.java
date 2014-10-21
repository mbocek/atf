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

import java.io.PrintStream;

/**
 * The Class SimpleLogger.
 *
 * @author Michal Bocek
 * @since 1.0.0
 */
public class SimpleLogger implements Logger {

	private static PrintStream stdout = System.out;
	private static PrintStream stderr = System.err;
	
	/* 
	 * (non-Javadoc)
	 * @see org.atf.runner.cli.logger.Logger#flatError(java.lang.String)
	 */
	@Override
	public void error(String message) {
		doPrintError(message, null);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.atf.runner.cli.logger.Logger#error(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void error(String message, Throwable e) {
		doPrintErrorStacktrace(message, e);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.atf.runner.cli.logger.Logger#flatEerror(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void error(String message, Object... params) {
		doPrintError(message, params);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.atf.runner.cli.logger.Logger#flatInfo(java.lang.String)
	 */
	@Override
	public void info(String message) {
		doPrintInfo(message, null);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.atf.runner.cli.logger.Logger#info(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void info(String message, Throwable e) {
		doPrintInfoStacktrace(message, e);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.atf.runner.cli.logger.Logger#flatInfo(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void info(String message, Object... params) {
		doPrintInfo(message, params);
	}

	
	private void doPrintError(String message, Object[] params) {
		String text = params == null ? message : String.format(message, params);
		synchronized (this) {
			stderr.println(text);
			stderr.flush();
		}
	}

	private void doPrintErrorStacktrace(String message, Throwable throwable) {
		synchronized (this) {
			stderr.println(message);
			throwable.printStackTrace(stderr);
			stderr.flush();
		}
	}
	
	private void doPrintInfo(String message, Object[] params) {
		String text = params == null ? message : String.format(message, params);
		synchronized (this) {
			stdout.println(text);
			stderr.flush();
		}
	}
	
	private void doPrintInfoStacktrace(String message, Throwable throwable) {
		synchronized (this) {
			stderr.println(message);
			throwable.printStackTrace(stderr);
			stderr.flush();
		}
	}
	
}
