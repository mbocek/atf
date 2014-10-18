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
package org.atf.core.eventbus.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.atf.core.eventbus.EventBus;
import org.atf.core.eventbus.Handler;
import org.atf.core.eventbus.event.Event;

/**
 * @author Michal Bocek
 * @since 1.0.0
 */
public class EventBusImpl implements EventBus {

	private Map<Class<?>, List<Handler<Event>>> handlers;
	
	public EventBusImpl() {
		this.handlers = new HashMap<Class<?>, List<Handler<Event>>>();
	}
	
	@Override
	public void fire(Event event) {
		for(Class<?> clazz : handlers.keySet()) {
			if (clazz.isAssignableFrom(event.getClass())) {
				publishEvent(clazz, event);
			}
		}
	}

	private void publishEvent(Class<?> clazz, Event event) {
		List<Handler<Event>> handlerList = handlers.get(clazz);
		for (Handler<Event> handler : handlerList) {
			handler.handleEvent(event);
		}
	}

	@Override
	public void register(Handler<Event> handler) {
		ParameterizedType parametrizedType = (ParameterizedType)handler.getClass().getGenericSuperclass();
		Class<?> clazz = (Class<?>)parametrizedType.getActualTypeArguments()[0];
		List<Handler<Event>> handlersList = this.handlers.get(clazz);
		if (handlersList == null) {
			handlersList = new ArrayList<Handler<Event>>();
		}
		handlersList.add(handler);
		handlers.put(clazz, handlersList);
		
	}
}
