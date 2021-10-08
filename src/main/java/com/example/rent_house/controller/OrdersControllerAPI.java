package com.example.rent_house.controller;

import com.example.rent_house.models.ApartmentDayInOrder;
import com.example.rent_house.models.Orders;
import com.example.rent_house.service.orders.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
@CrossOrigin("*")
public class OrdersControllerAPI {
    @Autowired
    private IOrdersService iOrdersService;

//    @Autowired
//    private IApartmentDayInOrder apartmentDayInOrder;

    private final long oneDay = 86400000;
    @GetMapping("")
    public ResponseEntity<Iterable<Orders>> findAll(){
        return new ResponseEntity<>(iOrdersService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Orders> create (@RequestBody Orders order){
        order.setCheckIn(false);
        order.setOrderStatus("Pending");
        long startDate = order.getStartDate().getTime();
        long endDate = order.getEndDate().getTime();
        for(long i = startDate; i < endDate; i+=oneDay) {
            Date newDay = new Date(i);
            ApartmentDayInOrder dayInOrder = new ApartmentDayInOrder();
//            dayInOrder.setDayInOrder(newDay);
//            dayInOrder.setDayInOrderApartment(order.getApartment());
//            apartmentDayInOrder.save(dayInOrder);
        }
        iOrdersService.save(order);
        return new ResponseEntity<>(iOrdersService.save(order),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> update(@PathVariable Long id,@RequestBody Orders order) {
        Optional<Orders> optionalOrder = iOrdersService.findById(id);
        if(!optionalOrder.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.setId(optionalOrder.get().getId());
        iOrdersService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> delete(@PathVariable Long id){
        Optional<Orders> optionalOrder = iOrdersService.findById(id);
        if(!optionalOrder.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iOrdersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByApartment/{apartmentId}")
    public ResponseEntity<Iterable<Orders>> findAllByApartmentId(@PathVariable long apartmentId) {
        return new ResponseEntity<>(iOrdersService.findAllByApartmentId(apartmentId),HttpStatus.OK);
    }
    @GetMapping("/findByUser/{userId}")
    public ResponseEntity<Iterable<Orders>> findAllByUserId(@PathVariable long userId) {
        return new ResponseEntity<>(iOrdersService.findAllByUserId(userId),HttpStatus.OK);
    }
    @GetMapping("/findOrderPending/{apartmentId}")
    public ResponseEntity<Iterable<Orders>> findAllByStatusAndApartment(@PathVariable long apartmentId) {
        return new ResponseEntity<>(iOrdersService.findAllOrderOfApartmentWithPending(apartmentId),HttpStatus.OK);

//        @GetMapping("/get/{id}")
//        public ResponseEntity<Iterable<Orders>> findByUserId(@PathVariable Long id){
//            return new ResponseEntity<>(iOrdersService.findAllByUserId(id), HttpStatus.OK);
//        }

//        @GetMapping("/get-apartment/{apartmentID}")
//        public ResponseEntity<Iterable<Orders> findByApartmentID(@PathVariable Long apartmentID){
//            return new ResponseEntity<>(iOrdersService.findAllByApartment(apartmentID), HttpStatus.OK);
//        }

    }
}
