package com.demo.microstream.controller;

import com.demo.microstream.config.DataRoot;
import com.demo.microstream.service.ParamsService;
import lombok.AllArgsConstructor;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("micro-stream/params")
@AllArgsConstructor
public class ParamsController {

    private final ParamsService paramsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getParams() {
        return paramsService.getParams();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveParams(@RequestBody String params) {
        return paramsService.save(params);
    }
}
