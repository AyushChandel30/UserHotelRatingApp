package yahu.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import yahu.in.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
