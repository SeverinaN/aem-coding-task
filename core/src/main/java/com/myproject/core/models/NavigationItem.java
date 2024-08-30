package com.myproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class NavigationItem {

    @Inject
    private String title;

    @Inject
    private String path;

    public NavigationItem(Resource resource) {
        if (resource != null) {
            this.title = resource.getValueMap().get("title", String.class);
            this.path = resource.getValueMap().get("path", String.class);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }
}
