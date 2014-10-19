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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public final class CliHelper {

	private CliHelper() {
	}
	
	public static void showHelp() {
		List<String> cmdLine  = new ArrayList<String>(); 
		for (Command command : Command.values()) {
			Option option = command.getOption();
			String commandLine = option.isMandatory() ? option.getShortParam() : "[" + option.getShortParam() + "] ";
			commandLine += option.isRequiredParam() ? "<"+ option.getParamDescription() + ">" : "";
			cmdLine.add(commandLine);
		}
		
		Collections.sort(cmdLine);
		System.out.println(cmdLine);
		
		for (Command command : Command.values()) {
			Option option = command.getOption();
			String message = String.format("\t%s\t%s\t\t%s", option.getShortParam(), option.getLongParam(), option.getDescription());
			System.out.println(message);			
		}
	}
}
