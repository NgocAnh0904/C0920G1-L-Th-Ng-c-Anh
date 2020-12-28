package service;

import model.CustomerType;
import repository.CustomerTypeRepository;
import repository.CustomerTypeRepositoryImpl;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.getAllCustomerType();
    }
}
