package com.api.udemuz.services;

import com.api.udemuz.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:52
 */

@Component
@Slf4j
public class BaseService  implements Constants {

    @Autowired
    protected CacheService cacheService;
}
