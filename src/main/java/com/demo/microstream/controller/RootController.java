package com.demo.microstream.controller;

import lombok.AllArgsConstructor;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("micro-stream/root")
@AllArgsConstructor
public class RootController {

    private final EmbeddedStorageManager storageManager;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Long saveRoot(@RequestBody String data) {
        return storageManager.store(data);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getRoot() {
        return storageManager.root();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getObject(@PathVariable Long id) {
        return storageManager.getObject(id);
    }

}
