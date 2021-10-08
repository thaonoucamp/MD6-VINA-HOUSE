package com.example.rent_house.service.apartmentDayInOrder;

import com.example.rent_house.models.ApartmentDayInOrder;
import com.example.rent_house.service.IGenericService;

public interface IApartmentDayInOrderService extends IGenericService<ApartmentDayInOrder> {
    Iterable<ApartmentDayInOrder> findAllByApartmentId(long apartmentId);
}
