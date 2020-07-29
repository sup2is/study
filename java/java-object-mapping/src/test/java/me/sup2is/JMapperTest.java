package me.sup2is;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.junit.Test;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static org.junit.Assert.assertEquals;

public class JMapperTest {

    @Test
    public void jmapper_using_api() {
        //given
        JMapperAPI jMapperAPI = new JMapperAPI()
                .add(JMapperAPI.mappedClass(OrderDto.class)
                        .add(attribute("customerName").value("${customer.name}"))
                        .add(attribute("shippingStreetAddress").value("${shippingAddress.street}"))
                        .add(attribute("shippingCity").value("${shippingAddress.city}"))
                        .add(attribute("billingStreetAddress").value("${billingAddress.street}"))
                        .add(attribute("billingCity").value("${billingAddress.city}")));

        JMapper<OrderDto, Order> orderMapper = new JMapper<>(OrderDto.class, Order.class, jMapperAPI);
        Address billingAddress = new Address("경리단길", "서울");
        Address shippingAddress = new Address("광평로", "서울");
        Customer customer = new Customer("sup2is");
        Order order = new Order(customer, billingAddress, shippingAddress);

        //when
        OrderDto orderDto = orderMapper.getDestination(order);

        //then
        assertEquals(billingAddress.getCity(), orderDto.getBillingCity());
        assertEquals(billingAddress.getStreet(), orderDto.getBillingStreetAddress());
        assertEquals(shippingAddress.getCity(), orderDto.getShippingCity());
        assertEquals(shippingAddress.getStreet(), orderDto.getShippingStreetAddress());
        assertEquals(customer.getName(), orderDto.getCustomerName());
    }

    @Test
    public void jmapper_using_annotation() {
        JMapper<JMapperOrderDto, Order> orderMapper = new JMapper<>(JMapperOrderDto.class, Order.class);
        Address billingAddress = new Address("경리단길", "서울");
        Address shippingAddress = new Address("광평로", "서울");
        Customer customer = new Customer("sup2is");
        Order order = new Order(customer, billingAddress, shippingAddress);

        //when
        JMapperOrderDto orderDto = orderMapper.getDestination(order);

        //then
        assertEquals(billingAddress.getCity(), orderDto.getBillingCity());
        assertEquals(billingAddress.getStreet(), orderDto.getBillingStreetAddress());
        assertEquals(shippingAddress.getCity(), orderDto.getShippingCity());
        assertEquals(shippingAddress.getStreet(), orderDto.getShippingStreetAddress());
        assertEquals(customer.getName(), orderDto.getCustomerName());
    }

}
