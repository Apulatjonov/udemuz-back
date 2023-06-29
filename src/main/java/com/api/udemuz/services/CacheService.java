package com.api.udemuz.services;

import com.api.udemuz.constant.CacheConstants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:55
 */

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Slf4j
public class CacheService implements CacheConstants {
    CacheManager cacheManager;

    /**
     * To be implemented
     */
}
