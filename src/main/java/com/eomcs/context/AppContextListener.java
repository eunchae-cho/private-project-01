package com.eomcs.context;

import java.util.Map;

public interface AppContextListener {

	void contextInitialized(Map<String, Object> context);
	void contextDestoryed(Map<String, Object> context);
}
