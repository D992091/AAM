package goods1.repo;

import goods1.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;

public interface GoodsRepo extends JpaRepository<Goods, Integer> {
    List<Goods> findAll();
    List<Goods> findAllByName(String name);
    List<Goods> findAllById(Integer id);
    void deleteById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update goods g set g.description = ?1 where g.id = ?2" , nativeQuery = true)
    void changeGoods(String description, Integer id);

}
