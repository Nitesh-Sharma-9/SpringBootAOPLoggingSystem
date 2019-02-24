package com.decimal.logger;

import static com.decimal.common.Constant.*;
import org.apache.logging.log4j.Logger;

public class LogManager
{
   private LogManager() {}
   
   public static final Logger GENERAL_LOGGER = org.apache.logging.log4j.LogManager.getLogger(LOGGER_TYPE_GENERAL);
   public static final Logger AUDIT_LOGGER = org.apache.logging.log4j.LogManager.getLogger(LOGGER_TYPE_AUDIT);
   public static final Logger ERROR_LOGGER = org.apache.logging.log4j.LogManager.getLogger(LOGGER_TYPE_ERROR);

}