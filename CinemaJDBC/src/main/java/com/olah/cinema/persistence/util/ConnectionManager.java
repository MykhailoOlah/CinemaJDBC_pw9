package com.olah.cinema.persistence.util;

import com.olah.cinema.persistence.exception.ConnectionCloseException;
import com.olah.cinema.persistence.exception.ConnectionPoolException;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionManager {
	private static final String URL = "jdbc:h2:./src/main/resources/cinema_db";
	private static final Integer DEFAULT_POOL_SIZE = 10;
	private static BlockingQueue<Connection> pool;
	private static List<Connection> sourceConnection;
	private ConnectionManager() {
	}
	static {
		initConnectionPool();
	}
	public static Connection getConnection(){
		try {
			return pool.take();
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Помилка при отриманні пула: " + e);
		}
	}
	public static Connection open(){
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new ConnectionCloseException("Помилка при відкритті конекшена: " + e);
		}
	}
	private static void initConnectionPool() {
		var poolSize = DEFAULT_POOL_SIZE;
		var size = Integer.parseInt(String.valueOf(poolSize));

		pool = new ArrayBlockingQueue<>(Integer.parseInt(
		    String.valueOf(Objects.requireNonNull(poolSize))));
		sourceConnection = new ArrayList<>(size);

		for (int i = 0; i < size; i++){
			var connection = open();
			var proxyConnection = (Connection)
			    Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(), new Class[]{Connection.class},
				  (proxy, method, args) -> method.getName().equals("close")
					? pool.add((Connection) proxy)
					: method.invoke(connection, args));
			pool.add(proxyConnection);
			sourceConnection.add(connection);
		}
	}
	public static void closePool(){
		try {
			for (Connection sourceConnection: sourceConnection){
				sourceConnection.close();
			}
		} catch (SQLException e) {
			throw new ConnectionCloseException("Помилка під час закривання пула: " + e);
		}
	}
}
