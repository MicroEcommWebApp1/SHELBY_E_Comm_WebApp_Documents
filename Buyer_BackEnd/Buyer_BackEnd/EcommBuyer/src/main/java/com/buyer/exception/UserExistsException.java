package com.buyer.exception;

public class UserExistsException extends Exception {
		String msg="already exists";

		public UserExistsException() {
			super();
		}

		public UserExistsException(String msg) {
			super(msg);
			
		}
}
