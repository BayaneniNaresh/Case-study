package com.bookingMicroservice;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface BookRepositary extends MongoRepository<Book,String> { 

}
