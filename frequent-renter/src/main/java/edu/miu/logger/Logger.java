package edu.miu.logger;

import org.springframework.stereotype.Service;

@Service
public class Logger implements ILogger{
	public void info(String logstring) {
		java.util.logging.Logger.getLogger("FrequentRenterLogger").info(logstring);
	}
}
