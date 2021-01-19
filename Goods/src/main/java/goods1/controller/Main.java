package goods1.controller;

import goods1.model.Goods;
import goods1.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Map;

@Controller
public class Main {
    @Autowired
    GoodsRepo goodsRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        List<Goods> goods = goodsRepo.findAll();
        model.put("goods", goods);
        return "index";
    }
}