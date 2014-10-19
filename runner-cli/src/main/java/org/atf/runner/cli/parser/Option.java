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
 * @author Michal Bocek
 * @since 1.0.0
 */
public class Option {

	private String shortParam;
	private String longParam;
	private String description;
	private String paramDescription;
	private boolean mandatory;
	private boolean requiredParam;
	
	public Option() {
		this.mandatory = false;
		this.requiredParam = false;
	}
	
	public Option shortParam(String shortParam) {
		this.shortParam = shortParam;
		return this;
	}
	
	public Option longParam(String longParam) {
		this.longParam = longParam;
		return this;
	}
	
	public Option description(String description) {
		this.description = description;
		return this;
	}
	
	public Option paramDescription(String paramDescription) {
		this.paramDescription = paramDescription;
		return this;
	}
	
	public Option mandatory() {
		this.mandatory = true;
		return this;
	}

	public Option requiredParam() {
		this.requiredParam = true;
		return this;
	}

	public String getShortParam() {
		return shortParam;
	}
	
	public String getLongParam() {
		return longParam;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getParamDescription() {
		return paramDescription;
	}
	
	public boolean isMandatory() {
		return mandatory;
	}

	public boolean isRequiredParam() {
		return requiredParam;
	}

	@Override
	public String toString() {
		return "Option [shortParam=" + shortParam + ", longParam=" + longParam + ", description=" + description
				+ ", paramDescription=" + paramDescription + ", mandatory=" + mandatory + ", requiredParam="
				+ requiredParam + "]";
	}
}
