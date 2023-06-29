package com.api.udemuz.repositories;

import com.api.udemuz.constant.CacheConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:25
 */


@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, CacheConstants {
}
