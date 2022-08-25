package com.demo.microstream.service;

import com.demo.microstream.config.DataRoot;
import lombok.AllArgsConstructor;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParamsService {

    private final DataRoot dataRoot;
    private final EmbeddedStorageManager storageManager;

    public String save(String params) {
        dataRoot.setParams(params);
        storageManager.storeRoot();
        return dataRoot.getParams();
    }

    public String getParams() {
        return dataRoot.getParams();
    }
}
