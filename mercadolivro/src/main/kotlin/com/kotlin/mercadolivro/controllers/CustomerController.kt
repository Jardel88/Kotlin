package com.kotlin.mercadolivro.controllers

import com.kotlin.mercadolivro.controllers.request.PostCustomerRequest
import com.kotlin.mercadolivro.controllers.request.PutCustomerRequest
import com.kotlin.mercadolivro.extension.toCustomerModel
import com.kotlin.mercadolivro.model.CustomerModel
import com.kotlin.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAll(): List<CustomerModel>{
        return customerService.getAll()
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){
        customerService.create(customer.toCustomerModel())
    }
    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.getById(id)
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest){
        customerService.update(customer.toCustomerModel(id))
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        customerService.delete(id)
    }

}