package com.project.konsumenview.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.project.konsumenview.models.Konsumen;


@Controller
@RequestMapping("/konsumen")
public class KonsumenViewController {
  private final String backendUrl = "http://localhost:8080/konsumen";

    @GetMapping("/home")
    public String konsumenPage(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Konsumen[] listKonsumen = restTemplate.getForObject(backendUrl + "/getAll", Konsumen[].class);
        model.addAttribute("listKonsumen", listKonsumen);
        return "home";
    }
}
