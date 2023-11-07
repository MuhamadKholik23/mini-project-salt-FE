package com.project.konsumenview.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.konsumenview.models.Konsumen;
import com.project.konsumenview.models.KonsumenFilter;


@Controller
@RequestMapping("/konsumen")
public class KonsumenViewController {
  private final String backendUrl = "http://localhost:8080/konsumen";

    @GetMapping("/home")
    public String konsumenPage(Model model, KonsumenFilter f) {
      RestTemplate restTemplate = new RestTemplate();
      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(backendUrl + "/getAll")
        .queryParam("nama", f.getNama())
        .queryParam("kota", f.getKota());

      Konsumen[] listKonsumen = restTemplate.getForObject(builder.toUriString(), Konsumen[].class);
      model.addAttribute("listKonsumen", listKonsumen);
      return "home";
    }
}
