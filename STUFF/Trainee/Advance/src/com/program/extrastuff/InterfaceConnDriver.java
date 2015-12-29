package com.program.extrastuff;

import java.util.Scanner;

interface ConnectDb {
	public void connect();

	public void disConnect();

	public void use();
}

class MySQLDriver implements ConnectDb {

	public void connect() {
		System.out.println("CONNECT MYSQL");
	}

	public void disConnect() {
		System.out.println("DISCONNECT MYSQL");
	}

	public void use() {
		System.out.println("USE MYSQL");
	}

}

class OracleDriver implements ConnectDb {

	public void connect() {
		System.out.println("CONNECT ORACLE");
	}

	public void disConnect() {
		System.out.println("DISCONNECT ORACLE");
	}

	public void use() {
		System.out.println("USE ORACLE");
	}

}

public class InterfaceConnDriver {

	public static void main(String[] args) {

		Scanner k = new Scanner(System.in);
		System.out.println("Enter Driver");
		String input = k.next();

		if (input == "oracle") {
			ConnectDb conndb = new OracleDriver();
			conndb.connect();
			conndb.disConnect();
			conndb.use();
		}

		if (input == "mysql") {
			ConnectDb conndb = new MySQLDriver();
			conndb.connect();
			conndb.disConnect();
			conndb.use();
		}
		k.close();

	}
}
