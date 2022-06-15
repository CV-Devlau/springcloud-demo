package cn.devlau.springcloud.service;

import cn.devlau.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * @author lau
 * @Date 2022/6/14
 */
@Service
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById( Long id);
}
