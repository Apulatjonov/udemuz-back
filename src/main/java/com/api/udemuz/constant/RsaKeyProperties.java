package com.api.udemuz.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * The RsaKeyProperties record uses to bind and validate RSAPublicKey public and private keys.
 * @param publicKey locates in the resources folder
 * @param privateKey locates in the resources folder
 */
@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {

}
