package com.shosha.springboot.demo.dao.addressrepository;

import com.shosha.springboot.demo.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for managing Address entities.
 * Provides CRUD operations and additional methods for managing
 * addresses in the system.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

}
