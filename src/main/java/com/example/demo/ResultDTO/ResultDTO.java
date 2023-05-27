package com.example.demo.ResultDTO;

public class ResultDTO<T> {
	private T data;
	private String message;
	private boolean isStatus;

	public ResultDTO() {
		super();
	}

	public ResultDTO(boolean isStatus, T data, String message) {
		super();
		this.data = data;
		this.message = message;
		this.isStatus = isStatus;
	}

	public ResultDTO(boolean isStatus, String message) {
		super();
		this.message = message;
		this.isStatus = isStatus;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public boolean isStatus() {
		return isStatus;
	}
}
