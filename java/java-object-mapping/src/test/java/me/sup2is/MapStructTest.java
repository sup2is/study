package me.sup2is;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapStructTest {

    @Test
    public void mapstruct_basic() {
        //given
        Address billingAddress = new Address("경리단길", "서울");
        Address shippingAddress = new Address("광평로", "서울");
        Customer customer = new Customer("sup2is");
        Order order = new Order(customer, billingAddress, shippingAddress);

        //when
        OrderDto orderDto = MapStructOrderMapper.INSTANCE.orderToOrderDto(order);

        //then
        assertEquals(billingAddress.getCity(), orderDto.getBillingCity());
        assertEquals(billingAddress.getStreet(), orderDto.getBillingStreetAddress());
        assertEquals(shippingAddress.getCity(), orderDto.getShippingCity());
        assertEquals(shippingAddress.getStreet(), orderDto.getShippingStreetAddress());
        assertEquals(customer.getName(), orderDto.getCustomerName());

    }

    @Test
    public void mapstruct_inverse() {
        //given
        Address billingAddress = new Address("경리단길", "서울");
        Address shippingAddress = new Address("광평로", "서울");
        Customer customer = new Customer("sup2is");
        Order order = new Order(customer, billingAddress, shippingAddress);
        OrderDto orderDto = MapStructOrderMapper.INSTANCE.orderToOrderDto(order);

        //when
        Order toOrder = MapStructOrderMapper.INSTANCE.orderDtoToOrder(orderDto);

        //then
        assertEquals(orderDto.getBillingCity(), toOrder.getBillingAddress().getCity());
        assertEquals(orderDto.getBillingStreetAddress(), toOrder.getBillingAddress().getStreet());
        assertEquals(orderDto.getCustomerName(), toOrder.getCustomer().getName());
        assertEquals(orderDto.getShippingCity(), toOrder.getShippingAddress().getCity());
        assertEquals(orderDto.getShippingStreetAddress(), toOrder.getShippingAddress().getStreet());
    }

}
