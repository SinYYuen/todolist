package org.generation.Todolist.controller;


import org.generation.todolist.controller.dto.CustomerDTO;
import org.generation.todolist.repository.entity.Customer;
import org.generation.todolist.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Todo")
public class TodoController {

    private final CustomerService customerService;


    public CustomerController(@Autowired CustomerService customerService){

        this.customerService = customerService;
    }


    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Customer> getCustomer(){

        return customerService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="name", required = true) String name,
                       @RequestParam(name="mobile", required = true) Integer mobile) throws IOException
    {


        //String fullPath = imageFolder + "/" + imageUrl;
        CustomerDTO customerDTO = new CustomerDTO(name, mobile);
        customerService.save(new Customer(customerDTO));

//        System.out.println("In all");
    }


    @CrossOrigin
    @PostMapping("/update")
    public void update(  @RequestParam(name="id", required = true) Integer id,
                         @RequestParam(name="name", required = true) String name,
                         @RequestParam(name="mobile", required = true) Integer mobile) throws IOException
    {


        //String fullPath = imageFolder + "/" + imageUrl;
        CustomerDTO customerDTO = new CustomerDTO(name, mobile);
        Customer customer = new Customer(customerDTO);
        customer.setId(id);
        customerService.save(customer);

        System.out.println("In update");
    }




    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void del(@PathVariable Integer id) throws IOException
    {
        customerService.delete(id);
        System.out.println("In delete");
    }


    @CrossOrigin
    @GetMapping( "/{id}" )
    public Customer findItemById( @PathVariable Integer id )
    {
        System.out.println("In Find");
        return customerService.findById(id);

    }


}
