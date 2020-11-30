package com.company.project.config;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * springboot 2.3版本以后不再支持自动注册
 */
@Component
public class JestClientConfig {

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String elkAddress;

    @Bean
    public io.searchbox.client.JestClient getJestCline()
    {
        JestClientFactory jestClientFactory = new JestClientFactory();
        System.out.print("Elasticsearch 请求地址:"+elkAddress);
        jestClientFactory.setHttpClientConfig(new HttpClientConfig.Builder(elkAddress)
                .multiThreaded(true)
                .build());

        return jestClientFactory.getObject();
    }

}
