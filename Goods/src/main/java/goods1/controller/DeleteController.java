package goods1.controller;

import goods1.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class DeleteController {
    @Autowired
    GoodsRepo goodsRepo;

    @GetMapping("/delete")
    public String delete(Map<String,Object> model){
        model.put("error", "");
        return "delete";
    }

    @PostMapping("/deleted")
    public String delete(String id, Map<String,Object> model){
            if(!goodsRepo.findAllById(Integer.valueOf(id)).isEmpty()){
                goodsRepo.deleteById(Integer.valueOf(id));
            return "redirect:/";
        }else{
            model.put("error","Неверно введён номер товара");
            return "delete";
        }

    }
}
