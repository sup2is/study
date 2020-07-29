package me.sup2is;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrikaTest {

    @Test
    public void orika_mapping() {
        //given
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrderDto.class, Order.class)
                .field("customerName","customer.name")
                .field("shippingStreetAddress", "shippingAddress.street")
                .field("shippingCity", "shippingAddress.city")
                .field("billingStreetAddress", "billingAddress.street")
                .field("billingCity", "billingAddress.city")
                .register();


        Address billingAddress = new Address("경리단길", "서울");
        Address shippingAddress = new Address("광평로", "서울");
        Customer customer = new Customer("sup2is");
        Order order = new Order(customer, billingAddress, shippingAddress);

        //when
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        OrderDto orderDto = mapperFacade.map(order, OrderDto.class);

        //then
        assertEquals(billingAddress.getCity(), orderDto.getBillingCity());
        assertEquals(billingAddress.getStreet(), orderDto.getBillingStreetAddress());
        assertEquals(shippingAddress.getCity(), orderDto.getShippingCity());
        assertEquals(shippingAddress.getStreet(), orderDto.getShippingStreetAddress());
        assertEquals(customer.getName(), orderDto.getCustomerName());
    }

    @Test
    public void orika_map_reverse() {
        //given
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(new MyOrikaConverter());

        Address billingAddress = new Address("경리단길", "서울");
        Address shippingAddress = new Address("광평로", "서울");
        Customer customer = new Customer("sup2is");
        Order order = new Order(customer, billingAddress, shippingAddress);
        BoundMapperFacade<Order, OrderDto> boundMapperFacade = mapperFactory.getMapperFacade(Order.class, OrderDto.class);
        OrderDto orderDto = boundMapperFacade.map(order);

        //when
        Order toOrder = boundMapperFacade.mapReverse(orderDto);

        //then
        assertEquals(orderDto.getBillingCity(), toOrder.getBillingAddress().getCity());
        assertEquals(orderDto.getBillingStreetAddress(), toOrder.getBillingAddress().getStreet());
        assertEquals(orderDto.getCustomerName(), toOrder.getCustomer().getName());
        assertEquals(orderDto.getShippingCity(), toOrder.getShippingAddress().getCity());
        assertEquals(orderDto.getShippingStreetAddress(), toOrder.getShippingAddress().getStreet());
    }
}
