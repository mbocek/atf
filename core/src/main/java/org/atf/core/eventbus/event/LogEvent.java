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
package org.atf.core.eventbus.event;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class LogEvent extends BaseEvent {
	
	private LogLevel level;
	private String messageText;	
	private Object[] messageParams;
	private Throwable throwable;
	
	private enum LogLevel {
		FATAL, ERROR, WARN, INFO, DEBUG, TRACE;
	}
	
	public LogMessageOperation fatal() {
		level = LogLevel.FATAL;
		return new LogMessageOperation(this);
	}
	
	public LogMessageOperation error() {
		level = LogLevel.ERROR;
		return new LogMessageOperation(this);
	}
	
	public LogMessageOperation warn() {
		level = LogLevel.WARN;
		return new LogMessageOperation(this);
	}
	
	public LogMessageOperation info() {
		level = LogLevel.INFO;
		return new LogMessageOperation(this);
	}
	
	public LogMessageOperation debug() {
		level = LogLevel.DEBUG;
		return new LogMessageOperation(this);
	}
	
	public LogMessageOperation trace() {
		level = LogLevel.TRACE;
		return new LogMessageOperation(this);
	}
	
	public class LogMessageOperation {
		private LogEvent event;
		
		public LogMessageOperation(LogEvent event) {
			this.event = event;
		}
		
		public LogMessageOperation message(String message) {
			messageText = message;
			return this;
		}
		
		public LogMessageOperation params(Object...params) {
			messageParams = params;
			return this;
		}
		
		public LogMessageOperation exception(Throwable exception) {
			throwable = exception;
			return this;
		}
		
		public LogEvent build() {
			return event;
		}
	}
	
	@Override
	public long getFiredOn() {
		return super.getFiredOn();
	}
	
	public LogLevel getLevel() {
		return level;
	}
	
	public String getMessage() {
		return messageText;
	}
	
	public Object[] getMessageParams() {
		return messageParams;
	}
	
	public Throwable getThrowable() {
		return throwable;
	}
}
