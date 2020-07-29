package me.sup2is;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class MyOrikaConverter extends BidirectionalConverter<Order, OrderDto> {
    @Override
    public OrderDto convertTo(Order source, Type<OrderDto> destinationType, MappingContext mappingContext) {
        return new OrderDto(source.getCustomer().getName(),
                source.getShippingAddress().getStreet(),
                source.getShippingAddress().getCity(),
                source.getBillingAddress().getStreet(),
                source.getBillingAddress().getCity());
    }

    @Override
    public Order convertFrom(OrderDto source, Type<Order> destinationType, MappingContext mappingContext) {
        return new Order(new Customer(source.getCustomerName()),
                new Address(source.getBillingStreetAddress(), source.getBillingCity()),
                new Address(source.getShippingStreetAddress(), source.getShippingCity()));
    }
}
