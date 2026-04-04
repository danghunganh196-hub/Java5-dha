package vn.fpoly.java5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpoly.java5.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
}
