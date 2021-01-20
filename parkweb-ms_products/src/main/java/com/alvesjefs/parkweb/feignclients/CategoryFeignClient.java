package com.alvesjefs.parkweb.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "ms-categories", path = "api/categories")
@Component
public interface CategoryFeignClient {

}
