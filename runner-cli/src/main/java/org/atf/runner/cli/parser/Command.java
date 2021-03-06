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
package org.atf.runner.cli.parser;

/**
 * The Enum Command.
 */
public enum Command {
	CLASS(new Option().shortParam("-c").longParam("--class").description("Class name").paramDescription("class name").requiredParam()),
	PACKAGE(new Option().shortParam("-p").longParam("--package").description("Package name").paramDescription("package name").requiredParam());
	
	private Option option;

	private Command(Option option) {
		this.option = option;
	}
	
	public Option getOption() {
		return this.option;
	}
	
	public static Command commandByName(String commandName) {
		for (Command command : Command.values()) {
			if (command.option.getShortParam().equals(commandName) ||
					command.option.getLongParam().equals(commandName)) {
				return command;
			}
		}
		throw new IllegalArgumentException("Command not found: " + commandName);
	}
}