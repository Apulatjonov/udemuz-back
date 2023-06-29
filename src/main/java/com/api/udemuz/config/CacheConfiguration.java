package com.api.udemuz.config;

import com.api.udemuz.constant.CacheConstants;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:56
 */

@Configuration
@EnableCaching
public class CacheConfiguration implements CacheConstants {
    private GitProperties gitProperties;
    private BuildProperties buildProperties;

    /**
     * To be implemented
     */
}
