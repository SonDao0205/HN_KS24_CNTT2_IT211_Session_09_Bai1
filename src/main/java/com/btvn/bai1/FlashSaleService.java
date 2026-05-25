package com.btvn.bai1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlashSaleService {
    public void applyDiscount(String userId, String code) {
        log.info("Đang xử lý mã: {} cho user: {}", code, userId);

        try {
            // ... logic nghiệp vụ tại đây ...
            log.info("Áp dụng mã giảm giá thành công cho user: {}", userId);

        } catch (Exception e) {
            log.error("Lỗi nghiêm trọng khi áp dụng mã: {} cho user: {}. Chi tiết: ", code, userId, e);
        }
    }
}