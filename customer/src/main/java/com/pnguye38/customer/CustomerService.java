package com.pnguye38.customer;
import com.pnguye38.amqp.RabbitMQMessageProducer;
import com.pnguye38.client.fraud.FraudCheckResponse;
import com.pnguye38.client.fraud.FraudClient;
import com.pnguye38.client.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .email(customerRegistrationRequest.email())
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .build();

        customerRepository.saveAndFlush(customer);
        fraudClient.isFraudster(customer.getId());
        NotificationRequest notificationRequest =
                new NotificationRequest(customer.getId(),
                customer.getEmail(),
                "Hello From Phuc");
        rabbitMQMessageProducer.publish(notificationRequest,
                "internal.exchange",
                        "internal.notification.routing-key");
    }
}
