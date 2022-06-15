package cn.devlau.springcloud.controller;

import cn.devlau.springcloud.entity.CommonResult;
import cn.devlau.springcloud.entity.Payment;
import cn.devlau.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lau
 * @Date 2022/6/14
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入结果 ：{}",i);
        if(i>0){
            return new CommonResult<>(200,"成功"+ serverPort,payment);
        }else{
            return new CommonResult<>(400,"失败");
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：{}",payment);
        if(payment != null){
            return new CommonResult<>(200,"成功"+ serverPort,payment);
        }else{
            return new CommonResult<>(400,"失败");
        }
    }
}
