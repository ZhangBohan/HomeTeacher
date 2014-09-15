package com.jiajiaohello.support.auth;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author mei
 *
 */
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {
	private final MessageDigest messageDigest;

	public PasswordEncoder() {
		this("MD5");
	}

	/**
	 * @param algorithm
	 */
	public PasswordEncoder(String algorithm) {
		try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No such hashing algorithm", e);
        }
	}

	private String encode(CharSequence rawPassword, String salt){
		byte[] input = Utf8.encode(salt + rawPassword);
		byte[] digest = messageDigest.digest(input);
		return messageDigest.getAlgorithm().toLowerCase()+"$"+salt+"$"+new String(Hex.encode(digest));
	}
	
	@Override
	public String encode(CharSequence rawPassword) {
		String salt =  RandomStringUtils.randomAlphanumeric(12);
		return encode(rawPassword, salt);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String salt = StringUtils.split(encodedPassword, "$")[1];
		return StringUtils.equals(encode(rawPassword, salt), encodedPassword);
	}

}
