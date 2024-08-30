package com.myproject.core.models.impl;

import com.myproject.core.models.AemPracticeModel;
import com.myproject.core.models.NavigationItem;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AemPracticeModelImpl implements AemPracticeModel {

    @Inject
    private String imagePath;

    @Inject
    private String title;

    @SlingObject
    private Resource resource;

    @Inject
    private boolean isBackground;

    public String getImagePath() {
        return imagePath;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBackground() {
        return isBackground;
    }

    public List<NavigationItem> getNavigationItems() {
        List<NavigationItem> navigationItemList = new ArrayList<>();
        Resource navigationItems = resource.getChild("navigationItems");
        if (navigationItems != null) {
            navigationItems
                    .getChildren()
                    .forEach(item -> navigationItemList.add(new NavigationItem(item)));
        }
        navigationItemList.forEach(item -> item.setTitle("TEST_" + item.getTitle()));
        return navigationItemList;
    }
}
