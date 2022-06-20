package br.com.igorroussenq.asfaliscorp.controller;

import br.com.igorroussenq.asfaliscorp.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condutor")
public class CondutorController {

    @Autowired
    CondutorService condutorService;


}
