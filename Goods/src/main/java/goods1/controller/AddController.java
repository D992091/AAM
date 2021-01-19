package goods1.controller;

import goods1.model.Goods;
import goods1.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.regex.Pattern;

@Controller
public class AddController {
    @Autowired
    GoodsRepo goodsRepo;

    @GetMapping("/add")
    public String add(Map<String,Object> model){
        model.put("error", "");
        return "add";
    }

    @PostMapping("/added")
    public String add(String name, String price, String description, Map<String,Object> model){
        if(goodsRepo.findAllByName(name).isEmpty()){
            try {
                Goods goods = new Goods(name, Double.valueOf(price), description);
                goodsRepo.save(goods);
                return "redirect:/";
            }catch (NumberFormatException nfe){
                model.put("error","Ошибка добавления товара, проверьте введённые данные");
                return "add";
            }
        }else{
            model.put("error","Ошибка добавления товара, проверьте введённые данные");
            return "add";
        }
    }
}

