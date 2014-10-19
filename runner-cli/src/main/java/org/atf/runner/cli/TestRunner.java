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
package org.atf.runner.cli;

import static org.atf.core.utils.Asserts.checkForNextItem;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.atf.core.api.TestContext;
import org.atf.core.utils.ReflectionUtils;
import org.atf.runner.cli.parser.CliHelper;
import org.atf.runner.cli.parser.Command;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class TestRunner {

	private String className;
	private static TestRunner self = new TestRunner();
	
	public static void main(String[] args) {
		boolean skipExecution = false;
		try {
			self.initialize(Arrays.asList(args));
		} catch (Throwable e) {
			System.err.println("Error: " + e.getMessage());
			CliHelper.showHelp();
			skipExecution = true;
		}

		if (!skipExecution) {
			TestContext testContext = self.configure();
			self.excute(testContext);
		}
	}

	private void initialize(List<String> args) {
		Iterator<String> iterator = args.iterator();
		while(iterator.hasNext()) {
			String stringCommand = iterator.next();
			Command command = Command.commandByName(stringCommand);
			switch (command) {
			case CLASS:
				if (command.getOption().isRequiredParam()) {
					checkForNextItem("Missing class name", iterator);
				}
				this.className = iterator.next();
				break;
			}
		}
	}

	private TestContext configure() {
		return new TestConfigurer()
						.withClass(ReflectionUtils.classForName(this.className))
		    			.configure();
	}

	private void excute(TestContext testContext) {
	    new TestExecutor().withTestContext(testContext).execute();
	}
}
