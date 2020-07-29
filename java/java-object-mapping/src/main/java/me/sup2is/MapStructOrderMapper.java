package me.sup2is;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructOrderMapper {

    MapStructOrderMapper INSTANCE = Mappers.getMapper(MapStructOrderMapper.class);

    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "shippingAddress.street", target = "shippingStreetAddress")
    @Mapping(source = "shippingAddress.city", target = "shippingCity")
    @Mapping(source = "billingAddress.street", target = "billingStreetAddress")
    @Mapping(source = "billingAddress.city", target = "billingCity")
    OrderDto orderToOrderDto(Order order);

    @InheritInverseConfiguration
    Order orderDtoToOrder(OrderDto orderDTO);

}
