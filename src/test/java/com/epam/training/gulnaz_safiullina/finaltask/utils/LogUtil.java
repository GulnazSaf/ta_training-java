package com.epam.training.gulnaz_safiullina.finaltask.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    private LogUtil() {
    }

    /**
     * Returns a logger for the specified class.
     *
     * @param clazz The class for which the logger is created.
     * @return The SLF4J logger instance.
     */
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * Returns a logger with the specified name.
     *
     * @param name The name of the logger.
     * @return The SLF4J logger instance.
     */
    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }

    /**
     * Logs an informational message.
     *
     * @param clazz   The class from which the log is being made.
     * @param message The message to log.
     */
    public static void info(Class<?> clazz, String message) {
        getLogger(clazz).info(message);
    }

    /**
     * Logs a warning message.
     *
     * @param clazz   The class from which the log is being made.
     * @param message The message to log.
     */
    public static void warn(Class<?> clazz, String message) {
        getLogger(clazz).warn(message);
    }

    /**
     * Logs an error message.
     *
     * @param clazz   The class from which the log is being made.
     * @param message The message to log.
     */
    public static void error(Class<?> clazz, String message) {
        getLogger(clazz).error(message);
    }

    /**
     * Logs an error message with a throwable.
     *
     * @param clazz   The class from which the log is being made.
     * @param message The message to log.
     * @param throwable The throwable to log.
     */
    public static void error(Class<?> clazz, String message, Throwable throwable) {
        getLogger(clazz).error(message, throwable);
    }

    /**
     * Logs a debug message.
     *
     * @param clazz   The class from which the log is being made.
     * @param message The message to log.
     */
    public static void debug(Class<?> clazz, String message) {
        getLogger(clazz).debug(message);
    }

    /**
     * Logs a trace message.
     *
     * @param clazz   The class from which the log is being made.
     * @param message The message to log.
     */
    public static void trace(Class<?> clazz, String message) {
        getLogger(clazz).trace(message);
    }
}