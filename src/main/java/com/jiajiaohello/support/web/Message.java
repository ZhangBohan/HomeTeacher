package com.jiajiaohello.support.web;

/**
 * A message to be displayed in web context. Depending on the type, different style will be applied.
 */
public class Message {
    /**
     * Name of the flash attribute.
     */
	public static final String MESSAGE_ATTRIBUTE = "message";

    /**
     * The type of the message to be displayed. The type is used to show message in a different style.
     */
	public static enum Type {
        DANGER, WARNING, INFO, SUCCESS;
	}

	private final String message;
	private final Type type;

	public Message(String message, Type type) {
		this.message = message;
		this.type = type;
	}
	
	public Message(String message, Type type, Object... args) {
		this.message = String.format(message, args);
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public Type getType() {
		return type;
	}
}
