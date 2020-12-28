package service;

import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;


import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer selectCustomer(String id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }
}
